package com.shrikant.example.tinderSwipeCard.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shrikant.example.tinderSwipeCard.model.User;

public interface UserRepository extends CrudRepository <User,Integer>{
	
	//public User findByUsernamePassword(String username,String password);
}
