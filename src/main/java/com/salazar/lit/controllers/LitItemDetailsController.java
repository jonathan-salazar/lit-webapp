/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salazar.lit.controllers;

import com.salazar.lit.model.LitItem;
import com.salazar.lit.model.MetaData;
import com.salazar.lit.service.LitItemService;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Johnny
 */

@Controller
public class LitItemDetailsController {
    @GetMapping("/lit-item-details")
    public String getLitItemDetails(HttpServletRequest request, String name, Model model) {
        model.addAttribute("name", name);
        LitItemService litService = new LitItemService();
        LitItem litItem = new LitItem();
        MetaData metaData = new MetaData();
        ArrayList<LitItem> litList = new ArrayList();
        
        String errorMsg = "Cannot find lit item details";
        
        try{
            System.out.println("Starting to prepare lit item info");
            
            //String strLitItemId = request.getParameter("item-id");
           // int litItemId = Integer.parseInt(strLitItemId);
            
           // litList = litService.getLitItemDetails(litItemId);
          //  model.addAttribute("accountTransactions", transactionList);
          //  model.addAttribute("account", account);


        } catch(Exception e) {
            model.addAttribute("errorMsg", errorMsg);
        }
        return "lit-item-details";
    }
}
