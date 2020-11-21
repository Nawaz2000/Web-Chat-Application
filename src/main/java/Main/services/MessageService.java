package Main.services;

import Main.Mapper.*;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import Main.model.ChatForm;
import Main.model.ChatMessage;

@Service
public class MessageService {

	@Resource
	private MessageMapper messageMapper;
//	private List<ChatMessage> chat;

	public void addMessage(ChatForm chatForm) {
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setUserName(chatForm.getUserName());

		switch (chatForm.getMessageType()) {
		case "Say":
			chatMessage.setMessageText(chatForm.getMessageText());
			break;
		case "Shout":
			chatMessage.setMessageText(chatForm.getMessageText().toUpperCase());
			break;
		case "Whisper":
			chatMessage.setMessageText(chatForm.getMessageText().toLowerCase());
			break;
		}
//		this.chat.add(chatMessage);
		messageMapper.insert(chatMessage);
	}

	public List<ChatMessage> getChat() {
		return messageMapper.getChatMessages();
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Creating MessageService bean");
//		this.chat = new ArrayList<>();
	}
}
