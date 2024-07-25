package com.example.demo.Login.repository;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Login.entity.MyUser;

@Repository
public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public MyUser findUserByUserName(String userName) {
    
        String sql = "SELECT id, password, name FROM table1 WHERE id = ?";       
        //ユーザを一件取得
        Map<String, Object> result = jdbcTemplate.queryForMap(sql, userName);      
        System.out.println(result);
        // Entityクラス(User型)に変換
        MyUser user = convMapToUser(result);       
        System.out.println(user.getName());

        return user;
    }


    private MyUser convMapToUser(Map<String, Object> map) {
        MyUser user = new MyUser();
        user.setId((String) map.get("id"));
        user.setPassword((String) map.get("password"));
        user.setName((String) map.get("name"));       
        System.out.println(user);

        return user;
    }
}
