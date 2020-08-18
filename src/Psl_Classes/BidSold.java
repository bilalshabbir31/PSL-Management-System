/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Psl_Classes;

import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class BidSold {
    private String seasonId;
    private String playerId;
    private String teamId;
    private String Category;
    private String seasonName;
    private String teamName;
    private String playerName;
    private String Status;
    private String categoryName;
    
 public BidSold(String seasonId, String playerId, String teamId, String Category) {
        this.seasonId = seasonId;
        this.playerId = playerId;
        this.teamId = teamId;
        this.Category = Category;
    }

    public BidSold(){
    }
 
    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getSeasonName() {
        return seasonName;
    }

    
    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    private static final Logger LOG = Logger.getLogger(BidSold.class.getName());

   
    

    public String getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(String seasonId) {
        this.seasonId = seasonId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

   
    
    
}
