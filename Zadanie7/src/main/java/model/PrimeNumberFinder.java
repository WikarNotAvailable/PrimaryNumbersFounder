/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for finding prime number less than or equal to specified maximum prime number.
 * @version 2.4
 * @author Daniel Wikarek
 */
public class PrimeNumberFinder {
    /**
     * Holds maximum prime number, greater numbers won't be checked.
     */
    private int primeNumbersMax;
    /**
     * Holds found prime numbers.
     */
    private List<Integer> primeNumbers;
    /**
     * Checks if passed string parameter can be converted to integer.
     * @param primeNumbersMax string parameter that should be converted to maximum prime number
     * @return if string can be converted to integer
     */
    private boolean validatePrimeNumbersMax(String primeNumbersMax){
        
        for(var ch : primeNumbersMax.toCharArray()){
            if(!(Character.isDigit(ch)))
                return false;
        }       
        return true;
    }
    /**
     * Finds all prime numbers less than or equal to maximum prime number.
     * @return prime numbers as a of integers
     */
    private List<Integer> findPrimeNumbers(){
        
        List<Boolean> prime = new ArrayList<Boolean>();
        for(int i = 0; i <= primeNumbersMax;i++){
            prime.add(Boolean.TRUE);
        }
        
        for (int p = 2; p * p <= primeNumbersMax; p++) {
            if (prime.get(p)) {
                for (int i = p * 2; i <= primeNumbersMax; i += p) {
                prime.set(i, Boolean.FALSE);
                }
            }
        }
        
        List<Integer> primeNumbersList = new ArrayList<>();
        for (int i = 2; i <= primeNumbersMax; i++) {
            if (prime.get(i)) {
                primeNumbersList.add(i);
            }
        }      
        return primeNumbersList;
    }
    /**
     * Constructor of class that has string as an argument.
     * If this string can't be converted to integer, constructor throws an exception.
     * If string can be converted to integer, it is saved as maximum of primer number to find and then prime numbers are searched.
     * When prime numbers are found they are stored in private field of PrimeNumberFinder.
     * @param numberOfPrimeNumbers  string parameter that should be converted to maximum prime number
     * @throws BadInputArgumentException 
     */
    public PrimeNumberFinder(String numberOfPrimeNumbers) throws BadInputArgumentException{
        
        if(validatePrimeNumbersMax(numberOfPrimeNumbers))
            primeNumbersMax = Integer.parseInt(numberOfPrimeNumbers);
        else
            throw new BadInputArgumentException("Maximum prime number of prime numbers to calculate passed via arguments of main is not an integer. If you want to launch the program using main arguments you should pass following argument: maximum prime number of type integer.");
        
        primeNumbers = findPrimeNumbers();
    }
    /**
     * Constructor of class that has integer as an argument.
     * Its arguments is saved in proper private field of PrimeNumberFinder and then prime numbers are searched.
     * When prime numbers are found they are stored in private field of PrimeNumberFinder.
     * @param primeNumbersLimit maximum prime number
     * @throws BadInputArgumentException
     */
    public PrimeNumberFinder(int primeNumbersLimit) throws BadInputArgumentException{
        if(primeNumbersLimit<2){
            primeNumbersMax = 2;
            throw new BadInputArgumentException("There are no prime numbers lower than 2. Prime numbers max is set to default value(2).");
        }
        primeNumbersMax = primeNumbersLimit;
        primeNumbers = findPrimeNumbers();
    }
    /**
     * Getter of prime numbers.
     * @return prime numbers that were found earlier
     */
    public List<Integer> getPrimeNumbers(){
        return primeNumbers;
    } 
    /**
     * Setter of prime numbers max.
     * @param primeNumbersLimit maximum prime number
     * @throws BadInputArgumentException
     */
    public void setPrimeNumbersMax(int primeNumbersLimit) throws BadInputArgumentException{
        if(primeNumbersLimit<2){
            primeNumbersMax = 2;
            throw new BadInputArgumentException("There are no prime numbers lower than 2. Prime numbers max is set to default value(2).");
        }
        primeNumbersMax = primeNumbersLimit;
    } 
    /**
     * Getter of prime numbers max.
     * @return prime numbers' max number that was set by the user
     */
    public int getPrimeNumbersMax(){
        return primeNumbersMax;
    }
    /**
     * Setter of prime numbers working on list which is private field of PrimeNumberFinder class.
     */
    public void setPrimeNumbers(){
        primeNumbers = findPrimeNumbers();
    }
}
