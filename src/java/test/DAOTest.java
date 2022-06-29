/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dao.UserDAO;
import dto.UserDTO;

/**
 *
 * @author duy
 */
public class DAOTest {
    public static void UserDAOTest() {
        UserDAO userDAO = new UserDAO();
        UserDTO user = new UserDTO(0, "duy", "duy", "duy@gmail.com", "123", "1234", "", 1, 1);
        userDAO.add(user);
    }
}
