/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statedesign;
import java.util.*; 
/**
 *OVERVIEW; BnankAccount class, verifies user login and sets Arrays 
 * @author Abdi
 */
public class BankAccount  {
    private Manager superman;
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    
    
    public BankAccount() {
        superman = superman.getInstance(this, accounts, customers);
    }
    
    protected Account getAccount(String name, String password){
    for(int k =0; k< accounts.size(); k++) {
        if ((accounts.get(k).checkLogin(name, password))){
            return accounts.get(k);}}
    
    return null; 
           
}
    
    protected Manager getManager (String username, String password){
        if(this.superman.checkLogin(username, password)){
            return (this.superman); 
    }
        return null; }
    
    protected Customer getCustomer(String username, String password){
        for(int a =0; a< customers.size(); a++){
            if(customers.get(a).checkLogin(username, password)){
                return customers.get(a);
        }
    }return null; 
    }
    protected Manager getSuperman(){
        return this.superman;
    }
}
