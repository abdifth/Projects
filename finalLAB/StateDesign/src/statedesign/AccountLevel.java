/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statedesign;

/**
 *
 * @author Abdi
 */
public abstract class AccountLevel {
    private String level;
    /**
    *
    * @param level
    */
    public AccountLevel(String level){
        this.level = level; 
    }
    /**
    *
    * @return level
    */
    public String getLevel() {
    return level;}
    /**
     * 
     * @param acc
     * @param price
     * @return 
     */
    public abstract AccountLevel checklevel(Account acc, double price);
    
    public abstract double Fee(double fee);
}
