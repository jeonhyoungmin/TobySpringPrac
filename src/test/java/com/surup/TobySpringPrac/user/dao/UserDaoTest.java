package com.surup.TobySpringPrac.user.dao;

import com.surup.TobySpringPrac.user.domain.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

@DisplayName("UserDao")
class UserDaoTest {

    private static UserDao dao;
    private static User user1;
    private static User user2;
    private static User user3;

    @BeforeAll
    static void setUp() {
        dao = new DaoFactory().userDao();
        user1 = new User("psvm", "몽총이", "ahdchd123");
        user2 = new User("dao", "다오", "ekdh123");
        user3 = new User("dto", "상자", "tkdwk123");
    }

    @DisplayName("[UserDao] [addAndGet]")
    @Test
    void addAndGet() throws SQLException {
        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        dao.add(user1);
        assertThat(dao.getCount()).isEqualTo(1);

        User userGet = dao.get(user1.getId());

        assertThat(userGet.getName()).isEqualTo(user1.getName());
        assertThat(userGet.getPassword()).isEqualTo(user1.getPassword());
    }

    @DisplayName("[UserDao] [count]")
    @Test
    void count() throws SQLException {
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
        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        assertThatThrownBy(() -> dao.get("unknown_id"))
                .isInstanceOf(EmptyResultDataAccessException.class);
    }

}