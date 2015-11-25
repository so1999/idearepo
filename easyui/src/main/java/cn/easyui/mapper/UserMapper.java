package cn.easyui.mapper;

import cn.easyui.domain.User;

import java.util.List;

/**
 * Created by Sun on 2015/11/18.
 */
public interface UserMapper {

    public abstract User findUserById(int id);

    public abstract void insertUser(User user);

    public abstract List<User> selectAllUser();
}
