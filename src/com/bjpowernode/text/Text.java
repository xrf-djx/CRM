package com.bjpowernode.text;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.service.impl.StudentServiceImpl;
import com.bjpowernode.util.ServiceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Text {
    public static void main(String[] args){
       Student s=new Student("xrf","1",19);
        StudentService ss=(StudentService) ServiceFactory.getService(new StudentServiceImpl());
       Student s2=ss.select(s);
        System.out.println(s2);

    }
}
