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
public class Image{

    public Image(int imageId, String imageLink, int productId) {
        this.imageId = imageId;
        this.imageLink = imageLink;
        this.productId = productId;
    }

    public Image() {
    }
    private int imageId;//image ID
    private String imageLink;//image link
    private int productId;//product ID

  
    public int getImage_id() {
        return imageId;
    }

  
    public void setImage_id(int imageId) throws ImageException {
        if (imageId< 0) {
            throw new ImageException("Image ID must be greater than 0.");
        } else {
            this.imageId = imageId;
        }

    }

   
    public String getImagelink() {
        return imageLink;
    }

    public void setImage_link(String imageLink) throws ImageException {
        if (imageLink.equals("")) {
            throw new ImageException("Image Link can't be empty.");
        } else {
            this.imageLink = imageLink;
        }

    }

  
    public int getproductId() {
        return productId;
    }

    public void setproductId(int productId) throws ImageException {
        if (this.productId< 0) {
            throw new ImageException("Product ID must be greater than 0.");
        } else {
            this.productId = productId;
        }

    }

}
