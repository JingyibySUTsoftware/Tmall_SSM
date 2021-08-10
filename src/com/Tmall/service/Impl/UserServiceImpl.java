package com.Tmall.service.Impl;

import com.Tmall.bean.User;
import com.Tmall.mapper.UserMapper;
import com.Tmall.service.UserService;
import com.Tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jingyi
 * @Classname UserServiceImpl
 * @description TODO
 * @date 2021/8/3 10:24
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> list(Page page) {
        return userMapper.list(page);
    }

    @Override
    public int total() {
        return userMapper.total();
    }

    @Override
    public User getUserByid(Integer id) {
        return userMapper.getUserByid(id);
    }


    @Override
    public void updateUserPwd(User user) {
        userMapper.updateUserPwd(user);
    }


    @Override
    public void deleteUserByid(Integer id) {
        userMapper.deleteUserByid(id);
    }

    @Override
    public boolean userNameisExist(String name) {
        if (userMapper.userNameisExist(name)>0){
            return  true;
        }else{
            return false;
        }
    }

    @Override
    public void userAdd(User user) {
        userMapper.userAdd(user);
    }

    @Override
    public String  getUserName(User user) {
        return userMapper.getUserName(user);
    }
}
