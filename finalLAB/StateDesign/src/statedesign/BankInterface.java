/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statedesign;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

     import javafx.scene.layout.StackPane;

import javafx.application.Application;

import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

/**
 *
 * @author Abdi
 */
public class BankInterface extends Application {
    //inst variables
  
    private final StackPane root = new StackPane(); 
    private Scene scene1;
    private final BankAccount bacc = new BankAccount();
    private final Manager superman = bacc.getSuperman(); 
    private String usernameClient = new String();
    private String passwordClient = new String();
    private Customer CustUser;
    private Manager ManUser; 
    
    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button(); //button for userlogin scece
        Label labelbtn =new Label("");
        btn1.setText("Login");
        scene1 = new Scene(root, 450, 250);
        TextField box1 = new TextField();
        TextField box2 = new TextField(); 
        
        box1.setText("Label");
        box1.clear();
        box2.setText("Label");
        box2.clear();
        ///
        GridPane gridPane = new GridPane();
        gridPane.setHgap(2);
        gridPane.setVgap(2);
        gridPane.setPadding(new Insets(5,5,5,5));
        gridPane.add(new Label("Username "), 0, 0);
        gridPane.add(new Label("Password "), 0, 5);
        gridPane.add(box1, 1, 0);
        gridPane.add(box2, 1, 5);//
        gridPane.add(btn1, 2, 5);
        gridPane.add(labelbtn, 3, 30);
        root.getChildren().add(gridPane);
        
        primaryStage.setTitle("Account Login");
        primaryStage.setScene(scene1);
        primaryStage.show(); //display
        
        //when button is clicked
        
        btn1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            
                boolean b = false;
                CustUser = null;
                ManUser = null; 
              
                usernameClient = box1.getText();
                passwordClient = box2.getText();
                labelbtn.setText("" ); 
                
                
                CustUser = bacc.getCustomer(usernameClient, passwordClient);
                ManUser = bacc.getManager(usernameClient, passwordClient);
                
                try { 
                    if (ManUser.NullCheck()) {
                        b = true;
                    }
                    ManUserScene(ManUser);
                    labelbtn.setText("Successful Login");
                }
                catch (NullPointerException e){ }
                
