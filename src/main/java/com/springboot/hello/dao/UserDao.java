package com.springboot.hello.dao;


import com.springboot.hello.domain.dto.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add (User user) {
        this.jdbcTemplate.update("INSERT INTO Users(id, name, password) VALUES (?, ?, ?)",
                user.getId(), user.getName(), user.getPassword());
    }

    public void deleteById (String id){
        jdbcTemplate.update("DELETE * FROM Users where id = ?;", id);
    }

    public void deleteAll() throws SQLException{
        jdbcTemplate.update("DELETE FROM Users;");
    }


    public User findById(String id) {
        String sql = "SELECT * FROM Users where id = ?";
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
                return user;
            }
        };
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM Users;";
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
                return user;
            }
        };
        return this.jdbcTemplate.query(sql, rowMapper);
    }



}
