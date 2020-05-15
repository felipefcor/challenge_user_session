package com.kubikdata.infrastructure;

import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.domain.User;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@Primary
public class SQLUserRepository implements UserRepositoryInterface {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void add(Username username, User user) {
        jdbcTemplate.update("INSERT INTO users (username, token, date_session) VALUES (?, ?)", user.createUserResponse().getUsername(), user.createUserResponse().getToken(), user.createUserResponse().getDate());
    }

    @Override
    public User get(Username username) {

        UserResponse userResponse = new User(new Username(""),new UserToken(""), LocalDate.now()).createUserResponse();
        try {
            jdbcTemplate.query("SELECT * FROM users WHERE username=?",
                    new Object[]{username}, (rs, rowNum) -> {
                        userResponse.username = rs.getString("username");
                        userResponse.token = rs.getString("token");
                        userResponse.date = rs.getTimestamp("date_session");

                        return null;
                    });
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
        return new User(new Username(userResponse.getUsername()), new UserToken(userResponse.getToken()), userResponse.getDate().toLocalDateTime().toLocalDate());
    }
}
