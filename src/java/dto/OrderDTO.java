/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.sql.Date;

/**
 *
 * @author duy
 */
public class OrderDTO {
    private Integer orderID;
    private Integer userID;
    private Date orderDate;
    private Integer total;
    private Integer status;

    public OrderDTO() {
    }

    public OrderDTO(Integer userID, Date orderDate, Integer total, Integer status) {
        this.userID = userID;
        this.orderDate = orderDate;
        this.total = total;
        this.status = status;
    }

    public OrderDTO(Integer orderID, Integer userID, Date orderDate, Integer total, Integer status) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDate = orderDate;
        this.total = total;
        this.status = status;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
