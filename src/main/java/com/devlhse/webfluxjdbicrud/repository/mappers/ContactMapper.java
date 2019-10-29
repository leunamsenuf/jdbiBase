package com.devlhse.webfluxjdbicrud.repository.mappers;

import com.devlhse.webfluxjdbicrud.model.Contact;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactMapper implements RowMapper<Contact> {

    @Override
    public Contact map(ResultSet rs, StatementContext ctx) throws SQLException {

        return new Contact.Builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .email(rs.getString("email"))
                .phone(rs.getLong("phone"))
                .build();
    }
}
