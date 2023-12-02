package com.contact.manager.services;

import com.contact.manager.Model.UserModel;
import com.contact.manager.entities.User;

public interface UserService {

    User createUser(UserModel user);
}
