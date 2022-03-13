/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import MyUtils.ConnectionLib;
import Model.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Product;
import Model.ProductException;
import java.text.DecimalFormat;

/**
 *
 * @author hieuh
 */
public class ProductModel {

    //declare variables
    public static int numberPage = 10;
    ConnectionLib cn = new ConnectionLib();
    Connection con;
    private PreparedStatement pst;
    private Statement st;
    private Statement st2;
    private ResultSet rs;
    private ResultSet rs2;
    private String query;
    private ArrayList<Product> products;
    private ArrayList<Image> images;
    private String a = "";

    /**
     * constructor product model no parameter
     *
     * @throws SQLException
     */
    public ProductModel() throws SQLException {
        con = null;
        pst = null;
        st = null;
        rs = null;
        st2 = null;
        rs2 = null;
        products = new ArrayList<>();
        con = cn.getConnectDB();
        st = con.createStatement();
        st2 = con.createStatement();
    }

    public ArrayList<Product> loadProduct() {
        products = new ArrayList<>();//declare variables
        query = "SELECT * FROM product";//query sql select data
        try {
            rs = st.executeQuery(query);//execute query
            
                 while (rs.next()) {
                    int pId = rs.getInt("productId");//get id product 
                    String name = rs.getString("productName");//get name product 
                    double price = rs.getInt("price");//get price product
                    int size = rs.getInt("size");//get size product
                    String color = rs.getString("color");//get color 
                    int typeId = rs.getInt("typeId");
                    int status = rs.getInt("status");//get status
                    
                    if (status != 0) {
                        products.add(new Product(pId, name, price, size, color,typeId,status));//add product
                    }

                }
            
        } catch (SQLException ex) {
            System.out.println("Can't load data of list products");//display warning message
        } catch (Exception e) {
            System.out.println("Can't load data of list products");//display warning message
        }
        return products;
    }

