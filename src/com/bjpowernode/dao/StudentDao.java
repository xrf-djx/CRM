package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

//这个接口是实现mybatis操作的接口
public interface StudentDao {
    //通过id返单条数据
    public Student getById(String id);
    //添加数据
    public void save(Student s);
    public Student select(Student s);
}
