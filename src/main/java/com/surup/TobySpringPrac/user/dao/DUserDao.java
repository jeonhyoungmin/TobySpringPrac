package com.surup.TobySpringPrac.user.dao;

import com.surup.TobySpringPrac.user.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DUserDao extends UserDao {

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        // D 사 DB Connection 생성코드
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/tobyspringprac", "toby", "pass123#");
        return c;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao dao = new DUserDao();

        User user = new User();
        user.setId("surup");
        user.setName("전형민");
        user.setPassword("pass123#");

        dao.add(user);

        System.out.println("DUserDao");
        System.out.println(user.getId() + "등록 성공!");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공!");
    }
}
