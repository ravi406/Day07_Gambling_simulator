package com.day7.gambling;

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

    /*in this method we are calculating gambler win or loose by giving extra margin 50%  */
    public void playingConditionForGame(){
        double maxMargin = STARTING_BET_STAKE + (0.5*STARTING_BET_STAKE);
        double minMargin = STARTING_BET_STAKE - (0.5*STARTING_BET_STAKE);
        double availAmount = STARTING_BET_STAKE;

        while ((availAmount < maxMargin) && (availAmount > minMargin)){
            double randomNum = Math.random();
            if (randomNum > 0.5){
                availAmount += MINIMUM_BET_PER_GAME;
            }else{
                availAmount -= MINIMUM_BET_PER_GAME;
            }
        }
        System.out.println("The gambler resigns for the day after he has $"
                + availAmount + " with him.");
    }
    /* in this method calculating total amount won or lost Playing for 20 days */
    public void playingFor20Days(){
         /* Assume 100 bets played every day */
        int NO_OF_BETS = 100;
        double maxMargin = (0.5*STARTING_BET_STAKE);
        double minMargin = -(0.5*STARTING_BET_STAKE);
        double totAmtWonLost = 0;

        /* Game played for 20 days */
        for (int i=0;i<20;i++){
            double dailyAmtWonLost = 0;
            int betsPlayed = 0;

            /* Everyday game stops at 50% margin */
            while ((dailyAmtWonLost < maxMargin) && (dailyAmtWonLost > minMargin) && (betsPlayed < NO_OF_BETS)){
                double randomNum = Math.random();
                betsPlayed++;

                if (randomNum > 0.5){
                    dailyAmtWonLost += MINIMUM_BET_PER_GAME;
                }else{
                    dailyAmtWonLost -= MINIMUM_BET_PER_GAME;
                }
            }
            totAmtWonLost += dailyAmtWonLost;
        }

        /* Print total amount won or last in 20 days */
        if (totAmtWonLost > 0){
            System.out.println("The total amount won in 20 days = "+ totAmtWonLost);
        }
        else if (totAmtWonLost == 0){
            System.out.println("There is no net gain in last 20 days");
        }
        else{
            System.out.println("The total amount lost in last 20 days = "+ Math.abs(totAmtWonLost));
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Gambling Simulator Program :");
        System.out.println("Initial Amount of Stake :"+STARTING_BET_STAKE);
        System.out.println("Amount of Bet stake is :"+MINIMUM_BET_PER_GAME);
        GamblingSimulator gamblingSimulator = new GamblingSimulator();
        gamblingSimulator.gamblingPerDay();
        gamblingSimulator.playingConditionForGame();
        gamblingSimulator.playingFor20Days();
    }
}

