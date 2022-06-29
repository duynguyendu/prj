/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.OrderDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duy
 */
public class OrderDetailDAO implements CRUD<OrderDetailDTO> {

    private final String GET = "SELECT OrderID, ProductID, Price, Quanity FROM tblOrderDetail WHRER DetailID=?";
    private final String GET_ORDERID = "SELECT DetailID, ProductID, Price, Quanity FROM tblOrderDetail WHERE OrderID=?";
    private final String ADD = "INSERT INTO tblOrderDetail (OrderID, ProductID, Price, Quanity) VALUES (?, ?, ?, ?)";

    @Override
    public OrderDetailDTO getByID(Integer id) {
        Connection cn = null;
        PreparedStatement ps = null;
        OrderDetailDTO orderDetail = null;
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(GET);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Integer orderID = rs.getInt("OrderID");
                    Integer productID = rs.getInt("ProductID");
                    Integer price = rs.getInt("Price");
                    Integer quanity = rs.getInt("Quanity");
                    orderDetail = new OrderDetailDTO(id, orderID, productID, price, quanity);
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
        return orderDetail;
    }

    public List<OrderDetailDTO> getByOrderID(Integer orderID) {
        Connection cn = null;
        PreparedStatement ps = null;
        List<OrderDetailDTO> list = new ArrayList<OrderDetailDTO>();
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(GET_ORDERID);
                ps.setInt(1, orderID);
                ResultSet rs = ps.executeQuery();
                OrderDetailDTO orderDetail = null;
                while (rs.next()) {
                    Integer orderDetailID = rs.getInt("OrderDetailID");
                    Integer productID = rs.getInt("ProductID");
                    Integer price = rs.getInt("Price");
                    Integer quanity = rs.getInt("Quanity");
                    orderDetail = new OrderDetailDTO(orderDetailID, orderID, productID, price, quanity);
                    list.add(orderDetail);
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
    public List<OrderDetailDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OrderDetailDTO add(OrderDetailDTO entity) {

        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(ADD);
                ps.setInt(1, entity.getOrderID());
                ps.setInt(2, entity.getProductID());
                ps.setInt(3, entity.getPrice());
                ps.setInt(4, entity.getQuanity());
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
    public boolean addAll(List<OrderDetailDTO> entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(OrderDetailDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
