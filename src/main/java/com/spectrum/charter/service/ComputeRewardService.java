package com.spectrum.charter.service;

import com.spectrum.charter.Dao.TransactionDao;
import com.spectrum.charter.Dao.TransactionDaoImpl;
import com.spectrum.charter.dto.Customer;
import com.spectrum.charter.dto.Transaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputeRewardService {
    TransactionDao TransactionDaoImpl=new TransactionDaoImpl();
    RewardCalculationUtil rewardCalculationUtil=new RewardCalculationUtil();

    public void computeCustomerMonthlyReward(List<Transaction> record){
        Map<String,List<Transaction>> monthsTransactionMap= TransactionDaoImpl.groupTransactionPerMonth(record); // group transaction monthly
        for(String month: monthsTransactionMap.keySet()){
            List<Transaction> monthlyTranactions=monthsTransactionMap.get(month);
            Map<Long, Customer> customerMontlyTransaction =TransactionDaoImpl.groupTransactionPerCustomer(monthlyTranactions);
            System.out.println("------------reward for "+month+" Month-----------------");
            for(Long customerId:customerMontlyTransaction.keySet()){
                Customer customer=customerMontlyTransaction.get(customerId);
                System.out.println("Customer "+customerId+" reward="+computeCustomerTotalReward(customer)+" point");
            }
        }


    }
    public void computCutomerTotalRewar(List<Transaction> record){
        Map<Long,Customer> customers= customers=TransactionDaoImpl.groupTransactionPerCustomer(record);
        for(Long customerId:customers.keySet()){
            Customer customer=customers.get(customerId);
            System.out.println("Customer  "+customerId+" Total Rewar reward="+computeCustomerTotalReward(customer)+" point");
        }




    }
    public long computeCustomerTotalReward(Customer customer){
        Map<Long,Long> totalRecordPerUserMap=new HashMap<>();
        long customerReward=0;
        for(Transaction tx:customer.getCustomerTransactions()){
            customerReward+=rewardCalculationUtil.calculateReward(tx);
        }
        // totalRecordPerUserMap.put(customer.getCustomerId(),customerReward);

        return customerReward;

    }

    //  called after grouping transaction per customer from the record , the key is the customer id and value customer total reward
    // this method a map with customer id as key and their total reward
    public Map<Long,Long> computeCustomerTotalReward(List<Customer> customers){
        Map<Long,Long> totalRecordPerUserMap=new HashMap<>();
        for(Customer customer:customers){
            long customerReward=0;
            for(Transaction tx:customer.getCustomerTransactions()){
                customerReward+=rewardCalculationUtil.calculateReward(tx);
            }
            totalRecordPerUserMap.put(customer.getCustomerId(),customerReward);

        }
        return totalRecordPerUserMap;

    }
}
