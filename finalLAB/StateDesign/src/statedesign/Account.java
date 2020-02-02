/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statedesign;
import java.io.*; 
import java.util.*; 
/**
 *
 * @author Abdi
 */
public class Account {
   
    
    private Customer cust ;
    private double balance;
    private AccountLevel level; 
    
    
    public Account(Customer c){
        cust=c; 
        balance = 100;
        level = new Silverlvl(); 
        
    }
    
   protected Customer getCustomer() {
   return cust;}
    

    public boolean checkPurchase(double purchase) {
    
        if (purchase<50) { return (true); }
        else{ return false; }
}
    
    public String deposit(double cash) {
        if (cash>0){
            balance+=cash; 
            this.checklevel();
            return"deposit successful";
        }else{return"deposit failed";
        }
    }
    
    public double withdraw(double cash) {
        if (cash> balance){
            System.out.println("Cant withdraw, withdrawal>balance");
            return 0;
        }
        else { 
            balance-= cash; 
            this.checklevel();
            return cash; 
        }
    }
    public void checklevel() {
        this.level = this.level.checklevel(this, balance); 
    }
    
    
    public boolean checkLogin (String username, String password){
        if ((this.cust.getusername().equals(username))&& this.cust.getPassword().equals(password)) {
            return (true);}
            else { return false; }
            
    
    }
    public boolean checkUsername (String usern){
        if(this.cust.getusername().equals(usern)) {
            return (true); }
        else { return false; }
        }
    
    public String getBalance(){
        return " "+balance; }
    
    protected String getLevel() {
    return level.getLevel(); }
    
    
    public String doOnlinePurchase (double purchase){
        double var; 
        if ( this.checkPurchase(purchase)==true){
            return("purchase price beleow 50");
        }
        var = level.Fee(purchase);
        var = this.withdraw(var);
        
        if ( var ==0) {
            return "purchase not possible"; 
        }
        
        this.checklevel();
        return "purchase has been made"; 
    
}}

    

