package br.com.tadeu.kafkalitechat.serializing;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class KafkaJsonDeserializer implements Deserializer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void configure(Map map, boolean b) {

    }

    @Override
    public Object deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        Object obj = null;
        Class target = null;
        if(s != null && s.equals("messages")) {
        	try {
				target = Class.forName("br.com.tadeu.kafkalitechat.model.Message");
			} catch (ClassNotFoundException e) {
				target = Object.class;
			}
        } else {
        	target = Object.class;
        }
        try {
            obj = mapper.readValue(bytes, target);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return obj;
    }

    @Override
    public void close() {

    }
}