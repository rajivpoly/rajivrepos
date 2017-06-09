package com.mypoc.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


//@SpringBootApplication
@RestController
//@Controller
@RequestMapping("/clients")
public class MyRestController {
 
	@Autowired 
	private ClientRepository clientRepository;
    
	@Value("${info.foo}")
    private String message;
 
	@RequestMapping(method = RequestMethod.POST)
    public MyClient createMyClient(
    		@RequestBody 
    		MyClient myClient) 
    {
		System.out.println(" In createMyClient: myClient.getName()=" + myClient.getName());
		clientRepository.save(myClient);
        return myClient;
    }

	@RequestMapping(method = RequestMethod.GET)
    public Iterable<MyClient> listMyClients() {
		
		System.out.println(" In listMyClients of core service: pid=" + MySystemUtils.getPID());
		System.out.println(" In listMyClients: message = "  + message);
        return clientRepository.findAll();
    }
	
	
    //@RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MyClient getClient(
    		@PathVariable("id") 
    		Long id) 
    		//throws NotFoundException 
    {
    	System.out.println(" In getClient of core service: id = "  + id + " and pid = " + MySystemUtils.getPID());
    	System.out.println(" In getClient: message = "  + message);
    	MyClient myClient = clientRepository.findOne(id);
 
        if (myClient == null) {
            //throw new NotFoundException();
        }
        return myClient;
    }
 
    
 
    //@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public MyClient updateMyClient(
    		@PathVariable("id") 
    		String id, 
    		@RequestBody 
    		MyClient myClient) 
    		//		throws NotFoundException 
    {
    	System.out.println(" In updateMyClient: id = "  + id);
    	
    	clientRepository.save(myClient);////?????????? No update
        return myClient;
    }
 
 
    //@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteMyClient(
    		@PathVariable("id") 
    		Long id) 
    	{
    	System.out.println(" In deleteMyClient: id = "  + id);
    	clientRepository.delete(id);
    }
 
    
   
    
}