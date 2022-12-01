package com.day7.gambling;

import java.util.Random;

public class GamblingSimulator {
    public static final int STARTING_BET_STAKE = 100;
    public static final int MINIMUM_BET_PER_GAME = 1;

    /* in this method Gambler make $1 bet to win or loose $1 */
    public void gamblingPerDay(){
        double randomNumber = Math.random();
        int remainStake = STARTING_BET_STAKE;
        if (randomNumber > 0.5){
            remainStake += MINIMUM_BET_PER_GAME;
            System.out.println("The Gambler wins the bet and he has $"+remainStake+ " with him after one bet.");
        }else{
            remainStake -= MINIMUM_BET_PER_GAME;
            System.out.println("The Gambler loses the bet and he has $"+remainStake+ " with him after one bet.");
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Simulator Program :");
        System.out.println("Initaial Amount of Stake :"+STARTING_BET_STAKE);
        System.out.println("Amount of Bet stake is :"+MINIMUM_BET_PER_GAME);
        GamblingSimulator gamblingSimulator = new GamblingSimulator();
        gamblingSimulator.gamblingPerDay();

    }
}

