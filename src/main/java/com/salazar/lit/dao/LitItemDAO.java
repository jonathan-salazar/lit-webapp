/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salazar.lit.dao;

import com.salazar.lit.model.LitItem;
import java.util.ArrayList;

/**
 *
 * @author Johnny
 */
public interface LitItemDAO {

    public void insert(LitItem l);
    
    public void delete(int itemId);
    
    public void update(LitItem l, int itemId);
    
    public LitItem getLitItemById(int itemId);
        
    public ArrayList<LitItem> getAllLitItems();
    
    public ArrayList<LitItem> searchByKeyword(String keyword);
}

