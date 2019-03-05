/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salazar.lit.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Johnny
 */

@Controller
public class IndexController {
    @GetMapping("/index")
    public String indexAction(HttpServletRequest request, String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
    
    @GetMapping("/sample")
    public String sampleAction(HttpServletRequest request, String name, Model model) {
        model.addAttribute("name", name);
        return "sample";
    }
  
}
