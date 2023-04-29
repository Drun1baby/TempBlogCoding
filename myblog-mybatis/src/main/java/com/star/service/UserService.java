package com.star.service;

import com.star.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 用户业务层接口
 * @Date: Created in 22:56 2020/5/26
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public interface UserService {
    //核对用户名和密码
    User checkUser(String username, String password);

    User checkType(String username);

    @Transactional
    int saveUser(User user);

    @Transactional
    List<User> getAllUser();

    @Transactional
    User getUser(Long id);

    User getUserByName(String name);

    @Transactional
    int updateUser(User user);

    @Transactional
    void deleteUser(Long id);
}