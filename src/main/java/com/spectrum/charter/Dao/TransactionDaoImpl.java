package com.spectrum.charter.Dao;

import com.spectrum.charter.dto.Customer;
import com.spectrum.charter.dto.Reward;
import com.spectrum.charter.dto.RewardLevel;
import com.spectrum.charter.dto.Transaction;
import com.spectrum.charter.service.RewardCalculationUtil;

import java.util.*;

public class TransactionDaoImpl implements TransactionDao{
    List<Transaction> records=new ArrayList<>();// representing the list of record from the data source since we dont have one in our requirement
    RewardCalculationUtil rewardCalculationUtil=new RewardCalculationUtil();
    @Override
    public List<Transaction> getTransactionByCustomerId(long id){
        List<Transaction> customerTransactionlist=new ArrayList<>();
        for(Transaction tx:records){
            if(tx.getTransactionId()==id){
                customerTransactionlist.add(tx);
            }
        }
        return customerTransactionlist;

    }

    //this method group transaction per customer  from the tranaaction record
   public  Map<Long,Customer> groupTransactionPerCustomer(List<Transaction> record){
        Map<Long,Customer> customerTransactionMap=new HashMap<>();
        for(Transaction tx:record){
           long customerId= tx.getCustomerId();
            if(customerTransactionMap.get(customerId)==null) {
                Customer customer=new Customer();
                customer.setCustomerId(customerId);
                List<Transaction> customerTransactionList = new ArrayList<>();
                customerTransactionList.add(tx);
                customer.setCustomerTransactions(customerTransactionList);
                customerTransactionMap.put(customerId, customer);
            }
            else{
                Customer customer=customerTransactionMap.get(customerId);
                customer.getCustomerTransactions().add(tx);
                customerTransactionMap.put(customerId,customer);
            }
        }
        return customerTransactionMap;
    }

    // groupd transaction per month  , the key corespond to the month and the valis is list of transaction occured in  that month
    public Map<String,List<Transaction>> groupTransactionPerMonth(List<Transaction> record){
        Map<String,List<Transaction>> monthlyTransactionMap=new HashMap<>();
        //Set<String> monthsSet=getTransactionMonths((record));

        for(Transaction tx:record){
            Calendar cal = Calendar.getInstance();
            cal.setTime(tx.getTransactionDate());
            int month = cal.get(Calendar.MONTH)+1;
            int year=cal.get(Calendar.YEAR);
            String yearmonth=year+"_"+month;
            if(monthlyTransactionMap.get(yearmonth)==null){
                List<Transaction> transactions=new ArrayList<>();
                transactions.add(tx);
                monthlyTransactionMap.put(yearmonth,transactions);
            }
            else {
                List<Transaction> transactions=monthlyTransactionMap.get(yearmonth);
                transactions.add(tx);
                monthlyTransactionMap.put(yearmonth,transactions);
            }
        }
        return monthlyTransactionMap;

    }

    public Set<String> getTransactionMonths(List<Transaction> transactions){
        Set<String> yearMonthList=new HashSet<>();
        for(Transaction tx:transactions){
            yearMonthList.add(tx.getTransactionDate().getYear()+"_"+tx.getTransactionDate().getMonth());
        }
        return yearMonthList;
    }

    //sample t=data for testing
    public List<Transaction> setSampleData(){
        Transaction t1=new Transaction();
        t1.setAmount(60);
        t1.setCustomerId(1);
        t1.setTransactionDate(new Date());

        Transaction t2=new Transaction();
        t2.setTransactionDate(new Date());
        t2.setAmount(30);
        t2.setCustomerId(2);
        Transaction t3=new Transaction();
        t3.setTransactionDate(new Date());
        t3.setAmount(120);
        t3.setCustomerId(3);
        Transaction t4=new Transaction();
        t4.setAmount(70);
        t4.setCustomerId(2);
        t4.setAmount(120);
        t4.setCustomerId(3);
        Date d=new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH ,-2);
        t4.setTransactionDate(cal.getTime());

        Transaction t5=new Transaction();
        t5.setAmount(70);
        t5.setCustomerId(4);
        t5.setAmount(120);
        //Date d=new Date();
        Calendar cal1=Calendar.getInstance();
        cal1.setTime(new Date());
        cal1.add(Calendar.MONTH ,-1);
        t5.setTransactionDate(cal1.getTime());

        List<Transaction> record=new ArrayList<>();
        record.add(t1);
        record.add(t2);
        record.add(t3);
        record.add(t4);
        record.add(t5);

        return record;
    }

}
