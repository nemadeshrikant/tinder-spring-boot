package com.shrikant.example.tinderSwipeCard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shrikant.example.tinderSwipeCard.model.User;
import com.shrikant.example.tinderSwipeCard.repo.UserRepository;

@Service
public class UserService {
@Autowired
UserRepository userRepository; 


/*public User findByUsernamePassword(String username,String password){
	return userRepository.findByUsernamePassword(username, password);
}
	*/

public void saveOrUpdate(User user){
	userRepository.save(user);
}
	
}
