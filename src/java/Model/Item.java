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
public class Item {

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Item(int productId, String productName, double price, int size, String color, int typeId, int quality, double total) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.size = size;
        this.color = color;
        this.typeId = typeId;
        this.quality = quality;
        this.total = total;
    }
 
    public Item() {
    }
    private int productId;
    private String productName;
    private double price;
    private int size;
    private String color;
    private int typeId;
    private int quality;
    private double total;
}
