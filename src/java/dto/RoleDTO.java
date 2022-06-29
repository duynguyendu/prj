/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author duy
 */
public class RoleDTO {
    private Integer roleID;
    private String roleName;

    public RoleDTO() {
    }

    public RoleDTO(Integer roleID, String roleName) {
        this.roleID = roleID;
        this.roleName = roleName;
    }
    

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    
}
