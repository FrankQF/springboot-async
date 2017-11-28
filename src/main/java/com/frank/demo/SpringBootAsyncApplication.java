package com.frank.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

import com.frank.demo.controller.Msg;

@SpringBootApplication
public class SpringBootAsyncApplication implements CommandLineRunner {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAsyncApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		jmsTemplate.send("my-destination",new Msg());//通过JmsTemplate的send方法向目的地发送Msg消息，这里也定于在消息代理上定义了一个目的地叫my-destination
	}
}
