package Main.services;

import Main.Mapper.*;
import Main.model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {

	private final UserMapper userMapper;
	private final HashService hashService;

	public UserService(UserMapper userMapper, HashService hashService) {
		this.userMapper = userMapper;
		this.hashService = hashService;
	}

	public boolean isUsernameAvailable(String username) {
		return userMapper.getUser(username) == null;
	}

	public int createUser(User user) {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		String encodedSalt = Base64.getEncoder().encodeToString(salt);
		String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
		return userMapper.insert(new User(null, user.getUsername(), encodedSalt, hashedPassword, user.getFirstname(),
				user.getLastname()));
	}

	public User getUser(String username) {
		return userMapper.getUser(username);
	}
}
