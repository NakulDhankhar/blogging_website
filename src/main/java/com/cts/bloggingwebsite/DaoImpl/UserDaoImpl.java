package com.cts.bloggingwebsite.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cts.bloggingwebsite.dao.UserDao;
import com.cts.bloggingwebsite.entities.User;

@Component
public class UserDaoImpl implements UserDao{
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
//	public UserDaoImpl(JdbcTemplate jdbcTemplate)
//	{
//		this.jdbcTemplate=jdbcTemplate;
//	}
	
	
	

	@Override
	public boolean login(String email, String password) {
		String sql = "SELECT COUNT(*) FROM User WHERE email = ? AND password = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, email, password);
        return count > 0;
		
	}

	@Override
	public boolean addUser(User user) {
		String sql = "INSERT INTO User (username, password, email) VALUES (?, ?, ?)";
        int count = jdbcTemplate.update(sql,user.getUsername(), user.getPassword(), user.getEmail());
		return count > 0;
	}

	@Override
	public User getUserById(int user_id) {
		String sql = "SELECT * FROM User WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user_id);
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM User";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
	}

	@Override
	public boolean updateUserById(User user) {
		String sql = "UPDATE User SET username = ?, password = ?, email = ? WHERE user_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getUser_id());
        return rowsAffected > 0;
	}

	@Override
	public boolean deleteUserById(int user_id) {
		String sql = "DELETE FROM User WHERE user_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, user_id);
        return rowsAffected > 0;
	}

	@Override
	public boolean deleteAllUser() {
		String sql = "DELETE FROM User";
        int rowsAffected = jdbcTemplate.update(sql);
        return rowsAffected > 0;
	}
	

}
