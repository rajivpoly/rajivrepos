package com.mypoc;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public interface MyCustDAO {
	
	//
	
	MyClient getMyClient(String id);

	MyClient addMyClient(MyClient MyClient);

	MyClient updateMyClient(MyClient MyClient);

	boolean deleteMyClient(String id);

	Collection<MyClient> listMyClients();
	
	

}
