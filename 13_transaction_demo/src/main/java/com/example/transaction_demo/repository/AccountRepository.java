package com.example.transaction_demo.repository;

import com.example.transaction_demo.mapper.AccountMapper;
import com.example.transaction_demo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Repository
public class AccountRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public Account getAccountDetails(long id) {
        String query = "SELECT * FROM accounts WHERE id = ?";

        return jdbc.queryForObject(query, new AccountMapper(), id);
    }

    public void updateAmmount(long id, BigDecimal amount) {
        String query = "UPDATE accounts SET balance = ? WHERE id = ?";

        jdbc.update(query, amount, id);
    }

    public List<Account> getAllAccounts() {
        String query = "SELECT * FROM accounts";

        return jdbc.query(query, new AccountMapper());
    }
}
