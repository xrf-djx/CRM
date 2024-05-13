package com.bjpowernode.service;

import com.bjpowernode.domain.Student;

public interface StudentService {
    //通过id返单条数据
    public Student getById(String id);
    //添加数据
    public void save(Student s);

    public Student select(Student s);
}
