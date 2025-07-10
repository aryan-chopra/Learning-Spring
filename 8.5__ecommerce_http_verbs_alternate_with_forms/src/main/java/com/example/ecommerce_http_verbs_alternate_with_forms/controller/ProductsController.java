package com.example.ecommerce_http_verbs_alternate_with_forms.controller;

import com.example.ecommerce_http_verbs_alternate_with_forms.model.Product;
import com.example.ecommerce_http_verbs_alternate_with_forms.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductsController {
    private final ProductService productService;

    public ProductsController(
            ProductService productService
    ) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model page) {
        List<Product> products = productService.findAll();
        page.addAttribute("products", products);

        return "products.html";
    }

    @PostMapping("/products")
    public String addProduct(
            Product product,
            Model model
    ) {
        productService.addProduct(product);

        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }
}
