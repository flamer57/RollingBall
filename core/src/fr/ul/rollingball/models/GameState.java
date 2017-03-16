package fr.ul.rollingball.models;

/**
 * Created by molina9u on 17/02/17.
 */

public class GameState {
    public enum etats{
        Running,
        Victory,
        Loss;
    }
    protected static int timeTotal;
    protected etats currentState;
    protected int score;
    protected int timeLeft;
    protected int pillsEaten;

    public GameState(){
        currentState=etats.Running;
        timeTotal=30;
        timeLeft=30;
        score=0;
        pillsEaten=0;

    }

    public static int getTimeTotal() {
        return timeTotal;
    }

    public static void setTimeTotal(int timeTotal) {
        GameState.timeTotal = timeTotal;
    }

    public etats getCurrentState() {
        return currentState;
    }

    public void setCurrentState(etats currentState) {
        this.currentState = currentState;
    }

    public int getScore() {
        return score;
    }

    public void upScore(int score) {
        this.score += score;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void upTimeLeft(int timeLeft) {
        this.timeLeft += timeLeft;

    }

    public void resetTime(){
        timeLeft = timeTotal ;
    }

    public void runningTime(float t){
        if (isRunning()) {
            this.timeLeft -= t;
        }
    }

    public int getPillsEaten() {
        return pillsEaten;
    }

    public void setPillsEaten(int pillsEaten) {
        this.pillsEaten = pillsEaten;
    }

    public boolean isRunning(){
        return currentState==etats.Running;
    }

    public boolean isWon(){
        return currentState==etats.Victory;
    }

    public boolean isLost(){
        return currentState==etats.Loss;
    }
}

