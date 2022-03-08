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
public class Order {

    public Order() {
    }

    public Order(int orderId, int customerId, String address, String dateBuy, String dateDone, int paymentId, int transportId, int status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.address = address;
        this.dateBuy = dateBuy;
        this.dateDone = dateDone;
        this.paymentId = paymentId;
        this.transportId = transportId;
        this.status = status;
    }
    private int orderId;
    private int customerId;
    private String address;
    private String dateBuy;
    private String dateDone;
    private int paymentId;
    private int transportId;
    private int status;

  
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) throws OrderException {
        if (orderId < 0) {
            throw new OrderException("Orders ID must be greater than 0.");
        } else {
            this.orderId = orderId;
        }

    }

    public int getcustomerId() {
        return customerId;
    }

    public void setcustomerId(int customerId) throws OrderException {
        if (customerId< 0) {
            throw new OrderException("Admin ID must be greater than 0.");
        } else {
            this.customerId= customerId;
        }

    }

    public String getAddress() {
        return address;
    }

  
    public void setAddress(String address) throws OrderException {
        if (address.equals("")) {
            throw new OrderException("Address can't be empty.");
        } else {
            this.address = address;
        }

    }

 

    public String getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(String dateBuy) throws OrderException {
        
            this.dateBuy = dateBuy;
        
    }

  
    public String getDateDone() {
        return dateDone;
    }

   
    public void setDateDone(String dateDone) throws OrderException {
        
            this.dateDone = dateDone;
        

    }

  
    public int getPayMentId() {
        return paymentId;
    }

  
    public void setPaymentId(int paymentId) throws OrderException {
        if (paymentId < 0) {
            throw new OrderException("Pay ID must be greater than 0.");
        } else {
            this.paymentId = paymentId;
        }

    }

  
    public int getTransportId() {
        return transportId;
    }

    
    public void setTransportId(int transportId) throws OrderException {
        if (transportId < 0) {
            throw new OrderException("Transport ID must be greater than 0.");
        } else {
            this.transportId = transportId;
        }
    }

  
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) throws OrderException {
        if (status < 0) {
            throw new OrderException("Status must be greater than 0.");
        } else {
            this.status = status;
        }
    }

  
   
}
