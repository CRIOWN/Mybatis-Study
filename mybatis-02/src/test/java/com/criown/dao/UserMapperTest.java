package com.criown.dao;

import com.criown.pojo.User;
import com.criown.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    //select *
    @Test
    public void test()
    {
        //获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userlist = userMapper.getUserlist();

        for (User user:userlist){
            System.out.println(user);
        }

        //关闭sqlsession
        sqlSession.close();
    }

    //selectbyid
    @Test
    public void getUserById()
    {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User UserById = userMapper.getUserById(1);

        System.out.println(UserById);

        sqlSession.close();
    }

    //**增删改需要提交事务
    //insert 无返回值则不需要resulttype
    @Test
    public void addUser()
    {
        SqlSession sqlSession =MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        int res=mapper.addUser(new User(4, "哈哈", "123444"));
        if(res>0) System.out.println("插入成功");
        //提交事务
       sqlSession.commit();//提交

        sqlSession.close();

    }

    //updata
    @Test
    public void update()
    {
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        int res=userMapper.updateUser(new User(4, "呵呵", "444444"));
        if(res>0) System.out.println("修改成功");

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser()
    {
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
        int res=userMapper.deleteUser(4);
        if(res>0) System.out.println("删除成功");

        sqlSession.commit();
        sqlSession.close();
    }


    }
