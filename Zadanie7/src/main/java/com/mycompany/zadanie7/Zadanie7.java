/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.zadanie7;
import controller.*;
/**
 * This is main class of the project and only main function happens to be there.
 * @version 1.2
 * @author Daniel Wikarek
 */
public class Zadanie7 {
/**
 * This is main function in which controller is created and then method responsible for writing prime numbers is called.
 * The only required parameter is maximum number of prime numbers to find and it should be passed via project properties.
 * If it not passed or input is invalid, controller's constructor will be called without arguments.
 * @param args arguments from project properties, max number of prime numbers should be passed here
 */
    public static void main(String[] args) {
        PrimeNumberController controller; 
        if(args.length != 0)
            controller = new PrimeNumberController(args[0]);
        else
            controller = new PrimeNumberController();
        
        controller.writePrimeNumbers();
    }
}
