package com.frank.demo.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@JmsListener(destination = "my-destination") //只需在这个注解的属性destination指定要监听的目的地，即可接收该目的地发送的消息
	public void receiveMessage(String message) {
		System.out.println("接受到: <" + message + ">");
	}

}
