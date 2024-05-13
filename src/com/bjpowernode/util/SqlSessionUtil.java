package com.bjpowernode.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    private SqlSessionUtil(){}
    private static SqlSessionFactory sqlSessionFactory;
    static {
        //获取主配置文件的路径
        String url="mybatis-config.xml";
        //创建输入流对象
        InputStream inputStream=null;
        try {
            //把主配置文件传入输入流
            inputStream= Resources.getResourceAsStream(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //通过SqlSessionFactoryBuilder（）.build(输入流)来创建sql库
        sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
    }

    //创建一个封闭线程
    private static ThreadLocal<SqlSession>t=new ThreadLocal<SqlSession>();


    //取得SqlSession对象
    public static SqlSession getSession(){
        //把session取出
        SqlSession session=t.get();
        //如果没有取出，那么就创建一个新的再放入
        if(session==null){
            session=sqlSessionFactory.openSession();
            t.set(session);
        }
        return session;
    }


    public static void myClose(SqlSession session){
        if(session!=null){
            //关闭session
            session.close();
            //删除线程池里面的session
            t.remove();
        }
    }
}
