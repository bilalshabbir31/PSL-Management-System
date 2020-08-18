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
public class ScoreCard {
    private String MatchID,PlayerID,TeamID,Inning,Outby,OutType;
    private int runedScored,RunsConceed,Nowide,NOBalls;
    private float OverBlowed;
    @Override
    public String toString() {
        return "ScoreCard{" + "MatchID=" + MatchID + ", PlayerID=" + PlayerID + ", TeamID=" + TeamID + ", Inning=" + Inning + ", Outby=" + Outby + ", OutType=" + OutType +  ", runedScored=" + runedScored + ", RunsConceed=" + RunsConceed + ", Nowide=" + Nowide + ", NOBalls=" + NOBalls + ", OverBlowed=" + OverBlowed + '}';
    }
    

    public ScoreCard() {
        MatchID=PlayerID=TeamID=Inning=Outby=OutType="";
        OverBlowed=0;
        runedScored=RunsConceed=Nowide=NOBalls=0;
    }

    public ScoreCard(String TeamID, String MatchID,String PlayerID,int runedScored,String Inning, String Outby, String OutType,  int RunsConceed,float OverBlowed,int Nowide, int NOBalls) {
        this.MatchID = MatchID;
        this.PlayerID = PlayerID;
        this.TeamID = TeamID;
        this.Inning = Inning;
        this.Outby = Outby;
        this.OutType = OutType;
        this.runedScored = runedScored;
        this.RunsConceed = RunsConceed;
        this.Nowide = Nowide;
        this.NOBalls = NOBalls;
        this.OverBlowed = OverBlowed;
    }

    public String getMatchID() {
        return MatchID;
    }

    public void setMatchID(String MatchID) {
        this.MatchID = MatchID;
    }

    public String getPlayerID() {
        return PlayerID;
    }

    public void setPlayerID(String PlayerID) {
        this.PlayerID = PlayerID;
    }

    public String getTeamID() {
        return TeamID;
    }

    public void setTeamID(String TeamID) {
        this.TeamID = TeamID;
    }

    public String getInning() {
        return Inning;
    }

    public void setInning(String Inning) {
        this.Inning = Inning;
    }

    public String getOutby() {
        return Outby;
    }

    public void setOutby(String Outby) {
        this.Outby = Outby;
    }

    public String getOutType() {
        return OutType;
    }

    public void setOutType(String OutType) {
        this.OutType = OutType;
    }


    public int getRunedScored() {
        return runedScored;
    }

    public void setRunedScored(int runedScored) {
        this.runedScored = runedScored;
    }

    public int getRunsConceed() {
        return RunsConceed;
    }

    public void setRunsConceed(int RunsConceed) {
        this.RunsConceed = RunsConceed;
    }

    public int getNowide() {
        return Nowide;
    }

    public void setNowide(int Nowide) {
        this.Nowide = Nowide;
    }

    public int getNOBalls() {
        return NOBalls;
    }

    public void setNOBalls(int NOBalls) {
        this.NOBalls = NOBalls;
    }

    public float getOverBlowed() {
        return OverBlowed;
    }

    public void setOverBlowed(float OverBlowed) {
        this.OverBlowed = OverBlowed;
    }
}
