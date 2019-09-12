package com.spectrum.charter.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
    String ciustomerName;
    long customerId;
    List<Transaction> customerTransactions=new ArrayList<>();

    public List<Transaction> getCustomerTransactions() {
        return customerTransactions;
    }

    public void setCustomerTransactions(List<Transaction> customerTransactions) {
        this.customerTransactions = customerTransactions;
    }

    public String getCiustomerName() {
        return ciustomerName;
    }

    public void setCiustomerName(String ciustomerName) {
        this.ciustomerName = ciustomerName;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}
