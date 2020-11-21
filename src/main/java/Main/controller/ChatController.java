package Main.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Main.model.ChatForm;
import Main.services.MessageService;

@Controller
@RequestMapping("/chat")
public class ChatController {
	private MessageService messageService;

	public ChatController(MessageService messageService) {
		this.messageService = messageService;
	}

	@GetMapping
	public String getChatPage(ChatForm chatForm, Model model) {
//		model.addAttribute("chatForm", new ChatForm());
		model.addAttribute("chatHistory", this.messageService.getChat());
		return "chat";
	}

	@PostMapping
	public String addMessage(Authentication authentication, ChatForm chatForm, Model model) {
		chatForm.setUserName(authentication.getName());
		this.messageService.addMessage(chatForm);
		chatForm.setMessageText("");
		model.addAttribute("chatHistory", this.messageService.getChat());
//		model.addAttribute("chatForm", new ChatForm());
		return "chat";
	}

	@ModelAttribute("allMessageTypes")
	public String[] allMessageTypes() {
		return new String[] { "Say", "Shout", "Whisper" };
	}
}
