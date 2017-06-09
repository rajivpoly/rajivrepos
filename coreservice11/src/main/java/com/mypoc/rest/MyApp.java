package com.mypoc.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@EnableDiscoveryClient
@SpringBootApplication
public class MyApp {
	
	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {

		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, new PatternTopic("updateClient"));

		return container;
	}
	/*
	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
	*/
	
	@Bean
	public MyPOJOMessageListener myPOJOMessageListener() {
	    return new MyPOJOMessageListener();
	}
	
	@Bean
	public RedisSerializer<MyClient> myClientSerializer() {
	    return new Jackson2JsonRedisSerializer(MyClient.class);
	}
	
	
	@Bean
	MessageListenerAdapter listenerAdapter() {
		
		MessageListenerAdapter adapter = new MessageListenerAdapter(myPOJOMessageListener());
	    adapter.setSerializer(myClientSerializer());
		//Jackson2JsonRedisSerializer
	    return adapter;
	}

	@Bean
	Receiver receiver() {
		return new Receiver();
	}

	
	
	 public static void main(String[] args) {
			//.run(MyRestController.class, args);
			SpringApplication.run(MyApp.class, args);
		}
	 
}
