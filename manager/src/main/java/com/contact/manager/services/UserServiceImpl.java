package com.contact.manager.services;

import com.contact.manager.Model.UserModel;
import com.contact.manager.dao.UserRepository;
import com.contact.manager.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User createUser(UserModel userModel) {
       User user= new User();
        BeanUtils.copyProperties(userModel,user);
        return userRepository.save(user);
    }
}
