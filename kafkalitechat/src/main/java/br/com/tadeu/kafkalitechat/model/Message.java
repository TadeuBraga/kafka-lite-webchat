package br.com.tadeu.kafkalitechat.model;

import java.util.Calendar;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Message {
	private String username;
	private String content;
	private Calendar time;
}
