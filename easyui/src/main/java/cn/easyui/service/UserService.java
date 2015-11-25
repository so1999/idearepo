package cn.easyui.service;

import cn.easyui.domain.User;

import java.util.List;

/**
 * Created by Sun on 2015/11/19.
 */
public interface UserService {

    public abstract User findUserByUserName(String userName);
    public abstract boolean hasMatchUser(String userName,String password);
    public abstract void loginSuccess(User user);



    public abstract User queryUserById(int id);

    public abstract void insertUser(User user);

    public abstract List<User> selectAllUser();

}
