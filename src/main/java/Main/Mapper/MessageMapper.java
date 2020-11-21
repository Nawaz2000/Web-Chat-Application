package Main.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import Main.model.ChatMessage;

@Mapper
public interface MessageMapper {
	@Select("SELECT * FROM MESSAGES")
	List<ChatMessage> getChatMessages();

	@Insert("INSERT INTO MESSAGES (username, messagetext) VALUES(#{username}, #{messagetext})")
	@Options(useGeneratedKeys = true, keyProperty = "messageid")
	int insert(ChatMessage chatmessage);
}
