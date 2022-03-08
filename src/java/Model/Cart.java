/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author DINH
 */
public class Cart {

    public ArrayList<Item> getList() {
        return list;
    }

    public void setList(ArrayList<Item> list) {
        this.list = list;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cart() {
    }

    public Cart(double total) {
        this.total = total;
    }
    private ArrayList<Item> list = new ArrayList<>();
    private double total;

    public void deleteCart(String stt) {
        int iSTT = 0;
        try {
            iSTT = Integer.parseInt(stt);
            list.remove(iSTT - 1);
        } catch (NumberFormatException nfe) {
            System.out.println("Error while deleting cart item: " + nfe.getMessage());
            nfe.printStackTrace();
        }
    }

 

    public double OrderTotal() {
        double total = 0;
        for (int i = 0; i < list.size(); i++) {
            total+=list.get(i).getPrice();
        }
        
    return total;
    }
    
}
