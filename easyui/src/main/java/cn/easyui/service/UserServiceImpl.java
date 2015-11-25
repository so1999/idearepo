package cn.easyui.service;

import cn.easyui.dao.LoginLogDao;
import cn.easyui.dao.UserDao;
import cn.easyui.domain.LoginLog;
import cn.easyui.domain.User;
import cn.easyui.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by Sun on 2015/11/3.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String userName, String password) {
        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    public void loginSuccess(User user) {
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        loginLogDao.insertLoginLog(loginLog);
        userDao.updateLoginInfo(user);

    }

    /*
    * Mybatis
    *
    * */

    @Resource
    private UserMapper userMapper;

    public User queryUserById(int id) {
        User user = userMapper.findUserById(id);
        return user;
    }

    public void insertUser(User user) {

        userMapper.insertUser(user);
    }



    public List<User> selectAllUser() {
        List userList=userMapper.selectAllUser();
        return userList;
    }
}
