package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DINH
 */
public class Admin {

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws AdminException{
        if (phone.equals("")) {
            throw new AdminException("");
        } else {
            this.phone = phone;
        }

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws AdminException{
        if (address.equals("")) {
            throw new AdminException("");
        } else {
            this.address = address;
        }

    }

    public Admin() {
    }

    public Admin(int adminId, String fullName, String username, String password, String phone, String address, String email, int status) {
        this.adminId = adminId;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.status = status;
    }
//declare variables
    private int adminId;
    private String fullName;
    private String username;
    private String password;
    private String phone;
    private String address;
    private String email;
    private int status;

    
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) throws AdminException {
        if (adminId < 0) {
            throw new AdminException("");
        } else {
            this.adminId = adminId;
        }

    }

  
    public String getFullName() {
        return fullName;
    }

   
    public void setFullName(String fullName) throws AdminException {
        if (fullName.equals("")) {
            throw new AdminException("Fullname can't be empty.");
        } else {
            this.fullName = fullName;
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws AdminException {
        if (username.equals("")) {
            throw new AdminException("Username can't be empty.");
        } else {
            this.username = username;
        }

    }

  
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws AdminException {
        if (password.equals("")) {
            throw new AdminException("Password can't be empty.");
        } else {
            this.password = password;
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws AdminException {
        if (email.equals("")) {
            throw new AdminException("Email can't be empty.");
        } else {
            this.email = email;
        }

    }

  
    public int getStatus() {
        return status;
    }

   
    public void setStatus(int status) throws AdminException {
        if (status < 0) {
            throw new AdminException("Status must be greater than 0.");
        } else {
            this.status = status;
        }

    }

   
   

}

