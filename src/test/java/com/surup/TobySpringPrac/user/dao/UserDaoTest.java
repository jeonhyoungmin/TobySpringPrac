package com.surup.TobySpringPrac.user.dao;

import com.surup.TobySpringPrac.user.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

@DisplayName("UserDao")
class UserDaoTest {

    @DisplayName("[UserDao] [addAndGet]")
    @Test
    void addAndGet() throws SQLException {
        UserDao dao = new DaoFactory().userDao();

        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        User user = new User();
        user.setId("psvm");
        user.setName("몽총이");
        user.setPassword("ahdchd123");

        dao.add(user);
        assertThat(dao.getCount()).isEqualTo(1);

        User user2 = dao.get(user.getId());

        assertThat(user2.getName()).isEqualTo(user.getName());
        assertThat(user2.getPassword()).isEqualTo(user.getPassword());
    }

    @DisplayName("[UserDao] [count]")
    @Test
    void count() throws SQLException {
        UserDao dao = new DaoFactory().userDao();

        User user1 = new User("psvm", "몽총이", "ahdchd123");
        User user2 = new User("dao", "다오", "ekdh123");
        User user3 = new User("dto", "상자", "tkdwk123");

        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        dao.add(user1);
        assertThat(dao.getCount()).isEqualTo(1);

        dao.add(user2);
        assertThat(dao.getCount()).isEqualTo(2);

        dao.add(user3);
        assertThat(dao.getCount()).isEqualTo(3);
    }

    @DisplayName("[UserDao] [get] : 존재하지 않는 유저 정보 조회")
    @Test()
    void getUserFailure() throws SQLException {
        UserDao dao = new DaoFactory().userDao();

        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        assertThatThrownBy(() -> dao.get("unknown_id"))
                .isInstanceOf(EmptyResultDataAccessException.class);
    }

}