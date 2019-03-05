/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salazar.lit.dao;

import com.salazar.lit.model.MetaData;
import java.util.ArrayList;

/**
 *
 * @author Johnny
 */
public interface MetaDataDAO {
    
    public void insert(MetaData mData);
    
    public void delete(MetaData mData);
    
    public void update(MetaData mData, int metaId);
    
    public MetaData getMetaDataById(int metaId);
        
    public ArrayList<MetaData> getAllMetaData();
}
