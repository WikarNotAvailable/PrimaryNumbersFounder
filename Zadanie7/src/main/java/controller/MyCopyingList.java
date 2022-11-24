/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * My own generic that copies existing list and then makes it possible to get elements by index.
 * @version 1.2
 * @author Daniel Wikarek
 */
public class MyCopyingList<T> {
    /**
     * Holds List structure of type T.
     */
    private List<T> list;
    /**
     * Default constructor, initializes empty list.
     */
    public MyCopyingList(){
        list = new ArrayList<>(); 
    }
    /**
     * Copies existing list passed as an arguments of function.
     * @param listToCopy list that will be copied
     */
    public void copyList(List<T> listToCopy){
        for(T item : listToCopy){
            list.add(item);
        }
    }
    /**
     * Returns item of copied list by index.
     * @param index points and element that will be returned
     * @return element of copied List that was pointed by index
     */
    public T getItem(Integer index){
        return list.get(index);
    }
    /**
     * Returns length of copied list.
     * @return length of copied list
     */
    public int getLength(){
        return list.size();
    }
    /**
     * Returns list as stream of type T.
     * @return stream
     */
    public Stream<T> copyListStream(){
        return list.stream();
    }
}
