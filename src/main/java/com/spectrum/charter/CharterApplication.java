package com.spectrum.charter;

import com.spectrum.charter.Dao.TransactionDaoImpl;
import com.spectrum.charter.dto.Transaction;
import com.spectrum.charter.service.ComputeRewardService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@SpringBootApplication
public class CharterApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CharterApplication.class, args);
		ComputeRewardService computeRewardService=new ComputeRewardService();
		TransactionDaoImpl transactionDao=new TransactionDaoImpl();
		List<Transaction> records=transactionDao.setSampleData();
		computeRewardService.computeCustomerMonthlyReward(records);
		System.out.println("\n------Total Reward-------");
		computeRewardService.computCutomerTotalRewar(records);
	}

}
