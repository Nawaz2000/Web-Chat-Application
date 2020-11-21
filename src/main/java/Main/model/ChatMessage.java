package Main.model;

public class ChatMessage {
	private String username;
	private String messagetext;
	private String messageid;

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getMessageText() {
		return messagetext;
	}

	public void setMessageText(String messagetext) {
		this.messagetext = messagetext;
	}

	public String getMessageid() {
		return messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

}
