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
public class TypeProduct {

    public TypeProduct() {
    }

    public TypeProduct(int typeId, String typeName, String description, int status) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.description = description;
        this.status = status;
    }
 
    private int typeId;
    private String typeName;
    private String description;
    private int status;

 
    public int getTypeId() {
        return typeId;
    }

  
    public void setTypeId(int typeId) throws TypeProductException {
        if (typeId < 0) {
            throw new TypeProductException("Type product id must be greater than 0.");//display warning message
        } else {
            this.typeId = typeId;
        }

    }

  
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) throws TypeProductException {
        if (typeName.equals("")) {
            throw new TypeProductException("Type product name can't be empty.");//display warning message
        } else {
            this.typeName= typeName;
        }

    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws TypeProductException {
        if (description.equals("")) {
            throw new TypeProductException("Description can't be empty.");//display warning message
        } else {
            this.description = description;
        }

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) throws TypeProductException {
        if (status < 0) {
            throw new TypeProductException("Status must be greater than 0.");//display warning message
        } else {
            this.status = status;
        }

    }

   
   
}
