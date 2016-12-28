package org.sa.auth.services;

import org.sa.auth.entity.User;
import org.sa.auth.repository.UserRepository;
import org.sa.auth.services.InvalidUserException;
import org.sa.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Mock implementation.
 * 
 * Aug 4, 2016
 */
@Service
public class DatabaseUserService extends UserService {
    private final UserRepository userRepository;
    
    @Autowired
    public DatabaseUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public UserRepository getUserRepository() {
        return userRepository;
    }

    public User getByUsername(String username) {
        List<User> userList= this.userRepository.findByUsername(username);
        if(userList==null || userList.isEmpty()){
            throw new InvalidUserException("No user found");
        }
        if(userList.size()>1){
            throw new InvalidUserException("Too many users found");
        }
        return userList.get(0);
    }
}
