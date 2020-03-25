package com.version.Service;

import com.version.dao.UserRepository;
import com.version.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author version
 * @version 1.0
 * @date 2020/3/25 15:36
 */
@Service
public class userServiceimpl implements UserService{
     @Autowired
     private UserRepository userRepository;
    @Override
    public User checkUser(String username, String password) {
        User user=userRepository.findByUsernameAndPassword(username,password);
        return user;
    }
}
