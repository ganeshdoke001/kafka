package com.codeq.producer.service;

import com.codeq.producer.handler.WikiMediaHandler;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.StreamException;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class WikiMediaProducer {

    public static final Logger LOGGER= LoggerFactory.getLogger(WikiMediaProducer.class);

    private final KafkaTemplate<String,String> kafkaTemplate;

    public WikiMediaProducer(final KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }

    @SneakyThrows
    public void sendMessage() throws  InterruptedException,StreamException {
        String topic="wikimedia_recentChange";

        //To read real time sreamt data in wikimedia
       // WikiMediaHandler eventHandler=new WikiMediaHandler(kafkaTemplate,);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource eventSource = new EventSource.Builder(URI.create(url))
                .build();

        eventSource.start();
        TimeUnit.MINUTES.sleep(10);

    }
}
