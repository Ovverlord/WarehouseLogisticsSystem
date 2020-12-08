package com.bsuir.WarehouseManagementSystem.controller;

import com.bsuir.WarehouseManagementSystem.model.User;
import com.bsuir.WarehouseManagementSystem.repository.UserRepository;
import com.bsuir.WarehouseManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users",userService.findAll());
        return "userList";
    }

    @GetMapping("{user}/edit")
    public String userEditForm(@PathVariable User user,Model model){
        model.addAttribute("user",user);
        return "userEdit";
    }

    @PostMapping("{user}/edit")
    public String editUser(@PathVariable(value = "user") Long id,
                           @ModelAttribute User user,
                           BindingResult bindingResult){
        user.setId(id);
        userService.saveUser(user);
        return "redirect:/user";
    }

    @PostMapping("{user}/remove")
    public String deleteUser(@PathVariable(value = "user") Long id){
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
