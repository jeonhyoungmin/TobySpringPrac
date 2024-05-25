package com.surup.TobySpringPrac.user.dao;

import com.surup.TobySpringPrac.user.domain.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

class UserDaoTest {

    @Test
    void addAndGet() throws SQLException {
        UserDao dao = new DaoFactory().userDao();
        dao.delete("psvm");

        User user = new User();
        user.setId("psvm");
        user.setName("몽총이");
        user.setPassword("ahdchd123");

        dao.add(user);

        User user2 = dao.get(user.getId());

        assertThat(user2.getName()).isEqualTo(user.getName());
        assertThat(user2.getPassword()).isEqualTo(user.getPassword());
    }

}