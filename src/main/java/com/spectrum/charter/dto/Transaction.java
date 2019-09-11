package com.spectrum.charter.dto;

import java.util.Date;

public class Transaction {
    Date transactionDate;
    RewardLevel reword;
    long amount;

    public RewardLevel getReword() {
        return reword;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setReword(RewardLevel reword) {
        this.reword = reword;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private long transactionId;
    Customer customer;
}
