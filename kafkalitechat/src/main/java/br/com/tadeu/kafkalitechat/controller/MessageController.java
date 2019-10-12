package br.com.tadeu.kafkalitechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tadeu.kafkalitechat.model.Message;
import br.com.tadeu.kafkalitechat.service.ProducerService;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private ProducerService producerService;


	@PostMapping("/")
	public void send(@RequestBody Message message) {
		producerService.sendMessage(message);
	}
}
