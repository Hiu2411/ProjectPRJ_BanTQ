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
public class OrderException extends Exception {
    public OrderException(String string) {
        super("Exception is :" + string);
    }
}
