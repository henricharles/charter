package com.spectrum.charter.service;

import com.spectrum.charter.dto.RewardLevel;
import com.spectrum.charter.dto.Transaction;

public class RewardCalculationUtil {

   /* this method calculate the record
    point base of the amount per tranaction
    */

    public long calculateReward(Transaction transaction){
        long amount=transaction.getAmount();
        long transactionrewardValue=computeRewardLevel50(amount)+computeRewardWithLevel100(amount);
        return transactionrewardValue;
    }

    public long  computeRewardLevel50(long amount){
        long rewardValue=0;
        if(amount>=100){
            rewardValue=rewardValue+50* RewardLevel.LEVEL50.getRewardCode();
        }
        else{
            if(amount>50){
                rewardValue=RewardLevel.LEVEL50.getRewardCode()*(amount-50);
            }
        }
        return rewardValue;
    }

    public long computeRewardWithLevel100(long amount) {
        long rewardValue = 0;
        if (amount > 100) {
            rewardValue = (amount - 100) * RewardLevel.LEVEL100.getRewardCode();
        }
        return rewardValue;
    }
}