               finally { if (b==false) {
                   try{ if (CustUser.logged==false){
                       CustUserScene(CustUser);
                       CustUser.login();
                       labelbtn.setText("Login Successful");
                       
                   }
                }
            catch (NullPointerException e) {
                if (b == false) { 
                    labelbtn.setText("username or password incorrect");
                
                }
            }
               }
               
              
        }
            }});
    }
    
    public void ManUserScene(Manager Man) {
        Stage ManStage = new Stage();
        ManStage.setTitle("Manager");
        Button addCustomer = new Button();
        Button deleteCustomer = new Button();
        Button logout = new Button();
        Button logoutALLCusts = new Button();
        Label mod = new Label("");
        addCustomer.setText("Add a new Customer");
        deleteCustomer.setText("Delete Customer");
        logout.setText("LOGOUT");
        logoutALLCusts.setText("LOGOUT ALL CUSTOMERS");
        
        TextField name = new TextField ();
        TextField username = new TextField();
        TextField password = new TextField();
        TextField DELETEusername = new TextField();
        TextField DELETEpassword = new TextField();
        
        name.clear();
        username.clear();
        password.clear();
        DELETEusername.clear();
        DELETEpassword.clear();
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(2);
        gridPane.setVgap(2);
        gridPane.setPadding(new Insets(5,5,5,5));
        gridPane.add(new Label("Name"), 0, 0);
        gridPane.add(new Label("Username"), 0, 5);
        gridPane.add(new Label("Password"), 0, 10);
        gridPane.add(new Label("Username"), 3, 5); //deletos
        gridPane.add(new Label("Password"), 3, 10); 
                
        gridPane.add(name, 1, 0);
        gridPane.add(username, 1, 5);//
        gridPane.add(password, 1, 10);
        gridPane.add(DELETEusername, 4, 5);
        gridPane.add(DELETEpassword, 4, 10);
        gridPane.add(addCustomer, 0, 30);
        gridPane.add(deleteCustomer, 3, 30);
        gridPane.add(mod, 1, 30);
        gridPane.add(logout, 3, 25);
        gridPane.add(logoutALLCusts, 4, 25);
        
        StackPane rootMan = new StackPane();
        rootMan.getChildren().add(gridPane);
        Scene ManScene = new Scene(rootMan, 600, 200); 
        
        ManStage.setTitle("Manager");
        ManStage.setScene(ManScene);
        
        ManStage.show();
        
        //manager buttons
        addCustomer.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                mod.setText(Man.addCustomer(name.getText(), username.getText(), password.getText()));
            }
        
                });
        deleteCustomer.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                mod.setText(Man.removeCustomer(username.getText(), password.getText()));
            }
        
                });
        
        logout.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Man.logout();
                ManStage.close();
            }
        
                });
        
        logoutALLCusts.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                superman.logoutALLcustomers();
            }
        
                });
        
        //end of manager button hadnling 
       
    /**
     *
     * @param Cust
     */
    }public void CustUserScene(Customer Cust) {
        Stage CustStage = new Stage();
        CustStage.setTitle("Customer");    
        
        Label mod = new Label("");
        Label username = new Label("Hi"+ Cust.getusername());
        Label balance = new Label ("Account balance is : "+ superman.getAccount(Cust.getusername(), Cust.getPassword()).getBalance());
        Label level = new Label (" Account level is "+ superman.getAccount(Cust.getusername(), Cust.getPassword()).getLevel());
        Label shopcart = new Label("Amount in shopping cart is: "+ Cust.getshopcart());
        Label addtoCart = new Label("Add to cart  ");
        Label deposit = new Label(" Deposit cash here ");
        
        Button depositBtn = new Button();
        depositBtn.setText("Deposit"); 
        Button PurchaseBtn = new Button();
        PurchaseBtn.setText("Purchase"); 
        Button CartBtn = new Button();
        CartBtn.setText("Add to Cart"); 
        Button ClearCartBtn = new Button();
        ClearCartBtn.setText("Clear Cart"); 
        Button LogoutBtn = new Button(); 
        LogoutBtn.setText("Logout"); 
        
        TextField addCart = new TextField();
        TextField addDeposit = new TextField();
        
        addCart.clear();
        addDeposit.clear();
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(2);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(5,5,5,5));
        gridPane.add(username, 0, 0);
        gridPane.add(balance, 0, 5);
        gridPane.add(level, 0, 10); //deletos
        gridPane.add(shopcart, 0, 15); 
        gridPane.add(addtoCart, 0, 20);
        gridPane.add(deposit, 0, 25); 
        
        gridPane.add(depositBtn, 1, 25);
        gridPane.add(addCart, 1, 20);
        gridPane.add(addDeposit, 3, 25);
        gridPane.add(PurchaseBtn, 4, 30); //deletos
        gridPane.add(CartBtn, 3, 20); 
        gridPane.add(ClearCartBtn, 4, 20);
        gridPane.add(LogoutBtn, 0, 35);
        gridPane.add(mod, 1, 30); 
        
        StackPane rootCust = new StackPane();
        rootCust.getChildren().add(gridPane);
        Scene ManScene = new Scene(rootCust, 650, 500); 
        CustStage.setTitle("Customer");
        CustStage.setScene(ManScene);
        CustStage.show();
    
     LogoutBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Cust.logout();
                CustStage.close();
            }
        
                });
        CartBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            try{
                double dd =  Double.parseDouble(addCart.getText());
                Cust.addtoshopcart(dd);
                shopcart.setText("The total price in cart is: "+ Cust.getshopcart());
                mod.setText("total added to basket");
                
            }
            catch (Exception e) { mod.setText("Invalid price in cart");}
                
            }
        
                });
        
         ClearCartBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Cust.emptyshopcart(); 
                shopcart.setText("total in cart is: "+ Cust.getshopcart());
                
            }
        
                });
       
         depositBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               try{
                   double aa = Double.parseDouble(addDeposit.getText());
                mod.setText(superman.getAccount(Cust.getusername(), Cust.getPassword()).deposit(aa));
            balance.setText("Account balance is : "+ superman.getAccount(Cust.getusername(), Cust.getPassword()).getBalance());
               level.setText("Account level is: " + superman.getAccount(Cust.getusername(), Cust.getPassword()).getLevel());
               }
               catch (Exception e){ mod.setText("Invalid value for deposit "); 
               }
            }
                });
            
        PurchaseBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               try{
                   
                mod.setText(superman.getAccount(Cust.getusername(), Cust.getPassword()).doOnlinePurchase(Cust.getshopcart()));
            balance.setText("Account balance is : "+ superman.getAccount(Cust.getusername(), Cust.getPassword()).getBalance());
               level.setText("Account level is: " + superman.getAccount(Cust.getusername(), Cust.getPassword()).getLevel());
               Cust.emptyshopcart(); 
               shopcart.setText("value in cart is: "+ Cust.getshopcart() ); 
               
               }
               catch (Exception e){ mod.setText("Accouny unavailable"); 
               }
            }
                }); 
     
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
        }


                
    

