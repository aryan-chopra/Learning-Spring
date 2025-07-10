package com.example.ecommerce_http_verbs_alternate_with_forms.service;

import com.example.ecommerce_http_verbs_alternate_with_forms.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> findAll() {
        return this.productList;
    }
}
