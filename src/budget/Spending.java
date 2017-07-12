/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budget;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Максим
 */
public class Spending {
    private int spend_id;
    private String spend_name;
    private Double spend_sum;
    private String spend_cat;
    private java.sql.Date spend_date;
    private String spend_addinfo;
    private String spend_where;
    public Spending(String spend_name, Double spend_sum, String spend_cat, java.sql.Date spend_date, 
            String spend_addinfo, String spend_where){
    this.spend_name = spend_name;
    this.spend_sum = spend_sum;
    this.spend_cat = spend_cat;
    this.spend_date = spend_date;
    this.spend_addinfo = spend_addinfo;
    this.spend_where = spend_where; 
    }
    
    public Spending(){
        Date today = new Date(System.currentTimeMillis());
    this.spend_name = "";
    this.spend_sum = 0.0;
    this.spend_cat = "";
    this.spend_date = today;
    this.spend_addinfo = "";
    this.spend_where = "";
    }
    
    public Spending(String spend_name, Double spend_sum, String spend_cat,
            String spend_addinfo, String spend_where){
        Date today = new Date(System.currentTimeMillis());
    this.spend_name = spend_name;
    this.spend_sum = spend_sum;
    this.spend_cat = spend_cat;
    this.spend_date = today;
    this.spend_addinfo = spend_addinfo;
    this.spend_where = spend_where; 
    }
    public Spending(String spend_name, Double spend_sum){
        Date today = new Date(System.currentTimeMillis());
    this.spend_name = spend_name;
    this.spend_sum = spend_sum;
    this.spend_cat = "no info";
    this.spend_date = today;
    this.spend_addinfo = "no info";
    this.spend_where = "no info"; 
    }

    /**
     * @return the spend_name
     */
    public String getSpend_name() {
        return spend_name;
    }

    /**
     * @param spend_name the spend_name to set
     */
    public void setSpend_name(String spend_name) {
        this.spend_name = spend_name;
    }

    /**
     * @return the spend_sum
     */
    public Double getSpend_sum() {
        return spend_sum;
    }

    /**
     * @param spend_sum the spend_sum to set
     */
    public void setSpend_sum(Double spend_sum) {
        this.spend_sum = spend_sum;
    }

    /**
     * @return the spend_cat
     */
    public String getSpend_cat() {
        return spend_cat;
    }

    /**
     * @param spend_cat the spend_cat to set
     */
    public void setSpend_cat(String spend_cat) {
        this.spend_cat = spend_cat;
    }

    /**
     * @return the spend_date
     */
    public java.sql.Date getSpend_date() {
        return spend_date;
    }

    /**
     * @param spend_date the spend_date to set
     */
    public void setSpend_date(java.sql.Date spend_date) {
        this.spend_date = spend_date;
    }

    /**
     * @return the spend_addinfo
     */
    public String getSpend_addinfo() {
        return spend_addinfo;
    }

    /**
     * @param spend_addinfo the spend_addinfo to set
     */
    public void setSpend_addinfo(String spend_addinfo) {
        this.spend_addinfo = spend_addinfo;
    }

    /**
     * @return the spend_where
     */
    public String getSpend_where() {
        return spend_where;
    }

    /**
     * @param spend_where the spend_where to set
     */
    public void setSpend_where(String spend_where) {
        this.spend_where = spend_where;
    }

        
}
