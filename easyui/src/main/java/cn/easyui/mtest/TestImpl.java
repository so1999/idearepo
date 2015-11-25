package cn.easyui.mtest;

import cn.common.util.LogUtil;
import cn.easyui.domain.User;
import cn.easyui.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;


/**
 * Created by Sun on 2015/11/18.
 */
public class TestImpl {

    public static void main(String []args) throws IOException {
        Reader reader=Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionFactory.openSession();
        LogUtil.info("加载完成");
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user=userMapper.findUserById(1);
        System.out.println(user);

        session.close();

    }
}
