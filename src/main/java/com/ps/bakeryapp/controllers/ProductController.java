package com.ps.bakeryapp.controllers;

import com.ps.bakeryapp.models.Product;
import com.ps.bakeryapp.services.ImageService;
import com.ps.bakeryapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class ProductController {

    private ProductService productService;
    private ImageService imageService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/oferta")
    public String productHome(Model model){

        model.addAttribute("products", productService.getAll());

        return "offert";
    }

    @GetMapping("/add")
    public String addProductToBase(Model model) {
        model.addAttribute("product", new Product());

        return "addproductform";
    }

    @PostMapping("/add/product")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> {
                System.out.println(objectError.getObjectName());
            });

            return "/add";
        }
        productService.saveProduct(product);

        return "redirect:/oferta";
    }

    @GetMapping("{id}/add/picture")
    public String imageUploadForm(@PathVariable String id, Model model){
        model.addAttribute("product", productService.findById(Long.valueOf(id)));

        return "imageuploadform";
    }

    @PostMapping("/{id}/add/picture")
    public String handleImagePost(@PathVariable String id, @RequestParam("picture") MultipartFile picture) {

        imageService.saveImageFile(Long.valueOf(id), picture);

        return "homepage";
    }

}
