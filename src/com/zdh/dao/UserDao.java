package com.zdh.dao;

import com.zdh.pojo.User;

public interface UserDao {
    //根据名字查用户
    public User queryUserByUserName(String name);
    public User queryUserByUserNameAndPwd(String name,String pwd);
    public int saveUser(User user);

}
