/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Psl_Classes;

import DatabaseConnectivity.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public class PointsTable {
    
    
    private String teamId;
    private int NumberWins;
    private int NumberLoss;
    private int points;
    private int Drawn;
    private int NoResult;
    float NetRunrate;
    private String SeasonId;
    
  DatabaseConnectivity objConnectivity;
    private Connection connection;
    public PointsTable() {
        objConnectivity=new DatabaseConnectivity();
    }

    public PointsTable(String teamId, String SeasonId) {
        this.teamId = teamId;
        this.SeasonId = SeasonId;
    }

    public PointsTable(String teamId, int NumberWins, int NumberLoss, int points, int Drawn, int NoResult, float NetRunrate, String SeasonId) {
        this.teamId = teamId;
        this.NumberWins = NumberWins;
        this.NumberLoss = NumberLoss;
        this.points = points;
        this.Drawn = Drawn;
        this.NoResult = NoResult;
        this.NetRunrate = NetRunrate;
        this.SeasonId = SeasonId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public int getNumberWins() {
        return NumberWins;
    }

    public void setNumberWins(int NumberWins) {
        this.NumberWins = NumberWins;
    }

    public int getNumberLoss() {
        return NumberLoss;
    }

    public void setNumberLoss(int NumberLoss) {
        this.NumberLoss = NumberLoss;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getDrawn() {
        return Drawn;
    }

    public void setDrawn(int Drawn) {
        this.Drawn = Drawn;
    }

    public int getNoResult() {
        return NoResult;
    }

    public void setNoResult(int NoResult) {
        this.NoResult = NoResult;
    }

    public float getNetRunrate() {
        return NetRunrate;
    }

    public void setNetRunrate(float NetRunrate) {
        this.NetRunrate = NetRunrate;
    }

    public String getSeasonId() {
        return SeasonId;
    }

    public void setSeasonId(String SeasonId) {
        this.SeasonId = SeasonId;
    }

    
        
        
    }
  
  
    
    
    
    
    
