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
public class Payment {

    public Payment(int paymentId, String paymentType, int status) {
        this.paymentId = paymentId;
        this.paymentType = paymentType;
        this.status = status;
    }

    public Payment() {
    }
     private int paymentId;
    private String paymentType;
    private int status;

   
    public int getPayId() {
        return paymentId;
    }

    public void setPaymentId(int paymenId) throws PaymentException {
        if (paymenId < 0) {
            throw new PaymentException("Pay id must be greater than 0.");
        } else {
            this.paymentId= paymenId;
        }
    }

   
    public String getPaymentType() {
        return paymentType;
    }

    
    public void setPaymentType(String paymentType) throws PaymentException {
        if (paymentType.equals("")) {
            throw new PaymentException("Pay type can't be empty.");
        } else {
            this.paymentType = paymentType;
        }

    }

   
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) throws PaymentException {
        if (status < 0) {
            throw new PaymentException("Status must be greater than 0");
        } else {
            this.status = status;
        }
    }

    
   
}