    public int insertProduct(String name, int price, int size, String color, int status, int type_id) throws SQLException {
        query = "INSERT INTO products(name, price, size, color,  status, type_id) VALUES (?,?,?,?,?,?)";//query insert
        try {
            pst = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);//create prepare statement

            pst.setString(1, name);//set name product
            pst.setInt(2, price);//set price product
            pst.setInt(3, size);//set size product
            pst.setString(4, color);//set color product         
            pst.setInt(5, status);//set status
            pst.setInt(6, type_id);//set type_id
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            rs.next();//

            return rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println("Can't insert product to list.");//display warning message
            return 0;
        } catch (Exception e) {
            System.out.println("can't insert product to list.");//display warning message
            return 0;

        }
    }

   
    public boolean updateProduct(int p_id, String name, int price, int size, String color, int status, int type_id) {

        query = "UPDATE products SET name=?,price=?,size=?,color=?,status=?,type_id=? WHERE p_id=?";//query update
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, name);//set name product
            pst.setInt(2, price);//set price product
            pst.setInt(3, size);//set size product
            pst.setString(4, color);//set color product         
            pst.setInt(5, status);//set status
            pst.setInt(6, type_id);//type product id
            pst.setInt(7, p_id); //set product id
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't update product.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't update product.");//display warning message
            return false;
        }
    }

    /**
     * delete Product method
     *
     * @param p_id
     * @return
     */
    public boolean deleteProduct(int p_id) {
        query = "UPDATE products SET status=? WHERE p_id=?";//query update product
        try {
            pst = con.prepareStatement(query);
            pst.setInt(1, 0);//set status equal 0
            pst.setInt(2, p_id);//set id
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't delete product.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't delete product.");//display warning message
            return false;
        }

    }

    /**
     * Search product method by product name
     *
     * @param productName
     * @return
     */
    public ArrayList<Product> searchProductByName(String productName) {
        products = new ArrayList<>();//declare variables
        
        query = "SELECT * FROM product WHERE product.productName LIKE ('%" + productName + "%')";//query sql select data
        try {
            rs = st.executeQuery(query);//execute query
            
                 while (rs.next()) {
                    int pId = rs.getInt("productId");//get id product 
                    String name = rs.getString("productName");//get name product 
                    double price = rs.getInt("price");//get price product
                    int size = rs.getInt("size");//get size product
                    String color = rs.getString("color");//get color 
                    int typeId = rs.getInt("typeId");
                    int status = rs.getInt("status");//get status
                    
                    if (status != 0) {
                        products.add(new Product(pId, name, price, size, color,typeId,status));//add product
                    }

                }
            
        } catch (SQLException ex) {
            ex.getMessage();
        } catch (Exception e) {
           e.getMessage();
        }
        return products;
    }
    
    public ArrayList<Product> getPadding(int page, String search, String sortColumn) throws SQLException, ProductException {

        int totalProduct = getNumberOfProduct(page, search, sortColumn);
        int totalPage = (int) Math.ceil(totalProduct / (float) numberPage);
        int index = (page) * numberPage;
        String sqlStr = "";
        sqlStr += " SELECT TOP "+ index +" *,typeproduct.typename ";
        sqlStr += " FROM product,typeproduct  ";
        sqlStr += " WHERE product.typeid = typeproduct.typeid ";

        if (search != "") {
            //thuc hien tim kiem
            sqlStr += " AND (product.productname LIKE '%" + search + "%' OR  typeproduct.typename LIKE '%" + search + "%')";
            sqlStr += " ORDER BY productid ";
        } else {
            sqlStr += " ORDER BY productid ";
        }
        if (sortColumn != "") {
            //
        }
        

        this.st = this.con.createStatement();
        this.rs = this.st.executeQuery(sqlStr);
        products = new ArrayList<Product>();

        while (rs.next()) {
            int pId = rs.getInt("productId");//get id product 
                    String name = rs.getString("productName");//get name product 
                    double price = rs.getInt("price");//get price product
                    int size = rs.getInt("size");//get size product
                    String color = rs.getString("color");//get color 
                    int typeId = rs.getInt("typeId");
                    int status = rs.getInt("status");//get status
                    if (status != 0) {
                        products.add(new Product(pId, name, price, size, color,typeId,status));//add product
                    }
           products.get(products.size() - 1);

        }

        return this.products;
    }

 
    public String getImage(int pId) throws SQLException {
        String sqlStr2 = "SELECT TOP 1 * FROM image WHERE image.productId = " + pId;
        this.st2 = this.con.createStatement();
        rs2 = st2.executeQuery(sqlStr2);
        while (rs2.next()) {
            a = rs2.getString("imageLink");
        }
        return a;
    }

  
    public  ArrayList<Image> getImage2(int pId) throws SQLException {
         images = new ArrayList<>();
            String img = "SELECT * FROM image WHERE productId = " + pId + "";
            st = con.createStatement();
            rs = st.executeQuery(img);
                while (rs.next()) {
                    int imgId = rs.getInt("imageId");
                    String imgLink = rs.getString("imageLink");
                    int Id = rs.getInt("productId");
                    images.add(new Image(imgId, imgLink, Id));
                }
            
        
        return images;
    }
    public  ArrayList<Product> getProductbyId(int pId) throws SQLException {
         products = new ArrayList<>();//declare variables
        query = "SELECT * FROM product WHERE productId = " + pId + "";
        try {
            rs = st.executeQuery(query);//execute query
            
                 while (rs.next()) {
                    int proId = rs.getInt("productId");//get id product 
                    String name = rs.getString("productName");//get name product 
                    double price = rs.getInt("price");//get price product
                    int size = rs.getInt("size");//get size product
                    String color = rs.getString("color");//get color 
                    int typeId = rs.getInt("typeId");
                    int status = rs.getInt("status");//get status
                    
                    if (status != 0) {
                        products.add(new Product(proId, name, price, size, color,typeId,status));//add product
                    }

                }
            
        } catch (SQLException ex) {
            System.out.println("Can't load data of list products");//display warning message
        } catch (Exception e) {
            System.out.println("Can't load data of list products");//display warning message
        }
        return products;
    }

    /**
     * get number of product method
     *
     * @param page
     * @param search
     * @param sortColumn
     * @return
     * @throws SQLException
     */
    public int getNumberOfProduct(int page, String search, String sortColumn) throws SQLException {
        String sqlStr = "";
        sqlStr += "SELECT COUNT(*) as numberProduct ";
        sqlStr += " FROM product,typeproduct  ";
        sqlStr += " WHERE product.typeid = typeproduct.typeid ";

        if (search != "") {
            //thuc hien tim kiem
            sqlStr += " AND (product.productname LIKE '%" + search + "%' OR  typeproduct.typename LIKE '%" + search + "%')";
        }
        this.st = this.con.createStatement();
        this.rs = this.st.executeQuery(sqlStr);
        rs.next();
        return rs.getInt("numberProduct");
    }

    /**
     * get Page String method
     *
     * @param currentPage
     * @param search
     * @param sortColumn
     * @return
     * @throws SQLException
     */
    public String getPageString(int currentPage, String search, String sortColumn, String username) throws SQLException {
        String strPaging = "<ul class='pagination'>";
        try {
            int totalProduct = getNumberOfProduct(currentPage, search, sortColumn);
            int tongSoTrang = (int) Math.ceil(totalProduct / (float) numberPage);
            for (int stt_trang = 1; stt_trang <= tongSoTrang; stt_trang++) {
                if (search == "") {

                    if (stt_trang == currentPage) {
                        strPaging += "<li class='active'><a href='?trang=" + stt_trang + "&username=" + username + " '>" + stt_trang + "</a></li>";
                    } else {
                        strPaging += "<li><a href='?trang=" + stt_trang + "&username=" + username + "'>" + stt_trang + "</a></li>";
                    }
                } else {
                    if (stt_trang == currentPage) {
                        strPaging += "<li class='active'><a href='?trang=" + stt_trang + "&username=" + username + "&s=" + search + " '>" + stt_trang + "</a></li>";
                    } else {
                        strPaging += "<li><a href='?trang=" + stt_trang + "&username=" + username + "&s=" + search + "'>" + stt_trang + "</a></li>";
                    }
                }

            }
            strPaging += "</ul>";
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return strPaging;
    }

    /**
     * search product by id
     *
     * @param p
     * @return
     */
    public ArrayList<Product> searchProductById(int p) {
        String sqlStr = "";
        sqlStr += " SELECT *";
        sqlStr += " FROM product ";
        sqlStr += " WHERE products.productid =" + p;
        products = new ArrayList<>();
        try {
            this.rs = this.st.executeQuery(sqlStr);//execute query
            if (rs.isBeforeFirst()) {
               while (rs.next()) {
                    int pId = rs.getInt("productId");//get id product 
                    String name = rs.getString("productName");//get name product 
                    double price = rs.getInt("price");//get price product
                    int size = rs.getInt("size");//get size product
                    String color = rs.getString("color");//get color 
                    int typeId = rs.getInt("typeId");
                    int status = rs.getInt("status");//get status
                    if (status != 0) {
                        products.add(new Product(pId, name, price, size, color,typeId,status));//add product
                    }
                    //products.get(products.size() - 1).setType_name(type_name);

                }
            }
            return products;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Product> get3ProductByType(int type) {
        String sqlStr = "SELECT TOP 3 * FROM product WHERE product.typeid = "+type+"";
        products = new ArrayList<>();
        try {
            this.rs = this.st.executeQuery(sqlStr);//execute query
          
                while (rs.next()) {
                    int pId = rs.getInt("productId");//get id product 
                    String name = rs.getString("productName");//get name product 
                    double price = rs.getInt("price");//get price product
                    int size = rs.getInt("size");//get size product
                    String color = rs.getString("color");//get color 
                    int typeId = rs.getInt("typeId");
                    int status = rs.getInt("status");//get status

                    if (status != 0) {
                        products.add(new Product(pId, name, price, size, color,typeId,status));//add product
                    }
               
            }
            return products;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Product> getProductByType(int type) {
        String sqlStr = "";
        sqlStr += " SELECT * ";
        sqlStr += " FROM product";
        sqlStr += " WHERE product.typeid = " + type;
        products = new ArrayList<>();
        try {
            this.rs = this.st.executeQuery(sqlStr);//execute query
            if (rs.isBeforeFirst()) {
               while (rs.next()) {
                    int pId = rs.getInt("productId");//get id product 
                    String name = rs.getString("productName");//get name product 
                    double price = rs.getInt("price");//get price product
                    int size = rs.getInt("size");//get size product
                    String color = rs.getString("color");//get color 
                    int typeId = rs.getInt("typeId");
                    int status = rs.getInt("status");//get status
                    if (status != 0) {
                        products.add(new Product(pId, name, price, size, color,typeId,status));//add product
                    }
                    //products.get(products.size() - 1).setType_name(type_name);
                }
            }
            return products;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

     public String getProductNameById(int p) {
         String name = null;
        try {
            this.rs = this.st.executeQuery("SELECT productName FROM product WHERE product.productid ='"+p+"'");//execute query
            if (rs.isBeforeFirst()) {
               while (rs.next()) {
                    name = rs.getString("productName");//get name product 
                }
            }
            return name;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
   
}
