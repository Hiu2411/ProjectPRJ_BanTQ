/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MyUtils.ConnectionLib;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Admin;
import Model.AdminException;
/**
 * DINH
 *
 * @author admin
 */
public class account_adminModel {

    //declare variables
    public PreparedStatement pst;
    public ResultSet rs;
    static Statement st;
    public ArrayList<Admin> acc;
    public String query;
    int numberPage = 10;
    ConnectionLib cn = new ConnectionLib();
    Connection con;

    /**
     * constructor
     *
     * @throws SQLException
     */
    public account_adminModel() throws SQLException {
        try {
            con =  cn.getConnectDB();
            st = con.createStatement();
            pst = null;
            rs = null;
            query = null;
            acc = new ArrayList<>();
            //cost = new ArrayList<>();
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * load account admin
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<Admin> loadAccount() throws SQLException {
        acc = new ArrayList<>();//create new store of account
        query = "SELECT * FROM account_admin WHERE 1";//query select
        try {
            rs = st.executeQuery(query);
            if (rs.isBeforeFirst()) {//check
                while (rs.next()) {
                    int id = rs.getInt("adminId");
                    String name = rs.getString("fullName");
                    String user = rs.getString("username");
                    String pass = rs.getString("password");
                    String phone = rs.getString("phone");
                    String add = rs.getString("address");
                    String email = rs.getString("email");
                    int status = rs.getInt("status");
                    if (status != 0) {
                        acc.add(new Admin(id, name, user, pass, phone, add, email, status));
                    }

                }
            }
        } catch (SQLException ex) {
            System.out.println("Can't load data of list account");//display warning message
        } catch (Exception e) {
            System.out.println("Can't load data of list account.");//display warning message
        }

        return acc;
    }

    /**
     * insert account admin
     *
     * @param full_name
     * @param username
     * @param password
     * @param email
     * @param status
     * @return
     * @throws SQLException
     */
    public boolean insertAccount(String full_name, String username, String password, String email, int status) throws SQLException {
        query = "INSERT INTO account_admin(full_name, username, password, email, status) VALUES (?,?,?,?,?)";//query insert
        //int id = acc.get(acc.size() - 1).getAdmin_id() + 1;//get id of account
        try {
            pst = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);//create prepare statement

            pst.setString(1, full_name);//set account name
            pst.setString(2, username);//set account password 
            pst.setString(3, password);//set acc ount type
            pst.setString(4, email);
            pst.setInt(5, status);
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            rs.next();//
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't insert account to list.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("can't insert account to list.");//display warning message
            return false;
        }
    }

    /**
     * update account admin
     *
     * @param full_name
     * @param username
     * @param password
     * @param email
     * @param status
     * @param admin_id
     * @return
     */
    public boolean updateAccount(String full_name, String username, String password, String email, int status, int admin_id) {

        query = "UPDATE account_admin SET full_name=?,username=?,password=?,email=?,status=? WHERE admin_id=?";//query update
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, full_name);//set account name
            pst.setString(2, username);//set account password
            pst.setString(3, password);//set account type
            pst.setString(4, email);
            pst.setInt(5, status);//set account id
            pst.setInt(6, admin_id);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't update account.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't update account.");//display warning message
            return false;
        }

    }

    /**
     * delete account admin
     *
     * @param admin_id
     * @return
     */
    public boolean deleteAccountAdmin(int admin_id) {
        query = "UPDATE account_admin SET status=? WHERE admin_id=?";
        try {
            pst = con.prepareStatement(query);
            pst.setInt(1, 0);
            pst.setInt(2, admin_id);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't delete account admin.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't delete account admin.");//display warning message
            return false;
        }

    }

    /**
     * check account
     *
     * @param a
     * @param user
     * @param password
     * @return
     */
    public int checkAccount(ArrayList<Admin> a, String user, String password) {
        for (Admin accountAdmin : a) {
            if (user.equals(accountAdmin.getUsername())) {
                if (password.equals(accountAdmin.getPassword())) {
                    return accountAdmin.getStatus();
                }
            }
        }
        return 0;
    }

    /**
     * get padding
     *
     * @param page
     * @param search
     * @param sortColumn
     * @return
     * @throws SQLException
     * @throws AccountAdminException
     */
    public ArrayList<Admin> getPadding(int page, String search, String sortColumn) throws SQLException, AdminException {
        //phan trang
        int totalAcc = getNumberOfAcc(page, search, sortColumn);
        int totalPage = (int) Math.ceil(totalAcc / numberPage);
        int index = (page) * numberPage;
        String sqlStr = "";
        sqlStr += "SELECT TOP "+index+" * FROM admin";

        if (search != "") {
            sqlStr += " WHERE (admin.fullName LIKE '%" + search + "%')";
        }

        
        this.st = this.con.createStatement();
        this.rs = this.st.executeQuery(sqlStr);
        acc = new ArrayList<Admin>();

        while (rs.next()) {
                    int id = rs.getInt("adminId");
                    String name = rs.getString("fullName");
                    String user = rs.getString("username");
                    String pass = rs.getString("password");
                    String phone = rs.getString("phone");
                    String add = rs.getString("address");
                    String email = rs.getString("email");
                    int status = rs.getInt("status");
                    if (status != 0) {
                        acc.add(new Admin(id, name, user, pass, phone, add, email, status));
                        acc.get(acc.size() - 1).setFullName(name);
                    }

                
            }

        
        return this.acc;
    }

    /**
     * get number of account
     *
     * @param page
     * @param search
     * @param sortColumn
     * @return
     * @throws SQLException
     */
    public int getNumberOfAcc(int page, String search, String sortColumn) throws SQLException {
        String sqlStr = "SELECT COUNT(*) as numberAcc  FROM admin";
        if (search != "") {
            //thuc hien tim kiem
            sqlStr += " WHERE admin.fullName LIKE '%" + search + "%'";
            sqlStr += " ORDER BY admin.adminId";
        }
        this.st = this.con.createStatement();
        this.rs = this.st.executeQuery(sqlStr);
        rs.next();
        return rs.getInt("numberAcc");
    }

    public String getPageString(int currentPage, String search, String sortColumn, String username) throws SQLException {
        String strPaging = "<ul class='pagination'>";
        try {
            int totalAcc = getNumberOfAcc(numberPage, search, sortColumn);
            int tongSoTrang = (int) Math.ceil(totalAcc / (float) numberPage);
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
     * get alpha numeric String
     *
     * @return
     */
    public String getAlphaNumericString() {

        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {

            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb 
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    /**
     * reset password
     *
     * @param id
     * @param password
     * @return
     */
    public boolean resetPassword(int id, String password) {
        query = "UPDATE account_admin SET password=? WHERE admin_id=?";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, password);
            pst.setInt(2, id);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Fail");
            return false;
        }
    }

    /**
     * check duplicate username
     *
     * @param username
     * @return
     */
    public boolean checkDuplicateUsername(String username) {
        try {
            ArrayList<Admin> am = loadAccount();
            for (Admin accountAdmin : am) {
                if (username.equals(accountAdmin.getUsername())) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

    /**
     * check duplicate email
     *
     * @param email
     * @return
     */
    public boolean checkDuplicateEmail(String email) {
        try {
            ArrayList<Admin> am = loadAccount();
            for (Admin accountAdmin : am) {
                if (email.equals(accountAdmin.getEmail())) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

}
