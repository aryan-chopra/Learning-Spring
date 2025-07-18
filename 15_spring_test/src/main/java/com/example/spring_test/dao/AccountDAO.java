package com.example.spring_test.dao;

import com.example.spring_test.entity.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface AccountDAO extends CrudRepository<Account, Long> {

    @Query("SELECT * FROM accounts WHERE name = :name")
    List<Account> findAccountsByName(@Param("name") String name);

    @Modifying
    @Query("UPDATE accounts SET balance = :amount WHERE id = :id")
    void changeAmount(
            @Param("id") long id,
            @Param("amount") BigDecimal amount);

}
