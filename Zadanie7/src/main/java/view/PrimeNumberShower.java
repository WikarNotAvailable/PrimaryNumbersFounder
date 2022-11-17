/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;

/**
 * Class responsible for showing content using console.
 * @version 1.2
 * @author Daniel Wikarek
 */
public class PrimeNumberShower {
    /**
     * Default constructor.
     */
    public PrimeNumberShower(){}
    /**
     * Shows prime numbers via console.
     * @param array prime numbers stored in array of integers.
     */
    public void showPrimeNumbers(int [] array){
        for (int i = 0; i<array.length;i++){
            System.out.println(array[i]);
        }
    }
    /**
     * Shows error message passed as an argument.
     * @param message error message.
     */
    public void showErrorMessage(String message){
        System.err.println(message);
    }
    /**
     * Asks user for maximum primary number.
     * @return maximum primary number.
     */
    public int askForMaxPrimaryNumber(){
        System.out.println("Write maximum primary number.");
        int max = 0;
        
        Scanner sc = new Scanner(System.in);
        try{
            max = sc.nextInt();  
        }
        catch(Exception ex){
            System.out.println("Invalid input.");
            max = askForMaxPrimaryNumber();
        }
        
        return max;
    }
}
