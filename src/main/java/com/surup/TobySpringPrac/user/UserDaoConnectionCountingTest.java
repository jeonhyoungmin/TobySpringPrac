package com.surup.TobySpringPrac.user;

import com.surup.TobySpringPrac.user.dao.CountingConnectionMaker;
import com.surup.TobySpringPrac.user.dao.CountingDaoFactory;
import com.surup.TobySpringPrac.user.dao.UserDao;
import com.surup.TobySpringPrac.user.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoConnectionCountingTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("surup");
        user.setName("ㅈㅎㅁ");
        user.setPassword("pass123#");

        dao.add(user);
        dao.get(user.getId());
        dao.get(user.getId());
        dao.get(user.getId());
        dao.get(user.getId());
        dao.get(user.getId());

        CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection counter : " + ccm.getCounter());

    }

}
