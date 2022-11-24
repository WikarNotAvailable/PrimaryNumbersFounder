/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Class used for catching exception of passed argument not being an integer or being integer out of proper range.
 * @version 2.1
 * @author Daniel Wikarek
 */
public class BadInputArgumentException extends Exception{
    /**
     * Default constructor.
     */
    public BadInputArgumentException(){
    }
    /**
     * Constructor with string parameter.
     * @param message contains detailed information about the exception.
     */
    public BadInputArgumentException(String message){
        super(message);
    }
}
