package com.version.Service;

import com.version.po.User;

/**
 * @author version
 * @version 1.0
 * @date 2020/3/25 15:34
 */
public interface UserService {
    public User checkUser(String username,String password);
}
