package com.example.spring_data.controller;

import com.example.spring_data.dto.AmountTransferDTO;
import com.example.spring_data.entity.Account;
import com.example.spring_data.service.AmountTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @Autowired
    private AmountTransferService amountTransferService;

    @PostMapping("/transfer")
    public void amountTransferController(
            @RequestBody AmountTransferDTO amountTransferDTO
            ) {
        amountTransferService.transferMoney(amountTransferDTO);
    }

    @GetMapping("/")
    public Iterable<Account> getAllAccounts() {
        return amountTransferService.getAllAccounts();
    }
}
