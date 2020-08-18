/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author MUHAMMED BILAL
 */
public class Player_ScoreCard {
    private int Score;
    private String PName;

    @Override
    public String toString() {
        return "Player_ScoreCard{" + "Score=" + Score + ", PName=" + PName + '}';
    }
    
    public Player_ScoreCard(){
        Score=0;
        PName="";
    }

    public Player_ScoreCard(int Score, String PName) {
        this.Score = Score;
        this.PName = PName;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }
}
