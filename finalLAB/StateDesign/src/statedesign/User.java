/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statedesign;
 
import java.util.*; 
/**
 *
 * @author Abdi
 */
public abstract class User {
    private String name ;
   private String username ;
    private String password ;
    private String role ;
    boolean logged = false ;
  private ArrayList<User> Users = new ArrayList<User>();
    
   
    public User (String n ,String role ,String us ,String pa) {

        this.name = n ;
        this.role = role ;
        this.username = us ;
        this.password  = pa ;
    }
   /**
    * 
    * @return user
    */
    protected String getusername(){
        String user = this.username;
       return (user) ;
    }
   
   /**
    * 
    * @return pass
    */
    protected String getPassword(){
        String pass = this.password;
       return (pass) ;
    }
   /**
    * EFFECTS: logs user on
    */
    protected void login(){
       this.logged = true;
    }
   /**
    * EFFECTS: checks username and password vs stored values to see if true 
    * @param user
    * @param pass
    * @return 
    */
    public boolean checkLogin(String user ,String pass){
        
      if( ( this.username.equals(user) ) && ( this.password.equals(pass) ) ){
          return (true);
      }
       return (false);
    }
   /**
    * EFFECTS: logs out user
    */
    protected void logout() {
       this.logged = false ;
    }
    /**
     * EFFECTS: check for not null 
     * @return true
     */
    public boolean NullCheck(){
        
        return true; 
    }
    /**
     * 
     * @param use 
     */
    protected void addUser (User use) {
      /**
       * EFFECTS: adds user to the user system 
       */  
        Users.add(use); 
    }
    /**
     * 
     * @param use 
     */
    protected void removeUser(User use) {
        /**
         * EFFECT: removes user from system
         */
        for (int k =0; k< Users.size(); k++){
            if (Users.get(k).checkLogin(use.getusername(), use.getPassword())) {
                Users.remove(k); 
            }
        }
    }
    /**
     * 
     * @return 
     */
    public final boolean repOk() {
        /**
         * //EFFECTS: verifies if Abstraction rep is right  
         */
        for (int k =0; k< Users.size()-1; k++){
            for (int j =(k+1); j< Users.size(); j++ ){
                if (Users.get(k).username.endsWith(Users.get(j).username)){
                    return false; }
                    
    }}
        return true; 
    }
    @Override
    public String toString() {
        /**
         * EFFECTS: returns all User usernames
        */
        
        String str = new String(); 
        for(int a= 0; a< Users.size(); a++) {
            str+= Users.get(a).username; 
    }
        return str; 
    }
   
 }
