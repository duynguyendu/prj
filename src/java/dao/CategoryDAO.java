/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.CategoryDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author duy
 */
import java.util.List;

public class CategoryDAO implements CRUD<CategoryDTO> {

    private final String GET = "SELECT Name FROM tblCategory WHERE CategoryID=?";
    private final String GET_ALL = "SELECT CategoryID, Name FROM tblCategory";
    private final String ADD = "INSERT INTO tblCatetory (Name) VALUES (?)";

    @Override
    public CategoryDTO getByID(Integer id) {
        Connection cn = null;
        PreparedStatement ps = null;
        CategoryDTO category = null;
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(GET);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("Name");
                    category = new CategoryDTO(id, name);
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
        return category;
    }

    @Override
    public List<CategoryDTO> getAll() {
        Connection cn = null;
        PreparedStatement ps = null;
        List<CategoryDTO> list = new ArrayList<CategoryDTO>();
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Integer categoryID = rs.getInt("CategoryID");
                    String name = rs.getString("Name");
                    CategoryDTO product = new CategoryDTO(categoryID, name);
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
    public CategoryDTO add(CategoryDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(List<CategoryDTO> entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(CategoryDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
