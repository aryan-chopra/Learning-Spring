package com.example.storing_data_jdbc.repository;

import com.example.storing_data_jdbc.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase VALUES (NULL, ?, ?)";

        jdbc.update(sql,
                purchase.getProduct(),
                purchase.getPrice());
    }

    public List<Purchase> findAllPurchases() {
        String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> purchaseRowMapper = (resultSet, index) -> {
            Purchase entry = new Purchase();
            entry.setId(resultSet.getInt("id"));
            entry.setProduct(resultSet.getString("product"));
            entry.setPrice(resultSet.getBigDecimal("price"));
            return entry;
        };

        return jdbc.query(sql, purchaseRowMapper);
    }
}
