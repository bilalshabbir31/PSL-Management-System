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
public class Season {
      private String seasonId;
      private String seasonName;
    private String seasonYear;
    
  

    public Season() {
    }

    public Season(String seasonId, String seasonName, String seasonYear) {
        this.seasonId = seasonId;
        this.seasonName = seasonName;
        this.seasonYear = seasonYear;
    }

    public Season(String seasonName, String seasonYear) {
        this.seasonName = seasonName;
        this.seasonYear = seasonYear;
    }
    

   

    public Season(String seasonName) {
        this.seasonName = seasonName;
    }
    

    public String getSeasonYear() {
        return seasonYear;
    }

    public void setSeasonYear(String seasonYear) {
        this.seasonYear = seasonYear;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(String seasonId) {
        this.seasonId = seasonId;
    }

   
}
