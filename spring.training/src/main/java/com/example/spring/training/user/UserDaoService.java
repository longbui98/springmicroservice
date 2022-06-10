package com.example.spring.training.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int userCount = 3;

	static {
		users.add(new User(1, "Java", new Date()));
		users.add(new User(2, "C++", new Date()));
		users.add(new User(3, "Python", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User findById(int id) {
		if (users.get(id) != null) {
			return users.get(id);
		}
		return null;
	}

	public User save(User user) {
		if (findById(user.getId()) == null) {
			user.setId(++userCount);
			users.add(user);
			return user;
		}
		return null;
	}

	public List<User> delete(int id) {
		if (findById(id) == null) {
			return null;
		}
		users.remove(id);
		return users;
	}

}
