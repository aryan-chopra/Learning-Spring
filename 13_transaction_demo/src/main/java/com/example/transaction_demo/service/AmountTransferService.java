package com.example.transaction_demo.service;

import com.example.transaction_demo.model.Account;
import com.example.transaction_demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
// Or the class can be @Transactional
public class AmountTransferService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void transferMoney(
            long senderId,
            long reveiverId,
            BigDecimal amount
    ) {
        Account sender = accountRepository.getAccountDetails(senderId);
        Account receiver = accountRepository.getAccountDetails(reveiverId);

        BigDecimal receiverNewAmount = receiver.getBalance().add(amount);
        accountRepository.updateAmmount(reveiverId, receiverNewAmount);

        BigDecimal senderNewAmount = sender.getBalance().subtract(amount);
        if (senderNewAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money to deduct");
        }
        accountRepository.updateAmmount(senderId, senderNewAmount);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }
}
