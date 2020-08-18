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
public class Category {
    
    private String categoryId;
    private String categoryName;
    private long categoryPrice;
    private String year;

    public Category(String categoryId, String categoryName, long categoryPrice){
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryPrice = categoryPrice;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getCategoryPrice() {
        return categoryPrice;
    }

    public void setCategoryPrice(long categoryPrice) {
        this.categoryPrice = categoryPrice;
    }
    
}
