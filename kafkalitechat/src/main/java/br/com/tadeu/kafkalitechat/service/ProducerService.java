package br.com.tadeu.kafkalitechat.service;


import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.tadeu.kafkalitechat.model.Message;

@Service
public class ProducerService {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "messages";

    @Autowired
    private KafkaTemplate<String, Message> kafkaUserTemplate;

    public void sendMessage(Message message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        message.setTime(Calendar.getInstance());
        this.kafkaUserTemplate.send(TOPIC, message);
    }
}