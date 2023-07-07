package com.example.orm1;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person p = new Person();
        p.id = rs.getInt("id");
        p.username = rs.getString("username");
        p.email = rs.getString( "email");
        return p;
    }
}
