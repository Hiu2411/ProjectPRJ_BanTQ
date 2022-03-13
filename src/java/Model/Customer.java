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
public class Customer {

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Customer(int customerId, String fullName, String address, String email, int gender, String phone, int status) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.status = status;
    }

    public Customer(int customerId, String fullName, String address, String email, int gender, String phone, int status, String username, String password, int roleID) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.status = status;
        this.username = username;
        this.password = password;
        this.roleID = roleID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public Customer() {
    }

  //declare variables
    private int customerId;
    private String fullName;
    private String address;
    private String email;
    private int gender;
    private String phone;
    private int status;
    private String username;
    private String password;
    private int roleID;

}
