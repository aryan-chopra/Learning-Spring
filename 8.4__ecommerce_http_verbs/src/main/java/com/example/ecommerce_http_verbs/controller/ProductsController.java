package com.example.ecommerce_http_verbs.controller;

import com.example.ecommerce_http_verbs.model.Product;
import com.example.ecommerce_http_verbs.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Method;
import java.util.List;

@Controller
public class ProductsController {
    private final ProductService productService;

    public ProductsController(
            ProductService productService
    ) {
        this.productService = productService;
    }

    @RequestMapping(path = "/products",
                    method = RequestMethod.GET)
    public String viewProducts(Model page) {
        List<Product> products = productService.findAll();
        page.addAttribute("products", products);

        return "products.html";
    }

    @RequestMapping(path = "/products",
                    method = RequestMethod.POST)
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price,
            Model model
    ) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        productService.addProduct(product);

        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }
}
