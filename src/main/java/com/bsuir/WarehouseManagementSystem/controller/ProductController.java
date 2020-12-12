package com.bsuir.WarehouseManagementSystem.controller;

import com.bsuir.WarehouseManagementSystem.model.Product;
import com.bsuir.WarehouseManagementSystem.model.User;
import com.bsuir.WarehouseManagementSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @PreAuthorize("hasAuthority('CHECKMAN')")
    @GetMapping("/getProducts")
    public String getProducts(Model model){

        model.addAttribute("products",productService.findAll());

        return "productsList";
    }

    @PreAuthorize("hasAuthority('CHECKMAN')")
    @GetMapping("/addProduct")
    public String productAddForm(){

        return "addProduct";
    }

    @PreAuthorize("hasAuthority('CHECKMAN')")
    @PostMapping("/addProduct")
    public String addProduct(Product product, Map<String,Object> model){

        productService.save(product);
        return "redirect:/getProducts";
    }


    @PreAuthorize("hasAuthority('CHECKMAN')")
    @GetMapping("/product/{product}/edit")
    public String userEditForm(@PathVariable Product product, Model model){
        model.addAttribute("product",product);
        return "editProduct";
    }

    @PreAuthorize("hasAuthority('CHECKMAN')")
    @PostMapping("/product/edit")
    public String updateProduct(@ModelAttribute Product product,BindingResult bindingResult){

        productService.editProduct(product);
        return "redirect:/getProducts";
    }

    @PreAuthorize("hasAuthority('CHECKMAN')")
    @PostMapping("/product/{id}/remove")
    public String removeProduct(@PathVariable(value = "id") Long id)
    {
        productService.removeProduct(id);
        return "redirect:/getProducts";
    }

    @PreAuthorize("hasAuthority('CHECKMAN')")
    @GetMapping("/acceptance")
    public String acceptance(Model model){

        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "acceptance";
    }

    @PreAuthorize("hasAuthority('CHECKMAN')")
    @PostMapping("/acceptance")
    public String acceptance(@RequestParam String selectId,
                             @RequestParam Integer quantity){

        productService.acceptProduct(Long.valueOf(selectId),quantity);

        return "redirect:/getProducts";
    }
}
