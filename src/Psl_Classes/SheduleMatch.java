/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Psl_Classes;

import java.util.Date;

/**
 *
 * @author hp
 */
public class SheduleMatch {
    private String MatchId;
    private  Date date;
    private String time;
    private String matchOfficialId;
    private String teamWonId;
    private String StadiumId;
    private String matchType;
    private String tossWonTeam;
    private String VictoryMargin;
    private String teamAId;
    private String teamBId;
     private String seasonId;
     private String matchName;

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public SheduleMatch(String MatchId, String teamAId, String teamBId, String seasonId) {
        this.MatchId = MatchId;
        this.teamAId = teamAId;
        this.teamBId = teamBId;
        this.seasonId = seasonId;
    }
    public SheduleMatch(String seasonId,String MatchId,Date date,String time,String matchtype,String teamAId,String teamBId){
        this.seasonId=seasonId;
        this.MatchId=MatchId;
        this.date=date;
        this.time=time;
        this.matchType=matchtype;
        this.teamAId=teamAId;
        this.teamBId=teamBId;
    }

    @Override
    public String toString() {
        return "SheduleMatch{" + "MatchId=" + MatchId + ", date=" + date + ", time=" + time + ", matchType=" + matchType + ", teamAId=" + teamAId + ", teamBId=" + teamBId + ", seasonId=" + seasonId + '}';
    }
    public String getTeamAId() {
        return teamAId;
    }

    public void setTeamAId(String teamAId) {
        this.teamAId = teamAId;
    }

    public String getTeamBId() {
        return teamBId;
    }

    public void setTeamBId(String teamBId) {
        this.teamBId = teamBId;
    }

    public String getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(String seasonId) {
        this.seasonId = seasonId;
    }

    public SheduleMatch(String teamAId, String teamBId, String seasonId) {
        this.teamAId = teamAId;
        this.teamBId = teamBId;
        this.seasonId = seasonId;
    }
   
    
    
    public SheduleMatch(){
    }
    public String getMatchId(){
        return MatchId;
    }
    public void setMatchId(String MatchId) {
        this.MatchId = MatchId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMatchOfficialId() {
        return matchOfficialId;
    }

    public void setMatchOfficialId(String matchOfficialId) {
        this.matchOfficialId = matchOfficialId;
    }

    public String getTeamWonId() {
        return teamWonId;
    }

    public void setTeamWonId(String teamWonId) {
        this.teamWonId = teamWonId;
    }

    public String getStadiumId() {
        return StadiumId;
    }

    public void setStadiumId(String StadiumId) {
        this.StadiumId = StadiumId;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getTossWonTeam() {
        return tossWonTeam;
    }

    public void setTossWonTeam(String tossWonTeam) {
        this.tossWonTeam = tossWonTeam;
    }

    public String getVictoryMargin() {
        return VictoryMargin;
    }

    public void setVictoryMargin(String VictoryMargin) {
        this.VictoryMargin = VictoryMargin;
    }
    
}
