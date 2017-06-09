package com.mypoc.rest;

import org.springframework.beans.factory.annotation.Autowired;


//This class did not work
public class Receiver {
    

    @Autowired
    public Receiver() {
        
    }
    
    //@Autowired 
   	//private ClientRepository clientRepository;

       //public void receiveMessage(MyClient myClient) {
    	   public void receiveMessage(String message) {
           System.out.println("Received  a message asynchronously : message = " +  message);
           
           //System.out.println("myClient.getAddress()= " + myClient.getAddress());
            
           
           //MyClient myClient = new MyClient();
           
           //clientRepository.save(myClient);
       }
}
