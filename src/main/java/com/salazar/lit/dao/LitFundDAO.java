/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salazar.lit.dao;

import com.salazar.lit.model.LitFund;
import java.util.ArrayList;

/**
 *
 * @author Johnny
 */
public interface LitFundDAO {
    
    public void insert(LitFund litFund);
    
    public void delete(LitFund litFund);
    
    public void update(LitFund litFund, int fundId);
    
    public LitFund getLitFundById(int fundId);
    
    public ArrayList<LitFund> getAllLitFunds();
    
    
    
}
