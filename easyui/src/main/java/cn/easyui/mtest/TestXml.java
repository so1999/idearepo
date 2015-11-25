package cn.easyui.mtest;

import cn.easyui.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;


/**
 * Created by Sun on 2015/11/18.
 */
public class TestXml {

    public static void main(String []args) throws IOException {

        Reader reader=Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sqlSessionFactory.openSession();
        User user=session.selectOne("cn.easyui.mapper.UserMapper.findUserById",1);
        System.out.println(user);
//
//
//        user.setUserName("me");
//        session.insert("UserMapper.insertUser",user);
//        session.commit();
//
//        session.delete("UserMapper.deleteUser",3);
//        session.commit();
//
//        List<User> users=session.selectList("UserMapper.selectAllUsers");
//        System.out.println(users);
        session.close();

    }
}
