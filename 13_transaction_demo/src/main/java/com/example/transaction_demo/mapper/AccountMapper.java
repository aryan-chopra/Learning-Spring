package com.example.transaction_demo.mapper;

import com.example.transaction_demo.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet row, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(row.getLong("id"));
        account.setName(row.getString("name"));
        account.setBalance(row.getBigDecimal("balance"));
        return account;
    }
}
