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
public class Customer extends User {
   private double shopcart; 
    public Customer( String n , String rl ,String us ,String pa ) {
        super(n, rl,  us, pa);
        
    }
    protected void addtoshopcart(double price){
        this. shopcart = shopcart+ price; 
    }
    protected double getshopcart(){
    return this.shopcart;}
    
    protected void emptyshopcart(){
    this.shopcart =0;}
}
