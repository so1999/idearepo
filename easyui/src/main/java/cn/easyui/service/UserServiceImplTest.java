package cn.easyui.service;

import cn.easyui.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created by Sun on 2015/11/3.
 */
//�鶯Spring����
@ContextConfiguration(locations={"/applicationContext.xml"})
public class UserServiceImplTest extends AbstractTestNGSpringContextTests{
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void hasMatchUser(){
        boolean b1= userServiceImpl.hasMatchUser("admin","123456");
        boolean b2= userServiceImpl.hasMatchUser("admin","111111");
        assertTrue(b1);
        //assertTrue(b2);
    }

    @Test
    public void findUserByUserName(){
        User user= userServiceImpl.findUserByUserName("admin");
        assertEquals(user.getUserName(),"admin");
    }
}
