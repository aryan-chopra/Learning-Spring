package com.example.storing_data_jdbc_mysql.controller;

import com.example.storing_data_jdbc_mysql.model.Purchase;
import com.example.storing_data_jdbc_mysql.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("purchase")
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @PostMapping
    public void createProduct(
            @RequestBody Purchase purchase
            ) {
        purchaseRepository.storePurchase(purchase);
    }

    @GetMapping
    public List<Purchase> getPurchases() {
        return purchaseRepository.findAllPurchases();
    }
}
