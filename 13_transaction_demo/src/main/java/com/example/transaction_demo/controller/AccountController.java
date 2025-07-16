package com.example.transaction_demo.controller;

import com.example.transaction_demo.dto.TransferRequest;
import com.example.transaction_demo.model.Account;
import com.example.transaction_demo.service.AmountTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AmountTransferService amountTransferService;

    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest transferRequest
    ) {
        amountTransferService.transferMoney(
                transferRequest.getSenderId(),
                transferRequest.getReceiverId(),
                transferRequest.getAmount()
        );
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return amountTransferService.getAllAccounts();
    }
}
