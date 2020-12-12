package com.bsuir.WarehouseManagementSystem.controller;


import com.bsuir.WarehouseManagementSystem.model.Box;
import com.bsuir.WarehouseManagementSystem.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoxController {

    @Autowired
    private BoxService boxService;

    @GetMapping("/boxes")
    public String getBoxes(Model model){
        model.addAttribute("boxes",boxService.getAllBoxes());

        return "boxesList";
    }
}
