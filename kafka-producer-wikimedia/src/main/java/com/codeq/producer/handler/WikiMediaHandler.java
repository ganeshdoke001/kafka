package com.codeq.producer.handler;


import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.EventListener;
@Service
public class WikiMediaHandler implements BackgroundEventHandler {

    private static final  Logger LOGGER= LoggerFactory.getLogger(WikiMediaHandler.class);
    private final KafkaTemplate<String,String> kafkaTemplate;
    private  String topic;

    public  WikiMediaHandler(final KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;

    }
    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
    LOGGER.info("event data {}",messageEvent.getData());
    this.kafkaTemplate.send(topic,messageEvent.getData());
    }
    public void send(String topic, String message){
        this.kafkaTemplate.send(topic,message);
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
