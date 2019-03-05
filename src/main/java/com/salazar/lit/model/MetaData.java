/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salazar.lit.model;

import java.util.HashMap;

/**
 *
 * @author Johnny
 */
public class MetaData {
    
    HashMap<Integer, String> dataMap = new HashMap<>();

    
    public void addElement(int key, String value){
        dataMap.put(key, value);   
    }


    public String getElementValue(int key){
        return dataMap.get(key);   
    }

    public HashMap<Integer, String> getDataMap() {
        return dataMap;
    }

    public void setDataMap(HashMap<Integer, String> dataMap) {
        this.dataMap = dataMap;
    }
    
}
