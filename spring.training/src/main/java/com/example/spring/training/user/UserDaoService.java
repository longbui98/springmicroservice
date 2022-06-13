package com.example.spring.training.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int userCount = 3;

	static {
		users.add(new User(1, "Java", new Date(),
				Arrays.asList("New Post On Facebook"
						, "New Post On Instagram"
						, "New Post On Twitter")));
		users.add(new User(2, "C++", new Date(),
				Arrays.asList("New Post On Facebook2"
						, "New Post On Instagram2"
						, "New Post On Twitter")));

		users.add(new User(3, "Python", new Date(),
				Arrays.asList("New Post On Facebook3"
						, "New Post On Instagram3"
						, "New Post On Twitter3")));
	}

	public List<User> findAll() {
		return users;
	}

	public User findById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User save(User user) {
		if (findById(user.getId()) == null) {
			users.add(user);
			return user;
		}
		return null;
	}

	public List<User> delete(int id) {
		if (findById(id) == null) {
			return null;
		}
		for (User user : users) {
			if (user.getId() == id) {
				users.remove(user);
			}
		}
		return users;
	}
	
	public List<String> getPostById(int id){
		for(User user : users) {
			if(user.getId() == id) {
				return user.getPost();
			}
		}
		return null;
	}
	
	public User savePost(User user){
		if(findById(user.getId()) == null) {
			users.add(user);
			return user;
		}
		for(User getUserPost : users) {
			if(getUserPost.getId() == user.getId()) {
				getUserPost.getPost().addAll(user.getPost());
				return getUserPost;
			}
		}
		return null;
	}
	
	public String getPostByPostId(int id, int postId) {
		for(User user : users) {
			if(user.getId() == id) {
				if(user.getPost().size() <= postId) {
					return null;
				}else {
					return user.getPost().get(postId);
				}
			}
		}
		return null;
	}
}
