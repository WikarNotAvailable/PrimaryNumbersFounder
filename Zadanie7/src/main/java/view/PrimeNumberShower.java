/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.MyCopyingList;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Class responsible for showing content using console.
 * @version 2.3
 * @author Daniel Wikarek
 */
public class PrimeNumberShower {
    /**
     * Default constructor.
     */
    public PrimeNumberShower(){}
    /**
     * Shows prime numbers via console.
     * @param list prime numbers stored in my own generic.
     */
    public void showPrimeNumbers(MyCopyingList<Integer> list){
        Stream<Integer> stream;
        stream = list.copyListStream();
        
        stream.forEach(p -> System.out.print(p + " "));
        
        System.out.println();
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
