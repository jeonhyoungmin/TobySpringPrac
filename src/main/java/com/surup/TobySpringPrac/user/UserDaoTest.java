package com.surup.TobySpringPrac.user;

import com.surup.TobySpringPrac.user.dao.UserDao;
import com.surup.TobySpringPrac.user.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) throws SQLException {
         ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
         UserDao dao = context.getBean(UserDao.class);

        User user = new User();
        user.setId("surup");
        user.setName("ㅈㅎㅁ");
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
