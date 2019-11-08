package com.jtintel.service.impl;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jtintel.bean.Person;
import com.jtintel.service.PersonService;

public class PersonServiceBean implements PersonService {
	private JdbcTemplate jdbcTemplate;  //使用Spring提供封装好了的JdbcTemplate类来操作数据库

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public void delete(Integer personId) {
		String sql = "delete from Person where id = ?";
		Object[] args = new Object[]{personId};
		int[] argsTypes = new int[] {java.sql.Types.INTEGER};
		jdbcTemplate.update(sql, args, argsTypes);
		/**
		 * 测试两个update是不是在同一个事物中执行，要是在同一个事物中执行则，第二个语句会因为找不到
		 * 相应的表，而出现异常，而且第一个事物也不会执行
		 * 当将XML文件中的事物配置项注释掉，则第一个事物可以被执行
		 */
		jdbcTemplate.update("delete from Persons where id = 10");
	}
	public void delete2(Integer personId) throws Exception {
		String sql = "delete from Person where id = ?";
		Object[] args = new Object[]{personId};
		int[] argsTypes = new int[] {java.sql.Types.INTEGER};
		jdbcTemplate.update(sql, args, argsTypes);
		throw new Exception("checked的异常");
	}
	
	public Person getPerson(Integer personId) {
		String sql = "select * from Person where id = ?";
		Object[] args = new Object[]{personId};
		Person person = (Person)jdbcTemplate.queryForObject(sql, args, new PersonRowMapper());
		return person;
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getPersons() {
		String sql = "select * from Person";
		List<Person> person = (List<Person>)jdbcTemplate.query(sql,new PersonRowMapper());
		return person;
	}

	public void save(Person person) {
		String sql = "insert into Person(id,name) values(PERSONSEQ.nextval,?)";
		Object[] args = new Object[]{person.getName()};
		int[] argsTypes = new int[] {java.sql.Types.VARCHAR};
		jdbcTemplate.update(sql, args, argsTypes);

	}

	public void update(Person person) {
		String sql = "update Person set name = ? where id = ?";
		Object[] args = new Object[]{person.getName(),person.getId()};
		int[] argsTypes = new int[] {java.sql.Types.VARCHAR,java.sql.Types.INTEGER};
		jdbcTemplate.update(sql, args, argsTypes);

	}
	

	

}
