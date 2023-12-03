package com.contact.manager.services;

import com.contact.manager.CustomException.ResourceNotFoundException;
import com.contact.manager.Model.UserModel;
import com.contact.manager.dao.UserRepository;
import com.contact.manager.entities.Expense;
import com.contact.manager.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User createUser(UserModel userModel) {
       User user= new User();
        Expense ex=new Expense();
        user.setExpenseList(new ArrayList<Expense>());
        BeanUtils.copyProperties(userModel,user);
        return userRepository.save(user);
    }

    public User getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new ResourceNotFoundException("User not found with id "+ id);
    }

    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
//        List<UserModel> modifiedUsersList = new ArrayList<>();
//
//        for(User user:users){
//            UserModel userModel = new UserModel();
//            BeanUtils.copyProperties(user,userModel);
//            modifiedUsersList.add(userModel);
//        }
        return users;
    }

}
