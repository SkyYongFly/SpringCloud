package com.example.streamhello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EnableBinding(value = {StreamHelloApplicationTests.SinkSender.class})
public class StreamHelloApplicationTests {
	@Autowired
	private SinkSender sinkSender;

	@Test
	public void sendMessageToMq(){
		sinkSender.output().send(MessageBuilder.withPayload("I send a message: Hello !").build());
	}

	public interface SinkSender {
		//指定发送消息到 input 通道
		String OUTPUT = "input";

		@Output(SinkSender.OUTPUT)
		MessageChannel output();
	}

}
