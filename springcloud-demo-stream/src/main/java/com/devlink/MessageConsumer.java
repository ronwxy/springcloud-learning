package com.devlink;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class MessageConsumer {

    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        System.out.println("receive: " + payload);
    }
}
