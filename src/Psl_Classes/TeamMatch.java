/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Psl_Classes;

/**
 *
 * @author hp
 */
public class TeamMatch {
    private String teamAId;
    private String teamBId;
    private String seasonid;
    private String MatchID;

    public TeamMatch() {
    }

    public TeamMatch(String teamAId, String teamBId, String seasonid) {
        this.teamAId = teamAId;
        this.teamBId = teamBId;
        this.seasonid = seasonid;
    }
    public TeamMatch(String teamAId, String teamBId, String seasonid,String MatchID) {
        this.teamAId = teamAId;
        this.teamBId = teamBId;
        this.seasonid = seasonid;
        this.MatchID=MatchID;
    }

    public String getMatchID() {
        return MatchID;
    }

    public void setMatchID(String MatchID) {
        this.MatchID = MatchID;
    }

    @Override
    public String toString() {
        return "TeamMatch{" + "teamAId=" + teamAId + ", teamBId=" + teamBId + ", seasonid=" + seasonid + '}';
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

    public String getSeasonid() {
        return seasonid;
    }
    public void setSeasonid(String seasonid) {
        this.seasonid = seasonid;
    }
}
