/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.ProductDTO;
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
public class ProductDAO implements CRUD<ProductDTO> {

    private final String GET = "SELECT Name, Price, Quanity, Description, CategoryID, Status FROM tblProduct WHERE ProductID=?";
    private final String GET_NAME = "SELECT ProductID, Name, Price, Quanity, Description, CategoryID FROM tblProduct WHERE Name LIKE ? AND STATUS=1";
    private final String GET_ALL = "SELECT ProductID, Name, Price, Quanity, Description, CategoryID, Status FROM tblProduct";
    private final String GET_ALL_AVAILABLE = "SELECT ProductID, Name, Price, Quanity, Description, CategoryID FROM tblProduct WHERE Status = 1";
    private final String ADD = "INSERT INTO tblProduct (Name, Price, Quanity, Description, CategoryID) VALUES (?, ?, ?, ?, ?)";
    private final String DELETE = "UPDATE tblProduct SET Status=0 WHERE ProductID=?";
    private final String UPDATE = "UPDATE tblProduct SET Name=?, Price=?, Quanity=?, Description=?, CategoryID=? WHERE ProductID=?";

    @Override
    public ProductDTO getByID(Integer id) {
        Connection cn = null;
        PreparedStatement ps = null;
        ProductDTO product = null;
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(GET);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("Name");
                    Integer price = rs.getInt("Price");
                    Integer quanity = rs.getInt("Quanity");
                    String description = rs.getString("Description");
                    Integer categoryID = rs.getInt("CategoryID");
                    Integer status = rs.getInt("Status");
                    product = new ProductDTO(id, name, price, quanity, description, categoryID, status);
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
        return product;
    }

    @Override
    public List<ProductDTO> getAll() {
        Connection cn = null;
        PreparedStatement ps = null;
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Integer productID = rs.getInt("ProductID");
                    String name = rs.getString("Name");
                    Integer price = rs.getInt("Price");
                    Integer quanity = rs.getInt("Quanity");
                    String description = rs.getString("Description");
                    Integer categoryID = rs.getInt("CategoryID");
                    Integer status = rs.getInt("Status");
                    ProductDTO product = new ProductDTO(productID, name, price, quanity, description, categoryID, status);
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

    public List<ProductDTO> getAllAvailable() {
        Connection cn = null;
        PreparedStatement ps = null;
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(GET_ALL_AVAILABLE);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Integer productID = rs.getInt("ProductID");
                    String name = rs.getString("Name");
                    Integer price = rs.getInt("Price");
                    Integer quanity = rs.getInt("Quanity");
                    String description = rs.getString("Description");
                    Integer categoryID = rs.getInt("CategoryID");
                    ProductDTO product = new ProductDTO(productID, name, price, quanity, description, categoryID, 1);
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

    public List<ProductDTO> getByName(String searchName) {
        Connection cn = null;
        PreparedStatement ps = null;
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(GET_NAME);
                ps.setString(1, "%" + searchName + "%");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Integer productID = rs.getInt("ProductID");
                    String name = rs.getString("Name");
                    Integer price = rs.getInt("Price");
                    Integer quanity = rs.getInt("Quanity");
                    String description = rs.getString("Description");
                    Integer categoryID = rs.getInt("CategoryID");
                    ProductDTO product = new ProductDTO(productID, name, price, quanity, description, categoryID, 1);
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
    public ProductDTO add(ProductDTO entity) {

        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(ADD);
                ps.setString(1, entity.getName());
                ps.setInt(2, entity.getPrice());
                ps.setInt(3, entity.getQuanity());
                ps.setString(4, entity.getDescription());
                ps.setInt(5, entity.getCategoryID());
                int affectedRow = ps.executeUpdate();
                if (affectedRow != 0) {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                        entity.setProductID(rs.getInt(1));
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
    public boolean addAll(List<ProductDTO> entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(ProductDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean delete(Integer id) {
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(DELETE);
                ps.setInt(1, id);
                int affectedRow = ps.executeUpdate();
                if (affectedRow != 0) {
                    return true;
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
        return false;
    }

    public boolean update(ProductDTO entity) {

        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(UPDATE);
                ps.setString(1, entity.getName());
                ps.setInt(2, entity.getPrice());
                ps.setInt(3, entity.getQuanity());
                ps.setString(4, entity.getDescription());
                ps.setInt(5, entity.getCategoryID());
                ps.setInt(6, entity.getProductID());
                int affectedRow = ps.executeUpdate();
                if (affectedRow != 0) {
                    return true;
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
        return false;
    }
}
