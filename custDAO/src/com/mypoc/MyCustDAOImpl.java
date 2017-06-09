package com.mypoc;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MyCustDAOImpl implements MyCustDAO {



	private final static ConcurrentHashMap<String, MyClient> myStore = new ConcurrentHashMap<String, MyClient>();
	
	public MyCustDAOImpl() {
		
		
		super();
		MyClient clt1 = new MyClient("11", "Rajiv", "1111111111", "1 Willowood", "L5R", "1", "111");
		MyClient clt2 = new MyClient("22", "Bet Ming", "2222222222", "330 Front St", "M5V", "2", "222");
		myStore.put(clt1.getId(), clt1);
		myStore.put(clt2.getId(), clt2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public MyClient getMyClient(String id) {
		// TODO Auto-generated method stub
		MyClient myClient = null;
		if (myStore.containsKey(id))
			myClient = myStore.get(id);
		
		return myClient;
	}
	
	@Override
	public MyClient addMyClient(MyClient myClient) {
		// TODO Auto-generated method stub
		
		
		if (myStore.containsKey(myClient.getId()))
			myClient = null;
		else
			myStore.put(myClient.getId(), myClient);
		
		return myClient;
	}

	@Override
	public MyClient updateMyClient(MyClient myClient) {
		
		// TODO Auto-generated method stub
		if (!myStore.containsKey(myClient.getId()))
			myClient = null;
		else
			myStore.replace(myClient.getId(), myClient);

		return myClient;
	}

	@Override
	public boolean deleteMyClient(String id) {
		// TODO Auto-generated method stub
		boolean retVal = true;
		if (myStore.containsKey(id))
			myStore.remove(id);
		else
			retVal = false;

		return retVal;
	}

	@Override
	public Collection<MyClient> listMyClients() {
		// TODO Auto-generated method stub
		
		return myStore.values();
	}



}
