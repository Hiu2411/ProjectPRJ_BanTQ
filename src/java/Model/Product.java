/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author DINH
 */
public class Product {

    public Product(int productId, String productName, double price, int size, String color, int typeId, int status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.size = size;
        this.color = color;
        this.typeId = typeId;
        this.status = status;
       
    }

    public Product() {
    }
    private int productId;
    private String productName;
    private double price;
    private int size;
    private String color;
    private int typeId;
    private int status;
    /**
     * 
     * @return 
     */

  
    public int getStatus() {
        return status;
    }

   
    public void setStatus(int status) throws ProductException {
        if (status < 0) {
            throw new ProductException("Product status must be greater than 0.");
        } else {
            this.status = status;
        }

    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int pId) throws ProductException {
        if (pId < 0) {
            throw new ProductException("Product ID must be greater than 0.");//display warning message
        } else {
            this.productId = pId;
        }

    }

    
    public String getProductName() {
        return productName;
    }

    
    public void setProductName(String name) throws ProductException {
        if (name.equals("")) {
            throw new ProductException("Name can't be empty.");//display warning message
        } else {
            this.productName = name;
        }

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws ProductException {
        if (price < 0) {
            throw new ProductException("Price must be greater than 0.");
        } else {
            this.price = price;
        }

    }

    public int getSize() {
        return size;
    }

   
    public void setSize(int size) throws ProductException {
        if (size < 0) {
            throw new ProductException("Size must be greater than 0.");//display warning message
        } else {
            this.size = size;
        }

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) throws ProductException {
        if (color.equals("")) {
            throw new ProductException("Color can't be empty.");//display warning message
        } else {
            this.color = color;
        }

    }

    public int getTypeId() {
        return typeId;
    }

   
    public void setTypeId(int typeId) throws ProductException {
        if (typeId < 0) {
            throw new ProductException("Type Product ID must be greater than 0.");//display warning message
        } else {
            this.typeId= typeId;
        }

    }

  
}
