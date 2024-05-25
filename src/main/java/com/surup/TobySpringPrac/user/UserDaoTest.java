package com.surup.TobySpringPrac.user;

import com.surup.TobySpringPrac.user.dao.CountingDaoFactory;
import com.surup.TobySpringPrac.user.dao.DaoFactory;
import com.surup.TobySpringPrac.user.dao.UserDao;
import com.surup.TobySpringPrac.user.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) throws SQLException {
//        ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
//        UserDao dao = context.getBean("userDao", UserDao.class);
        UserDao dao = new DaoFactory().userDao();

        User user = new User();
        user.setId("surup");
        user.setName("ㅈㅎㅁ");
        user.setPassword("pass123#");

        dao.add(user);

        System.out.println("DUserDao");
        System.out.println(user.getId() + "등록 성공!");

        User user2 = dao.get(user.getId());
        user2.setName("name");

        if (!user.getName().equals(user2.getName())) {
            System.out.println("테스트 실패 (name)");
        } else if (!user.getPassword().equals(user2.getPassword())) {
            System.out.println("테스트 실패 (password)");
        } else {
            System.out.println("조회 테스트 성공");
        }
    }

}
