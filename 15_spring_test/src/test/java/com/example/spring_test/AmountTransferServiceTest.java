package com.example.spring_test;

import com.example.spring_test.dao.AccountDAO;
import com.example.spring_test.dto.AmountTransferDTO;
import com.example.spring_test.entity.Account;
import com.example.spring_test.exception.AccountNotFoundException;
import com.example.spring_test.service.AmountTransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class AmountTransferServiceTest {

    @Mock
    AccountDAO accountDAO;

    @InjectMocks
    AmountTransferService amountTransferService;

    @Test
    public void moneyTransferHappyFlow() {
        Account sender = new Account();
        sender.setId(1);
        sender.setBalance(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(2);
        receiver.setBalance(new BigDecimal(1000));

        when(accountDAO.findById(sender.getId()))
                .thenReturn(Optional.of(sender));

        when(accountDAO.findById(receiver.getId()))
                .thenReturn(Optional.of(receiver));

        AmountTransferDTO dto = new AmountTransferDTO();
        dto.setSenderId(sender.getId());
        dto.setReceiverId(receiver.getId());
        dto.setAmount(new BigDecimal(1000));

        amountTransferService.transferMoney(dto);

        verify(accountDAO).changeAmount(1L, new BigDecimal(0));
        verify(accountDAO).changeAmount(2L, new BigDecimal(2000));
    }

    @Test
    public void moneyTransferReceiverNotFound() {
        Account sender = new Account();
        sender.setId(1L);

        when(accountDAO.findById(1L)).thenReturn(Optional.of(sender));
        when(accountDAO.findById(2L)).thenReturn(Optional.empty());

        AmountTransferDTO dto = new AmountTransferDTO();
        dto.setSenderId(1L);
        dto.setReceiverId(2L);
        dto.setAmount(new BigDecimal(1000));

        assertThrows(AccountNotFoundException.class,
                () -> amountTransferService.transferMoney(dto)
        );
        verify(accountDAO, never())
                .changeAmount(anyLong(), any());
    }
}
