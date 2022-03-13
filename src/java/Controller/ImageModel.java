/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import MyUtils.ConnectionLib;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Image;

/**
 *
 * @author hieuh
 */
public class ImageModel {
//declare variables

    ConnectionLib cn = new ConnectionLib();
    Connection con;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private String query;
    private ArrayList<Image> image;

    public ImageModel() throws SQLException {
        con = null;
        pst = null;
        st = null;
        rs = null;
        image = new ArrayList<>();
        con = cn.getConnectDB();
        st = con.createStatement();
    }

    public ArrayList<Image> loadImage() {
        image = new ArrayList<>();
        query = "SELECT * FROM `image`";
        try {
            rs = st.executeQuery(query);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int imgId = rs.getInt("imageId");
                    String imgLink = rs.getString("imageLink");
                    int pId = rs.getInt("productId");
                    image.add(new Image(imgId, imgLink, pId));
                }
            }
        } catch (SQLException e) {
            System.out.println("Can't load data of image");//display warning message
        } catch (Exception e) {
            System.out.println("Can't load data of image");//display warning message
        }
        return image;
    }

  
    public boolean insertImage(String imageLink, int productId) throws SQLException {
        query = "INSERT INTO `image`(`imageLink`,`productId`) VALUES (?,?)";//query insert
        try {
            pst = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);//create prepare statement
            pst.setString(1, imageLink);
            pst.setInt(2, productId);
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            rs.next();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't insert image to list.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("can't insert image to list.");//display warning message
            return false;

        }
    }

  
    public boolean updateImage(int imageid, String imagelink) throws SQLException {

        query = "UPDATE `image` SET `imageLink`=? WHERE `imageId`=?";//query insert
        try {

            pst = con.prepareStatement(query);
            pst.setString(1, imagelink);
            pst.setInt(2, imageid);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't update image to list.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("can't update image to list.");//display warning message
            return false;

        }
    }

    public ArrayList<Image> getIdImage(int proId) {
        query = "SELECT * FROM `image`,products WHERE image.productId = product.productId AND product.productId =" + proId;
        image = new ArrayList<>();

        try {
            rs = st.executeQuery(query);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int imgId = rs.getInt("imageId");
                    String imgLink = rs.getString("imageLink");
                    int pId = rs.getInt("productId");
                    image.add(new Image(imgId, imgLink, pId));
                }
            }
        } catch (SQLException e) {
            System.out.println("Can't load data of image");//display warning message
            return null;
        } catch (Exception e) {
            System.out.println("Can't load data of image");//display warning message
            return null;
        }

        return image;
    }

}
