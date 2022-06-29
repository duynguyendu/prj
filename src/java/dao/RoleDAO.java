/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.RoleDTO;
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
public class RoleDAO implements CRUD<RoleDTO> {

    private final String GET_ALL = "SELECT RoleID, RoleName FROM tblRole";
    private final String GET = "SELECT RoleName FROM tblRole WHERE RoleID=?";

    @Override
    public RoleDTO getByID(Integer id) {
        Connection cn = null;
        PreparedStatement ps = null;
        RoleDTO role = null;
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(GET);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("RoleName");
                    role = new RoleDTO(id, name);
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
        return role;
    }

    @Override
    public List<RoleDTO> getAll() {
        Connection cn = null;
        PreparedStatement ps = null;
        List<RoleDTO> list = new ArrayList<RoleDTO>();
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Integer id = rs.getInt("RoleID");
                    String name = rs.getString("RoleName");
                    RoleDTO product = new RoleDTO(id, name);
                    list.add(product);
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
    public RoleDTO add(RoleDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(List<RoleDTO> entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(RoleDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
