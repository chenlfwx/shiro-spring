package com.chen.service;

import com.chen.dao.UserDao;
import com.chen.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Chen Dian
 * @date 2019/06/13
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getByName(String username){
        return userDao.getByUserName(username);
    }
}
