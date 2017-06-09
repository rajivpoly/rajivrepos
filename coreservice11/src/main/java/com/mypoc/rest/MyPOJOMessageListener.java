package com.mypoc.rest;

import org.springframework.beans.factory.annotation.Autowired;

//This seems to have worked.
public class MyPOJOMessageListener {
	
	@Autowired 
   	private ClientRepository clientRepository;
	
    public MyPOJOMessageListener() {
		super();
		// TODO Auto-generated constructor stub
	}

	//public void handleMessage(byte[] data, String channel) {
	public void handleMessage(MyClient myClient, String channel) {
        System.out.println("In handleMessage(): " + channel);
        
        System.out.println("In handleMessage(): myClient.getAddress()=" + myClient.getAddress());
        
        clientRepository.save(myClient);
    }
}