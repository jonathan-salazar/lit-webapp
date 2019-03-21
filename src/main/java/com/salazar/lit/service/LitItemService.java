/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salazar.lit.service;

import com.salazar.lit.dao.LitFundDAO;
import com.salazar.lit.dao.LitFundDAOSqlImpl;
import com.salazar.lit.dao.LitItemDAO;
import com.salazar.lit.dao.LitItemDAOSqlImpl;
import com.salazar.lit.dao.MetaDataDAO;
import com.salazar.lit.dao.MetaDataDAOSqlImpl;
import com.salazar.lit.model.LitException;
import com.salazar.lit.model.LitFund;
import com.salazar.lit.model.LitItem;
import com.salazar.lit.model.MetaData;
import java.util.ArrayList;

/**
 *
 * @author Johnny
 */
public class LitItemService {
    public LitItemService(){
        
    }

    public void addLitItem(LitItem litItem) throws LitException{
        //Check all attributes are correctly inserted
        LitItemDAO litDAO = new LitItemDAOSqlImpl();
        
        String investorComId;
        String idLanguage = litItem.getLangVersion();
        String idDelivery = litItem.getDeliveryType();
        
        //Create a new column in table for num val or is that the same as itemId????
        int idNumericVal = 1; 
        
        String idSeries = litItem.getSeries();
        String idContentType = litItem.getContentType();
        String padding = "0000";
        
        if (idLanguage != null && idDelivery != null ) {
        	if(idNumericVal < 10) {
        		padding = "0000";
        	} else if(idNumericVal >= 10 && idNumericVal < 100) {
        		padding = "000";
        	} else if(idNumericVal >= 100 && idNumericVal < 1000) {
        		padding = "00";
        	} else if(idNumericVal >= 1000 && idNumericVal < 10000) {
        		padding = "0";
        	}
        	
        	investorComId = idLanguage + "-" + padding + idNumericVal + "-" + idDelivery;
        	
        	if(idSeries != null ) {
        		investorComId = investorComId + "-" + idSeries;
        	}
        	
        	if(idContentType != null) {
        		investorComId = investorComId + "-" + idContentType;
        	}
        	
        	litItem.setInvestorComId(investorComId);
        	litDAO.insert(litItem);
        } else {
        	System.out.println("Either language version or delivery type is not defined.");
        }
    }

    public void addLitFund(LitFund litFund) throws LitException{
        //Check fundId and get fund name/short name
        LitFundDAO fundDAO = new LitFundDAOSqlImpl();
        fundDAO.insert(litFund);
    }
    
    public void addMetaData(MetaData mData) throws LitException{
        MetaDataDAO metaDAO = new MetaDataDAOSqlImpl();
        metaDAO.insert(mData);
    }
    
    public ArrayList<LitItem> searchByKeyword(String keyword){
        LitItemDAO litDAO = new LitItemDAOSqlImpl();
        ArrayList<LitItem> list = litDAO.searchByKeyword(keyword);
        return list;
    }
}
