package com.lok.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lok.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public User save(User user) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String insertSql = "insert into user (Name,UserName,Password,Email,Location) values (?,?,?,?,?)";
		jdbcTemplate.update(insertSql, new Object[]{
				user.getName(),user.getUserName(),user.getPassword(),user.getEmail(),user.getLocation()
		});
		user.setId(this.getUserId(user));
		return user;
	}

	@Override
	public void delete(User user) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String deleteSql = "delete from user where Id = ?";
		jdbcTemplate.update(deleteSql, new Object[]{user.getId()});
	}

	@Override
	public User update(User user) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String updateSql = "update user set Name=?, UserName=?, Password=?, Email=?, Location=? where Id = ?";
		jdbcTemplate.update(updateSql, new Object[]{
				user.getName(),user.getUserName(),user.getPassword(),user.getEmail(),user.getLocation(),user.getId()
		});
		return user;
	}
	
	@Override
	public long getUserId(User user){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String selectSql = "select Id from user where Name=? and UserName=?";
		return jdbcTemplate.queryForLong(selectSql, new Object[]{ user.getName(),user.getUserName()});
	}
	
	@Override
	public User getUser(long userId){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String selectSql = "select * from user where Id=?";
		return (User) jdbcTemplate.queryForObject(selectSql, new Object[]{ userId},User.class);
	}
	
	@Override
	public long getUserCount(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String selectSql = "select count(*) from user";
		return jdbcTemplate.queryForLong(selectSql);
	}

}
