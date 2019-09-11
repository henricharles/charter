package com.spectrum.charter.Dao;

import com.spectrum.charter.dto.Transaction;

import java.util.List;

public interface TransactionDao {
    List<Transaction> getTransactionByCustomerId();

}
