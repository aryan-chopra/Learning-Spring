package com.example.spring_data.service;

import com.example.spring_data.dao.AccountDAO;
import com.example.spring_data.dto.AmountTransferDTO;
import com.example.spring_data.entity.Account;
import com.example.spring_data.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AmountTransferService {

    @Autowired
    private AccountDAO accountDAO;

    @Transactional
    public void transferMoney(AmountTransferDTO amountTransferDTO) {
        Account sender = accountDAO.findById(amountTransferDTO.getSenderId())
                .orElseThrow(AccountNotFoundException::new);

        Account receiver = accountDAO.findById(amountTransferDTO.getReceiverId())
                .orElseThrow(AccountNotFoundException::new);

        BigDecimal senderNewBalance = sender.getBalance()
                .subtract(amountTransferDTO.getAmount());

        BigDecimal receiverNewBalance = receiver.getBalance()
                .add(amountTransferDTO.getAmount());

        accountDAO.changeAmount(sender.getId(), senderNewBalance);
        accountDAO.changeAmount(receiver.getId(), receiverNewBalance);
    }

    public Iterable<Account> getAllAccounts() {
        return accountDAO.findAll();
    }
}
