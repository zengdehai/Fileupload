package com.zdh.service;

import com.zdh.pojo.User;

public interface UserService {
    public void registUser(User user);

    public User login(User user);

    public boolean existsUsername(String name);
}
