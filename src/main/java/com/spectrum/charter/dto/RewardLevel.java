package com.spectrum.charter.dto;

public enum RewardLevel {
    LEVEL50  (1), // reward for tranasaction below 50
    LEVEL100(2); // for transaction above 100
    private final int rewardCode;

    private RewardLevel(int levelCode) {
        this.rewardCode = levelCode;
    }
    public int getRewardCode(){
        return this.rewardCode;
    }
}
