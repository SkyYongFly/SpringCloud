package com.example.streamhello.receiver;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * RabbitMQ消息接收者 ,@EnableBinding 注解绑定指定的通道，这里使用默认的Sink通道，名称为 input
 *
 * @author zhuyong
 * @version V1.0.0
 * @date 2018/10/9 15:33
 */
@EnableBinding(Sink.class)
public class SinkReceiver {
    /**
     * 监听 input 通道，当有消息发送到该通道中的队列，则接收到消息
     * @param message
     */
    @StreamListener(Sink.INPUT)
    public void receive(Object message){
        System.out.println("接收到消息：" + message);
    }
}
