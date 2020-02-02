/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statedesign;

import java.util.*; 
/**
 *OVERVIEW; 
 * @author Abdi
 */
public class Manager extends User {
  
    private BankAccount bank ;
    public static Manager instance;
 
    private ArrayList<Account> accounts;
    private ArrayList<Customer> customers;
   
   
    private Manager (BankAccount bank, ArrayList<Account> acc ,ArrayList<Customer> cust ){ // generic manager
      
      super("Abdifatah", "Manager", "admin", "admin");
      this.bank = bank ;
      this.accounts = acc ;
      this.customers = cust ;
      this.addUser(this); 
    }
   
    public void logoutALLcustomers(){
    for(int k = 0; k <customers.size(); k++) {
        customers.get(k).logout();}}
    
    public static Manager getInstance(BankAccount bank, ArrayList<Account> acc ,ArrayList<Customer> cust){  //Singleton Pattern    
        if( instance == null )
            instance = new Manager(bank, acc, cust);
        return instance;
    }
   
   
    protected String addCustomer(String n ,String us ,String pa) { //String
        //usernames must be unique
        for( int i = 0; i < ( this.accounts.size() ); i++ ){
        if( ( this.accounts.get(i).checkUsername(us ) ) ){
            System.out.println("username  already in use ");
            return("username  in use, ");
        }
        }
        if( ( us.equals("admin") || ( pa.equals("admin") ) ) ){ 
            return("invalid, you're not the manager");
        }
        if(  us.equals("") || ( pa.equals("") ) || ( n.equals("") )  ){ // information cant be empty
            return("invalid ");
        }
       
        Customer newest = new Customer(n ,"customer" ,us ,pa);
        Account aa = new Account(newest);
        this.accounts.add(aa);
        this.customers.add(newest);
     
        return("Account created");
    }

    protected String removeCustomer( String username, String password ){
        for( int i = 0; i < ( this.accounts.size() ); i++ ){
        if( ( this.accounts.get(i).checkLogin(username, password) ) == true  ){
            this.accounts.remove(i);
        }}
            for( int j = 0; j < ( this.customers.size() ); j++ ){
            if( ( this.customers.get(j).checkLogin(username, password) )  == true  ){
                this.customers.remove(j);// remove from this array
                return("Removed") ;
            }
        }
          return("Error : username do not match") ;
        }
   
    protected Account getAccount(String username, String password){ // check
        for( int i = 0; i < ( this.accounts.size() ); i++ ){
        if( ( this.accounts.get(i).checkLogin(username, password) )  ){
            return ( this.accounts.get(i) ) ;
        }
        }
          return null ;  
         
    }

}






 