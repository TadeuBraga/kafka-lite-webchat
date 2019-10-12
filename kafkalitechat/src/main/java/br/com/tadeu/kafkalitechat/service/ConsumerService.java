package br.com.tadeu.kafkalitechat.service;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import br.com.tadeu.kafkalitechat.model.Message;


@Service
public class ConsumerService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private SimpMessagingTemplate simpMessagingTemplate;
    
    @Autowired
    public ConsumerService(SimpMessagingTemplate simpMessagingTemplate) {
		super();
		this.simpMessagingTemplate = simpMessagingTemplate;
	}

    @KafkaListener(topics = "messages", groupId = "kafka-lite-chat4")
    public void consume(ConsumerRecord<String, Message> record) throws IOException {
    	simpMessagingTemplate.convertAndSend("/chat", record.value());
        logger.info(String.format("#### -> Consumed message -> %s", record));
    }
}