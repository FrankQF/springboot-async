# 异步消息 #
异步消息主要目的是为了系统与系统之间通信，发布者无须等待消费者接收的处理及返回，甚至无需关心消息是否发送成功。  
异步消息有两个很重要的概念，即消息代理和目的地，当消息发送者发送消息后，消息由消息代理接管，消息代理保证消息传递到指定的目的地。  
异步消息主要有两种形式的目的：队列和主题；队列用于点对点的消息 通讯，注意用于发布/订阅式的消息通信

## 点对点式 ##
当消息发送者发送消息，消息代理活的消息后将消息放到一个队列里，当有消息接收者接收消息的时候，消息从队列里取出传递个接收者，这时候队列里就没有了这条消息，  
点对点确保的是每一条消息只有唯一的发送者和接收者，但不确保只有一个发送者或者接收者

##发布/订阅式##
发布/订阅式是消息发送者发送消息到主题，二多个消息接收者监听这个主题

##消息代理实现##
JMS是基于JVM消息代理的规范，而ActiveMQ、HornetQ是一个JMS消息代理的实现。
AMPQ也是一个消息代理的规范，不仅兼容JMS，还支持跨语言和平台，AMPQ主要实现有RabbitMQ


##消息定义##
定义jms发送的消息需实现MessageCreator接口，并重写createMessage方法

## 消息发送及目的地定义 ##
使用jmsTemplate.send("my-destination",new Msg())  
通过JmsTemplate的send方法向目的地发送Msg消息，这里也定于在消息代理上定义了一个目的地叫my-destination  
###接收消息###
	@JmsListener(destination = "my-destination") //只需在这个注解的属性destination指定要监听的目的地，即可接收该目的地发送的消息
	public void receiveMessage(String message) {
		System.out.println("接受到: <" + message + ">");
	}
	
	