package com.surup.TobySpringPrac.user.dao;

import javax.sql.DataSource;

public class AccountDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // AccountDao 로직

}
