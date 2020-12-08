package com.bsuir.WarehouseManagementSystem.controller;

import com.bsuir.WarehouseManagementSystem.model.User;
import com.bsuir.WarehouseManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model){
        model.addAttribute("users",userService.findAll());
        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}/edit")
    public String userEditForm(@PathVariable User user,Model model){
        model.addAttribute("user",user);
        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("{id}/edit")
    public String editUser(@PathVariable(value = "id") Long id,
                           @ModelAttribute User user,
                           BindingResult bindingResult){
        user.setId(id);
        userService.saveUser(user);
        return "redirect:/user";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("{id}/remove")
    public String deleteUser(@PathVariable(value = "id") Long id){
        userService.deleteUser(id);
        return "redirect:/user";
    }

    @GetMapping("/{username}/update")
    public String getProfile(Model model,
                             @PathVariable(value = "username") String username,
                             @AuthenticationPrincipal User user){
        model.addAttribute("user",user);

        return "profile";
    }

    @PostMapping("/{username}/update")
    public String updateProfile(@PathVariable(value = "username") String username,
                                @AuthenticationPrincipal User user,
                                @ModelAttribute User updatedUser,
                                BindingResult bindingResult){


        userService.saveUser(updatedUser);
        return "redirect:/user/{username}";
    }
}
