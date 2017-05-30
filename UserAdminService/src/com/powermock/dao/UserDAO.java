package com.powermock.dao;

import com.powermock.dto.User;
import com.powermock.util.IdGenerator;

public class UserDAO {

	public int create(User user) {
		user.setId(IdGenerator.generateId());
		return user.getId();
	}
}
