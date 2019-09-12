package com.spectrum.charter.Dao;

import com.spectrum.charter.dto.Customer;
import com.spectrum.charter.dto.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TransactionDao {
    //List<Transaction> getTransactionByCustomerId(long id);
    public Map<String, List<Transaction>> groupTransactionPerMonth(List<Transaction> record);

    public Map<Long, Customer> groupTransactionPerCustomer(List<Transaction> record);

    public List<Transaction> setSampleData();

    public List<Transaction> getTransactionByCustomerId(long id);
}
