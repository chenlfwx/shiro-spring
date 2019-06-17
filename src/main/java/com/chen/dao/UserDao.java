package com.chen.dao;

import com.chen.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author Chen Dian
 * @date 2019/06/13
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getByUserName(String username){
        String sql = "SELECT * FROM tab_user WHERE name = ?";
        RowMapper<User> userRowMapper = new BeanPropertyRowMapper<>(User.class);
        try {
           return jdbcTemplate.queryForObject(sql, new Object[]{username}, userRowMapper);
        }catch (Exception e){
            return null;
        }
    }
}
