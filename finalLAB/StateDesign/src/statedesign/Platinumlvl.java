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
public class Platinumlvl extends AccountLevel {
    
    public Platinumlvl(){
        super("PLATINUM");
    }
    
    @Override 
    public AccountLevel checklevel(Account here, double balance){
        if(balance>=10000 && balance<20000) {
            return new Goldlvl(); }
        if(balance<10000 && balance>=0 ) {
            return new Silverlvl(); }
        return this; 
        }
    
    
    @Override 
    public double Fee(double purch ) {
       double fee =0; 
        return purch; 
        
    }
}

    

