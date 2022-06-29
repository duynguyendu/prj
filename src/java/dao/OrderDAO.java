/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.OrderDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duy
 */
public class OrderDAO implements CRUD<OrderDTO> {

    private final String GET = "SELECT UserID, OrderDate, Total, Status FROM tblOrder WHERE OrderID=?";
    private final String GET_USERID = "SELECT OrderID, OrderDate, Total, Status FROM tblOrder WHERE UserID=?";
    private final String GET_AVAILABLE = "SELECT OrderID, OrderDate, Total FROM tblOrders WHERE UserID=? AND Status=1";
    private final String ADD = "INSERT INTO tblOrder (UserID, OrderDate, Total) VALUES (?, ?, ?)";

    @Override
    public OrderDTO getByID(Integer id) {
        Connection cn = null;
        PreparedStatement ps = null;
        OrderDTO order = null;
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(GET);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Integer userID = rs.getInt("UserID");
                    Date date = rs.getDate("OrderDate");
                    Integer total = rs.getInt("Total");
                    Integer status = rs.getInt("status");
                    order = new OrderDTO(id, userID, date, total, status);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return order;
    }

    public List<OrderDTO> getByUserID(Integer userID) {
        Connection cn = null;
        PreparedStatement ps = null;
        List<OrderDTO> list = new ArrayList<OrderDTO>();
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(GET_USERID);
                ps.setInt(1, userID);
                ResultSet rs = ps.executeQuery();
                OrderDTO order = null;
                while (rs.next()) {
                    Integer orderID = rs.getInt("OrderID");
                    Date date = rs.getDate("OrderDate");
                    Integer total = rs.getInt("Total");
                    Integer status = rs.getInt("Status");
                    order = new OrderDTO(orderID, userID, date, total, status);
                    list.add(order);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public List<OrderDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OrderDTO add(OrderDTO entity) {
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(ADD);
                ps.setInt(1, entity.getUserID());
                ps.setDate(2, entity.getOrderDate());
                ps.setInt(3, entity.getTotal());
                int affectedRow = ps.executeUpdate();
                if (affectedRow != 0) {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                        entity.setOrderID(rs.getInt(1));
                        return entity;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean addAll(List<OrderDTO> entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(OrderDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
