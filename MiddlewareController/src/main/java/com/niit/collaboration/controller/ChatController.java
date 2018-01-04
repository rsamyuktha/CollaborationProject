package com.niit.collaboration.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.collaboration.chat.Message;
import com.niit.collaboration.chat.OutputMessage;

@Controller
@RequestMapping("/")
public class ChatController 
{
	  private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

	  @MessageMapping("/chat")  /*through which path msg can be sent*/
	  @SendTo("/topic/message")  /* where the msg will be passed to*/
	  public OutputMessage sendMessage(Message message)
	  {
		  logger.info("Message sent");
		  return new OutputMessage(message ,new Date());
	  }

}
