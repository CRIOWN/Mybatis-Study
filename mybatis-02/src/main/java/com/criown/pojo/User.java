package com.criown.pojo;

import org.apache.ibatis.type.Alias;

//实体类
//扫描package包默认为类名小写（user）
//也可以通过注解取别名(userclass) 在xml中调用

//@Alias("userclass")
public class User {
    private int id;  //id
    private String name;   //姓名
    private String pwd;   //密码

    public User() {
    }

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
