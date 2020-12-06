package com.bsuir.WarehouseManagementSystem.controller;

import com.bsuir.WarehouseManagementSystem.model.User;
import com.bsuir.WarehouseManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user,Model model){
        model.addAttribute("user",user);
        return "userEdit";
    }

    @PostMapping
    public String editUser(@RequestParam("userId") User user){

        userRepository.save(user);
        return "redirect:/user";
    }
}
