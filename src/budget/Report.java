/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budget;

/**
 *
 * @author Максим
 */
public class Report {
    private java.sql.Date startDate;
    private java.sql.Date endDate;
    
    public Report(){
    java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
    this.startDate = today;
    this.endDate = today;
    }

    /**
     * @return the startDate
     */
    public java.sql.Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(java.sql.Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public java.sql.Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(java.sql.Date endDate) {
        this.endDate = endDate;
    }
}
