/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salazar.lit.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salazar.lit.model.LitItem;
import com.salazar.lit.service.LitItemService;

/**
 *
 * @author Johnny
 */

@Controller
public class SearchController {
    @GetMapping("/search")
    public String searchLitItem(HttpServletRequest request, String name, Model model) {
        LitItem newLitItem = new LitItem();
        model.addAttribute("newLitItem", newLitItem);
        return "search";
    }

    @GetMapping("/advanced-search")
    public String advancedSearchAction(HttpServletRequest request, String name, Model model) {
        model.addAttribute("name", name);
        return "advanced-search";
    }

    @PostMapping(value = "/search-results")
    public String searchAction(@ModelAttribute("searchLitItem")LitItem searchLitItem, ModelMap model) {
        LitItemService litService = new LitItemService();
        ArrayList<LitItem> litItemList = new ArrayList();

        String errorMsg = "Cannot find search results";

        try{
            System.out.println("Starting to prepare lit item search results");

            String searchKeyword = searchLitItem.getSearchKeyword();

            litItemList = litService.searchByKeyword(searchKeyword);
            model.addAttribute("litItemList", litItemList);


        } catch(Exception e) {
            model.addAttribute("errorMsg", errorMsg);
        }

        return "search-results";
    }

}
