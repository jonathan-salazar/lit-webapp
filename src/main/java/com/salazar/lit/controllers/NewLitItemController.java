/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salazar.lit.controllers;

import com.salazar.lit.model.LitFund;
import com.salazar.lit.model.LitException;
import com.salazar.lit.model.LitItem;
import com.salazar.lit.service.LitItemService;
import com.salazar.lit.model.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Johnny
 */

@Controller
public class NewLitItemController {
    @GetMapping("/new-lit-item")
    public String newLitItem(HttpServletRequest request, String name, Model model) {
        LitItem newLitItem = new LitItem();
       // MetaData mData = new MetaData();

        newLitItem.setTitle("Sample Lit Item");
        newLitItem.setDescription("Please enter something here.");
       
//        for(int i=0; i<10; i++){
//            mData.addElement(i, i + ":meta-data-name");
//        }
        
        model.addAttribute("newLitItem", newLitItem);
        
        
        return "new-lit-item";
    }
    
    @ModelAttribute("metaDataList")
   public ArrayList<String> getMetaDataList() {
      ArrayList<String> metaDataList = new ArrayList<String>();
      metaDataList.add("On-Web");
      metaDataList.add("MERS");
      metaDataList.add("Results");
      metaDataList.add("PM Years of Exp");
      metaDataList.add("Annual Stats");
      metaDataList.add("Capital Advantage");
      metaDataList.add("Morningstar Stewardship");
      metaDataList.add("Firm Specific");
      return metaDataList;
   }
    
    @ModelAttribute("deliveryList")
    public Map<String, String> getDeliveryList() {
        Map<String, String> deliveryList = new HashMap<String, String>();
        deliveryList.put("EL", "Email");
        deliveryList.put("PT", "Print");
        deliveryList.put("BR", "Brochure");
        return deliveryList;
    }
    
    @ModelAttribute("langList")
    public Map<String, String> getLanguageList() {
        Map<String, String> langList = new HashMap<String, String>();
        langList.put("EN", "English");
        langList.put("FR", "French");
        return langList;
    }

    @ModelAttribute("yesList")
    public Map<String, String> getYesList() {
        Map<String, String> yesList = new HashMap<String, String>();
        yesList.put("Yes", "Yes");
        yesList.put("No", "No");
        yesList.put("N/A", "N/A");
        return yesList;
    }
    
    @ModelAttribute("frequencyList")
    public Map<String, String> getFrequencyList() {
        Map<String, String> frequencyList = new HashMap<String, String>();
        frequencyList.put("Annual", "Annual");
        frequencyList.put("Monthly", "Monthly");
        frequencyList.put("One-Time", "One-Time");
        frequencyList.put("Quarterly", "Quarterly");
        frequencyList.put("Semi-Annual", "Semi-Annual");
        frequencyList.put("N/A", "N/A");
        return frequencyList;
    }
    
    @RequestMapping(value = "/new-lit-item-success", method = RequestMethod.POST)
    public String newLitItemAction(@ModelAttribute("newLitItem")LitItem newLitItem, ModelMap model) {
        try{
            LitItemService litItemService = new LitItemService();
            litItemService.addLitItem(newLitItem);
            
            
            //System.out.println("MetaData: ");
            
            
            
        } catch (LitException e) {
            Logger.getLogger(NewLitItemController.class.getName()).log(Level.SEVERE, null, e);
        }
        
                 
                 
       // LitFund newLitFund = new LitFund();
       // MetaData newMetaData = new MetaData();

//        model.addAttribute("title", newLitItem.getTitle());
//        model.addAttribute("investorComId", newLitItem.getInvestorComId());
//        model.addAttribute("investorComIdOld", newLitItem.getInvestorComIdOld());
//        model.addAttribute("oldCodeInUse", newLitItem.getOldCodeInUse());
//        model.addAttribute("langVersion", newLitItem.getLangVersion());
//        model.addAttribute("deliveryType", newLitItem.getDeliveryType());
//        model.addAttribute("active", newLitItem.getActive());
//        model.addAttribute("series", newLitItem.getSeries());  
//        model.addAttribute("rebranded", newLitItem.getRebranded());
//        model.addAttribute("contentType", newLitItem.getContentType());  
//        model.addAttribute("frequency", newLitItem.getFrequency());  
//        model.addAttribute("searchKeyword", newLitItem.getSearchKeyword());
//        model.addAttribute("description", newLitItem.getDescription());
//        
        
        return "new-lit-item-success";
   }
        
        
//        LitItemService litItemService = new LitItemService();
//        LitItem newLitItem = new LitItem(); 
//        LitFund newLitFund = new LitFund();
//        MetaData newMetaData = new MetaData();

        //LitItem Info
        //Funds Info
        //Is Fund Id gonna be a check box? if so what type is that? boolean?
        //int fundId = request.getParameter("");
        //String fundName = request.getParameter("");
        //String fundShortName = request.getParameter("fund-short-name");
        
        //MetaData
//        String onWeb = request.getParameter("on-web");
//        String mers = request.getParameter("mers");
//        String results = request.getParameter("results");
//        String pmYrsOfExp = request.getParameter("pm-years-of-exp");
//        String annualStats = request.getParameter("annual-stats");
//        String capAdv = request.getParameter("capital-advantage");
//        String mstarStewardship = request.getParameter("morningstar-stewardship");
//        String firmSpecific = request.getParameter("firm-specific");
//        
//        //Set attributes for Lit Item
//        newLitItem.setInvestorComId(investorComIdNew);
//        newLitItem.setInvestorComIdOld(investorComIdOld);
//        newLitItem.setOldCodeInUse(oldCodeInUse);
//        newLitItem.setTitle(title);
//        newLitItem.setLangVersion(langVersion);
//        newLitItem.setDeliveryType(deliveryType);
//        newLitItem.setSeries(seriesSpecific);
//        newLitItem.setActive(active);
//        newLitItem.setRebranded(rebranded);
//        newLitItem.setContentType(contentType);
//        newLitItem.setFrequency(frequency);
//        newLitItem.setSearchKeyword(searchKeyword);
//        newLitItem.setDescription(description);
        
        //Set attributes for Lit Item Fund
        //newLitFund.setFundName(fundName);
        //newLitFund.setFundShortName(fundShortName);
        
        //Set attributes for Lit Item MetaData
        
        
//        try{
//           litItemService.addLitItem(newLitItem);
//          //  litItemService.addLitFund(newLitFund);
//          //  litItemService.addMetaData(newMetaData);
//            
//        } catch(LitException e) {
//            
//        }
//
//        return "new-lit-item-success";
//    }
}