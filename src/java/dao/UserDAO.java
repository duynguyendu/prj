/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duy
 */
public class UserDAO implements CRUD<UserDTO> {

    private final String GET = "SELECT FirstName, LastName, Email, PhoneNumber, Address, RoleID, Status FROM tblUser WHERE UserID=?";
    private final String GET_ALL = "SELECT UserID, FirstName, LastName, Email, PhoneNumber, Address, RoleID, Status FROM tblUser";
    private final String GET_BY_EMAIL_PASSWORD = "SELECT UserID, FirstName, LastName, PhoneNumber, Address, RoleID, Status FROM tblUser WHERE Email=? AND Password=?";
    private final String ADD = "INSERT INTO tblUser(FirstName, LastName, Email, Password, PhoneNumber, Address, RoleID) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE_INFO = "UPDATE tblUser SET FirstName=?, LastName=?, PhoneNumber=?, Address=? WHERE UserID=?";
    private final String UPDATE_PASSWORD = "Update tblUser SET Password=? WHERE UserID=?";
    private final String CHECK = "SELECT UserID FROM tblUser WHERE UserID=? AND Password=?";

    @Override
    public UserDTO getByID(Integer id) {
        Connection cn = null;
        PreparedStatement ps = null;
        UserDTO user = null;
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(GET);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");
                    String email = rs.getString("Email");
                    String phoneNumber = rs.getString("PhoneNumber");
                    String address = rs.getString("Address");
                    Integer roleID = rs.getInt("RoleID");
                    Integer status = rs.getInt("Status");
                    user = new UserDTO(id, firstName, lastName, email, "***", phoneNumber, address, roleID, status);
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
        return user;
    }

    public UserDTO getByEmailAndPassword(String email, String password) {
        Connection cn = null;
        PreparedStatement ps = null;
        UserDTO user = null;
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(GET_BY_EMAIL_PASSWORD);
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Integer id = rs.getInt("UserID");
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");
                    String phoneNumber = rs.getString("PhoneNumber");
                    String address = rs.getString("Address");
                    Integer roleID = rs.getInt("RoleID");
                    Integer status = rs.getInt("Status");
                    user = new UserDTO(id, firstName, lastName, email, "***", phoneNumber, address, roleID, status);
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
        return user;
    }

    @Override
    public List<UserDTO> getAll() {
        Connection cn = null;
        PreparedStatement ps = null;
        List<UserDTO> list = new ArrayList<UserDTO>();
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Integer id = rs.getInt("UserID");
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");
                    String email = rs.getString("Email");
                    String phoneNumber = rs.getString("PhoneNumber");
                    String address = rs.getString("Address");
                    Integer roleID = rs.getInt("RoleID");
                    Integer status = rs.getInt("Status");
                    UserDTO user = new UserDTO(id, firstName, lastName, email, "***", phoneNumber, address, roleID, status);
                    list.add(user);
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
    public UserDTO add(UserDTO entity) {
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(ADD, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, entity.getFirstName());
                ps.setString(2, entity.getLastName());
                ps.setString(3, entity.getEmail());
                ps.setString(4, entity.getPassword());
                ps.setString(5, entity.getPhoneNumber());
                ps.setString(6, entity.getAddress());
                ps.setInt(7, entity.getRoleID());
                int affectedRow = ps.executeUpdate();
                if (affectedRow != 0) {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                        entity.setUserID(rs.getInt(1));
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
    public boolean addAll(List<UserDTO> entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean updateInfo(Integer userID, String firstName, String lastName, String address, String phoneNumber) {
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(UPDATE_INFO);
                ps.setString(1, firstName);
                ps.setString(2, lastName);
                ps.setString(3, phoneNumber);
                ps.setString(4, address);
                ps.setInt(5, userID);
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

    public boolean updatePassword(Integer userID, String password) {
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(UPDATE_PASSWORD);
                ps.setString(1, password);
                ps.setInt(2, userID);
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

    public boolean check(Integer userID, String password) {
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = utils.DBUtil.getConnection();
            if (cn != null) {
                ps = cn.prepareStatement(CHECK);
                ps.setInt(1, userID);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
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

    @Override
    public boolean delete(UserDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
