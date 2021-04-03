package com.zdh.dao.impl;

import com.zdh.dao.UserDao;
import com.zdh.pojo.User;
import com.zdh.utils.DBHelper;

import java.util.Map;

public class UserDaoImpl implements UserDao {
    private DBHelper db = new DBHelper();
    @Override
    public User queryUserByUserName(String name) {
        String sql = "select id,username,password,email from t_user where username=?";
        return (User) db.find(sql,name);
    }

    @Override
    public User queryUserByUserNameAndPwd(String name, String pwd) {
        String sql = "select id,username,password,email from t_user where username=? and password=?";
        Map<String, Object> map = db.find(sql, name, pwd);

        User user = new User();
        user.setUsername((String) map.get("username"));
        user.setPassword((String) map.get("password"));

        return  user;
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user values(0,?,?,?)";
        return db.update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
