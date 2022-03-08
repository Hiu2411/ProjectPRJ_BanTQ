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
public class Producer {

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) throws ProducerException{
       if (producerId < 0) {
            throw new ProducerException("");
        } else {
            this.producerId = producerId;
        }
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName)throws  ProducerException{
        if (producerName.equals("")) {
            throw new ProducerException("Fullname can't be empty.");
        } else {
            this.producerName = producerName;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ProducerException{
         if (email.equals("")) {
            throw new ProducerException("Email can't be empty.");
        } else {
            this.email = email;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws ProducerException{
         if (phone.equals("")) {
            throw new ProducerException("");
        } else {
            this.phone = phone;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws ProducerException{
        if (address.equals("")) {
            throw new ProducerException("");
        } else {
            this.address = address;
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) throws ProducerException{
         if (status < 0) {
            throw new ProducerException("Product status must be greater than 0.");
        } else {
            this.status = status;
        }
    }

    public Producer(int producerId, String producerName, String email, String phone, String address, int status) {
        this.producerId = producerId;
        this.producerName = producerName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public Producer() {
    }
    private int producerId;
    private String producerName;
    private String email;
    private String phone;
    private String address;
    private int status;
}
