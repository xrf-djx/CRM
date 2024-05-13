package com.bjpowernode.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandier implements InvocationHandler {
    private Object target;
    public TransactionInvocationHandier(Object target){
        this.target=target;
    }

    @Override
    //这个invoke是这个代理类的方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session=null;
        Object obj=null;
        try {
            //处理业务逻辑
            session = SqlSessionUtil.getSession();

            //这个invoke是实体类的方法
            obj=method.invoke(target,args);

            //处理业务逻辑完毕后，提交事务
            session.commit();


        }catch(Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            SqlSessionUtil.myClose(session);
        }

        return obj;
    }
    public Object getProxy(){
        //获取代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }





}
