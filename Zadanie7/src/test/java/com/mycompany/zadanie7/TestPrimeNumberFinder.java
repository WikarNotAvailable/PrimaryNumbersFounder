/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadanie7;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.BadInputArgumentException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import model.PrimeNumberFinder;

/**
 * Class containing tests for methods of PrimeNumberFinder.
 * !IMPORTANT I have tested getters and mutators due to not having logic of model as public  methods.
 * @version 1.2
 * @author Daniel Wikarek
 */
public class TestPrimeNumberFinder {
    /**
     * Instance of model class used for tests.
     */
    private PrimeNumberFinder finder;
    /**
     * Test of getter of prime numbers. Priority - testing amount of prime numbers returned by method.
     * @param maxNumber biggest possible prime number
     * @param expectedNumberOfPrimaryNumbers expected amount of prime numbers
     */
    @ParameterizedTest
    @CsvSource({"10,4","20,8","2,1","0,-1","-1,-1"})
    void testAmountOfPrimeNumbersForGetterOfPrimeNumbers(int maxNumber, int expectedNumberOfPrimaryNumbers){
        try{
            finder = new PrimeNumberFinder(maxNumber);
        }
        catch(BadInputArgumentException ex){ 
            if(maxNumber<2)
                return;
            else
                fail("Exception should not be thrown");
        }
        
        assertEquals(expectedNumberOfPrimaryNumbers,finder.getPrimeNumbers().size(),"Improper amount of primary numbers.");
    }
    /**
     * Test of getter of prime numbers. Priority - testing accordance of prime numbers returned by method.
     * @param maxNumber biggest possible prime number
     */
    @ParameterizedTest
    @ValueSource(ints = {10,100,67, 2, 0, -1})
    void testFoundPrimeNumbersForGetterOfPrimeNumbers(int maxNumber){
        try{
            finder = new PrimeNumberFinder(maxNumber);
        }
        catch(BadInputArgumentException ex){ 
            if(maxNumber<2)
                return;
            else
                fail("Exception should not be thrown");
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= maxNumber; i++)  	   
        { 		 		  
           int counter=0; 		  
           for(int num = i; num >= 1; num--)
           {
              if(i%num == 0)
              {
                counter = counter + 1;
              }
           }
           if (counter == 2)
           {
              list.add(i);
           }	
        }	
        boolean isGood = true; 
        List<Integer> modelList = finder.getPrimeNumbers();
        
        if(modelList.size() != list.size())
            isGood = false;
        else{
            for (int i = 0; i < modelList.size(); i++){
                if(!Objects.equals(list.get(i), modelList.get(i)))
                    isGood = false;
            }
        }
            
        assertTrue(isGood, "Prime number found in model are not correct.");
    }
    /**
     * Test of setter of prime numbers max.
     * @param maxNumberToSet biggest possible prime number
     */
    @ParameterizedTest
    @ValueSource(ints = {10,100,67,2,0,-1})    
    void testSetterOfPrimeNumbersMax(int maxNumberToSet){
        try{
            finder = new PrimeNumberFinder(3);
        }
        catch(BadInputArgumentException ex){ 
            fail("An exception should not be thrown.");
        }
        
        try{
            finder.setPrimeNumbersMax(maxNumberToSet);
        }
        catch(BadInputArgumentException ex){ 
            return;
        }

        assertEquals(maxNumberToSet,finder.getPrimeNumbersMax(),"Improper value of set max number of primary numbers.");
    }
    /**
     * Test of setter of prime numbers.
     * @param maxNumber biggest possible prime number
     * @param expectedNumberOfPrimaryNumbers expected amount of returned primary numbers
     */
    @ParameterizedTest
    @CsvSource({"10,4","20,8","2,1","0,-1","-1,-1"})    
    void testSetterOfPrimeNumbers (int maxNumber, int expectedNumberOfPrimaryNumbers){
        try{
            finder = new PrimeNumberFinder(3);
        }
        catch(BadInputArgumentException ex){ 
            fail("An exception should not be thrown.");
        }
        
        try{
            finder.setPrimeNumbersMax(maxNumber);
        }
        catch(BadInputArgumentException ex){ 
            if(maxNumber<2)
                return;
            else
                fail("Exception should not be thrown");
        }
        finder.setPrimeNumbers();
        
        assertTrue(finder.getPrimeNumbers().size()!= 2,"Prime numbers were not set.");
        assertEquals(expectedNumberOfPrimaryNumbers,finder.getPrimeNumbers().size(),"Improper amount of primary numbers.");
    }
    /**
     * Test of getter of maximum of prime numbers.
     * @param maxNumber biggest possible prime number
     */
    @ParameterizedTest
    @ValueSource(ints = {10,100,67,2,0,-1})    
    void testGetterOfPrimeNumbersMax(int maxNumber){
        try{
            finder = new PrimeNumberFinder(maxNumber);
        }
        catch(BadInputArgumentException ex){ 
            if(maxNumber<2)
                return;
            else
                fail("Exception should not be thrown");
        }
        assertEquals(maxNumber,finder.getPrimeNumbersMax(),"Getter hasn't returned proper max number of primary numbers.");      
    }
}
