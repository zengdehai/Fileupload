package com.zdh.service.impl;

import com.zdh.dao.UserDao;
import com.zdh.dao.impl.UserDaoImpl;
import com.zdh.pojo.User;
import com.zdh.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        dao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return dao.queryUserByUserNameAndPwd(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String name) {
        if (dao.queryUserByUserName(name) == null){
            return false;
        }
        return true;
    }
}
