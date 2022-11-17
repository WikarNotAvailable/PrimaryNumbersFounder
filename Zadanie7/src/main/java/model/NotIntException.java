/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Class used for catching exception of passed argument not being an integer.
 * @version 1.1
 * @author Daniel Wikarek
 */
public class NotIntException extends Exception{
    /**
     * Default constructor.
     */
    public NotIntException(){
    }
    /**
     * Constructor with string parameter.
     * @param message contains detailed information about the exception.
     */
    public NotIntException(String message){
        super(message);
    }
}
