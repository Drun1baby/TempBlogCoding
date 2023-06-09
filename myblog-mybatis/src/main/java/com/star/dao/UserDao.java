package com.star.dao;

import com.star.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 用户持久层接口
 * @Date: Created in 0:06 2020/5/27
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Mapper
@Repository
public interface UserDao {
    /**
     * @Description:
     * @Auther: ONESTAR
     * @Date: 10:24 2020/5/27
     * @Param: username:用户名；password:密码
     * @Return: 返回用户对象
     */
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    User findTypeByUsername(@Param("username") String username);

    List<User> getAllUser();
    //新增保存用户
    int saveUser(User user);

    //根据id查询用户
    User getUser(Long id);


    //根据用户名称查询用户
    User getUserByName(String name);

    //编辑修改用户
    int updateUser(User user);

    //删除用户
    void deleteUser(Long id);
}