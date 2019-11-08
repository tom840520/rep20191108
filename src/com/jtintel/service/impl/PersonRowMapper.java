package com.jtintel.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jtintel.bean.Person;

public class PersonRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int index) throws SQLException {
		Person person = new Person();
		person.setId(rs.getInt("id"));
		person.setName(rs.getString("name"));
		return person;
	}

}
