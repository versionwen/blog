package com.version.dao;

import com.version.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author version
 * @version 1.0
 * @date 2020/3/25 15:40
 */
public interface UserRepository extends JpaRepository<User,Long> {
   User findByUsernameAndPassword(String username,String password);
}
