package org.sa.auth.services;

import org.sa.auth.entity.User;
import org.sa.auth.model.UserModel;
import org.sa.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vivek on 12/21/2016.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel getByUsername(String username,String password){
        List<User> users=userRepository.findByUsername(username);
        if(users==null || users.isEmpty()){
            throw new InvalidUserException("No user found");
        }
        if(users.size()>1){
            throw new InvalidUserException("Too many users found");
        }
        if(users.get(0).getPassword().equals(password)){
            return toUserModel(users.get(0));
        }
        throw new InvalidUserException("Password didn't match");
    }

    private UserModel toUserModel(User userEntity) {
        UserModel response = new UserModel();
        response.username = userEntity.getUsername();
        response.password = userEntity.getPassword();

        return response;
    }
}
