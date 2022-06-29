/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author duy
 */
public class ProductDTO {

    private Integer productID;
    private String name;
    private Integer price;
    private Integer quanity;
    private String description;
    private Integer categoryID;
    private Integer status;

    public ProductDTO() {
    }

    public ProductDTO(String name, Integer price, Integer quanity, String description, Integer categoryID, Integer status) {
        this.name = name;
        this.price = price;
        this.quanity = quanity;
        this.description = description;
        this.categoryID = categoryID;
        this.status = status;
    }

    public ProductDTO(Integer productID, String name, Integer price, Integer quanity, String description, Integer categoryID, Integer status) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quanity = quanity;
        this.description = description;
        this.categoryID = categoryID;
        this.status = status;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
