/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import model.NotIntException;

/**
 * Class responsible for finding prime number less than or equal to specified maximum prime number.
 * @version 1.2
 * @author Daniel Wikarek
 */
public class PrimeNumberFinder {
    /**
     * Holds maximum prime number, greater numbers won't be checked.
     */
    private int primeNumbersMax;
    /**
     * Holds found prime numbers
     */
    private int[] primeNumbers;
    /**
     * Checks if passed string parameter can be converted to integer.
     * @param primeNumbersMax string parameter that should be converted to maximum prime number
     * @return if string can be converted to integer
     */
    private boolean validatePrimeNumbersMax(String primeNumbersMax){
        char[] chars = primeNumbersMax.toCharArray();
        for(int i=0;i<chars.length;i++){
            
            if(!(Character.isDigit(chars[i])))
                return false;
        }
        return true;
    }
    /**
     * Finds all prime numbers less than or equal to maximum prime number.
     * @return prime numbers as array of integers
     */
    private int [] findPrimeNumbers(){
        boolean prime[] = new boolean[primeNumbersMax + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= primeNumbersMax; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= primeNumbersMax; i += p) {
                prime[i] = false;
                }
            }
        }
        
        List<Integer> primeNumbersList = new LinkedList<>();
        for (int i = 2; i <= primeNumbersMax; i++) {
            if (prime[i]) {
                primeNumbersList.add(i);
            }
        }
    
        int primeNumbersArray[] = new int [primeNumbersList.size()];
        for (int i=0; i < primeNumbersList.size();i++){
            primeNumbersArray[i] = primeNumbersList.get(i);
        }
    
        return primeNumbersArray;
    }
    /**
     * Constructor of class that has string as an argument.
     * If this string can't be converted to integer, constructor throws an exception.
     * If string can be converted to integer, it is saved as maximum of primer number to find and then prime numbers are searched.
     * When prime numbers are found they are stored in private field of PrimeNumberFinder.
     * @param numberOfPrimeNumbers  string parameter that should be converted to maximum prime number
     * @throws NotIntException 
     */
    public PrimeNumberFinder(String numberOfPrimeNumbers) throws NotIntException{
        
        if(validatePrimeNumbersMax(numberOfPrimeNumbers))
            primeNumbersMax = Integer.parseInt(numberOfPrimeNumbers);
        else
            throw new NotIntException("Maximum prime number of prime numbers to calculate passed via arguments of main is not an integer. If you want to launch the program using main arguments you should pass following argument: maximum prime number of type integer.");
        
        primeNumbers = findPrimeNumbers();
    }
    /**
     * Constructor of class that has integer as an argument.
     * Its arguments is saved in proper private field of PrimeNumberFinder and then prime numbers are searched.
     * When prime numbers are found they are stored in private field of PrimeNumberFinder.
     * @param numberOfPrimeNumbers maximum primer number
     */
    public PrimeNumberFinder(int numberOfPrimeNumbers){
        primeNumbersMax = numberOfPrimeNumbers;
        primeNumbers = findPrimeNumbers();
    }
    /**
     * Getter of prime numbers.
     * @return prime numbers that were found earlier
     */
    public int[] getPrimeNumbers(){
        return primeNumbers;
    } 
}
