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
public class Silverlvl extends AccountLevel {
    
    public Silverlvl(){
        super("SILVER");
    }
    
    @Override 
    public AccountLevel checklevel(Account here, double balance){
        if(balance>=20000) {
            return new Platinumlvl(); }
        if(balance>=10000 && balance<20000 ) {
            return new Goldlvl(); }
        return this; 
        }
    
    
    @Override 
    public double Fee(double purch ) {
        double f= purch+20;
        return f; 
        
    }
}
    

