/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author duy
 */
public class OrderDetailDTO {

    private Integer detailID;
    private Integer orderID;
    private Integer productID;
    private Integer price;
    private Integer quanity;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(Integer orderID, Integer productID, Integer price, Integer quanity) {
        this.orderID = orderID;
        this.productID = productID;
        this.price = price;
        this.quanity = quanity;
    }

    public OrderDetailDTO(Integer detailID, Integer orderID, Integer productID, Integer price, Integer quanity) {
        this.detailID = detailID;
        this.orderID = orderID;
        this.productID = productID;
        this.price = price;
        this.quanity = quanity;
    }

    public Integer getDetailID() {
        return detailID;
    }

    public void setDetailID(Integer detailID) {
        this.detailID = detailID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuanity() {
        return quanity;
    }

    public void setQuanity(Integer quanity) {
        this.quanity = quanity;
    }

    
}
