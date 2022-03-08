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
public class Transport {

    public Transport(int transportId, String transportType, int status) {
        this.transportId = transportId;
        this.transportType = transportType;
        this.status = status;
    }

    public Transport() {
    }
    private int transportId;
    private String transportType;
    private int status;

   
    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) throws TransportException {
        if (transportId < 0) {
            throw new TransportException("Transport ID must be greater than 0.");
        } else {
            this.transportId = transportId;
        }

    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) throws TransportException {
        if (transportType.equals("")) {
            throw new TransportException("Transport type can't be empty.");
        } else {
            this.transportType = transportType;
        }

    }

   
    public int getStatus() {
        return status;
    }

   
    public void setStatus(int status) throws TransportException {
        if (status < 0) {
            throw new TransportException("Status must be greater than 0.");
        } else {
            this.status = status;
        }

    }

   
}
