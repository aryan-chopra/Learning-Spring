package com.example.storing_data_jdbc_mysql_custom_datasource.repository;

import com.example.storing_data_jdbc_mysql_custom_datasource.model.Purchase;
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
        String sql = "INSERT INTO purchase (product, price) VALUES (?, ?)";

        jdbc.update(sql,
                purchase.getProduct(),
                purchase.getPrice());
    }

    public List<Purchase> findAllPurchases() {
        String sql = "Select * FROM purchase";

        RowMapper<Purchase> purchaseRowMapper = (row, index) -> {
            Purchase rowData = new Purchase();
            rowData.setId(row.getInt("id"));
            rowData.setProduct(row.getString("product"));
            rowData.setPrice(row.getBigDecimal("price"));

            return rowData;
        };

        return jdbc.query(sql, purchaseRowMapper);
    }
}
