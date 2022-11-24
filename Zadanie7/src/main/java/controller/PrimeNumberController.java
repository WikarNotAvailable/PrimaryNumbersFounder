/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.*;
import view.*;
/**
 * Controller class that is working on model's and view's methods.
 * @version 2.2
 * @author Daniel Wikarek
 */
public class PrimeNumberController {
    /**
     * Allows to use the algorithm of finding prime numbers.
     */
    private PrimeNumberFinder finder;
    /**
     * Allows to show numbers, messages etc. via console.
     */
    private PrimeNumberShower shower;    
    /**
     * Constructor with string argument creating instances of PrimeNumberFinder and PrimeNumberShower and assigning them to private fields of controller's class.
     * @param numberOfPrimeNumbers string that will be converter to an integer if possible
     */
    public PrimeNumberController(String numberOfPrimeNumbers){        
        shower = new PrimeNumberShower();   
        
        try{
        finder = new PrimeNumberFinder(numberOfPrimeNumbers);
        }
        catch(BadInputArgumentException ex){
            shower.showErrorMessage(ex.getMessage());
            int maxPrimaryNumber = shower.askForMaxPrimaryNumber();
            
            try{
                finder = new PrimeNumberFinder(maxPrimaryNumber);
            }
            catch(BadInputArgumentException ex2){
            shower.showErrorMessage(ex.getMessage());
            }
        }
    }
    /**
     * Constructor with no arguments creating instances of PrimeNumberFinder and PrimeNumberShower and assigning them to private fields of controller's class.
     */
    public PrimeNumberController(){     
        shower = new PrimeNumberShower();   

        int maxPrimaryNumber = shower.askForMaxPrimaryNumber();
        try{
            finder = new PrimeNumberFinder(maxPrimaryNumber); 
        }
        catch(BadInputArgumentException ex){
            shower.showErrorMessage(ex.getMessage());
        }
    }
    /**
     * Shows prime numbers from PrimeNumberFinder stored in my own generic via PrimeNumberShower.
     */
    public void writePrimeNumbers(){
        MyCopyingList<Integer> primeNumbers = new MyCopyingList<>();
        primeNumbers.copyList(finder.getPrimeNumbers());
        shower.showPrimeNumbers(primeNumbers);
    }
    /**
     * Calculates new prime numbers (used after the creation of the controller).
     */
    public void calculateNewPrimeNumbers(){
        int maxPrimaryNumber = shower.askForMaxPrimaryNumber();
        try{
            finder.setPrimeNumbersMax(maxPrimaryNumber);
        }
        catch(BadInputArgumentException ex){
            shower.showErrorMessage(ex.getMessage());
        }
        
        finder.setPrimeNumbers();
    }
}
