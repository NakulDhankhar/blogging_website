package com.cts.bloggingwebsite.app;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.cts.bloggingwebsite.DaoImpl.AttachmentDaoImpl;
import com.cts.bloggingwebsite.DaoImpl.BlogPostDaoImpl;
import com.cts.bloggingwebsite.DaoImpl.CategoryDaoImpl;
import com.cts.bloggingwebsite.DaoImpl.CommentDaoImpl;
import com.cts.bloggingwebsite.DaoImpl.UserDaoImpl;
import com.cts.bloggingwebsite.dao.AttachmentDao;
import com.cts.bloggingwebsite.dao.BlogPostDao;
import com.cts.bloggingwebsite.dao.CategoryDao;
import com.cts.bloggingwebsite.dao.CommentDao;
import com.cts.bloggingwebsite.dao.UserDao;
import com.cts.bloggingwebsite.serviceDao.AttachmentService;
import com.cts.bloggingwebsite.serviceDaoImpl.AttachmentServiceImpl;

@Configuration
//@ComponentScan(basePackages = "com.cts.bloggingwebsite.DaoImpl")
public class AppConfig {
	@Bean
	DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/blog_database");
	        dataSource.setUsername("root");
	        dataSource.setPassword("Nakul123");
	        return dataSource;
	    }
//	DataSource
//	public JdbcTemplate jdbcTemplate() {
//		String url="jdbc:mysql://localhost/blog_database";
//		String username="root";
//		String password="Nakul123";
//		
//
//		DataSource dataSource = new DriverManagerDataSource(url, username, password);
//		
//		return new JdbcTemplate(dataSource);
//	}
	@Bean
	JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate();
	}
	
	@Bean
	UserDao userDao()
	{
		return new UserDaoImpl();
		
	}
	@Bean
	CommentDao commentDao()
	{
		return new CommentDaoImpl();
	}
	@Bean
	CategoryDao categoryDao()
	{
		return new CategoryDaoImpl();
	}
	
	@Bean
	BlogPostDao blogPostDao()
	{
		return new BlogPostDaoImpl();
		
	}
	@Bean
	AttachmentDao attachmentDao()
	{
		return new AttachmentDaoImpl();
		
	}
	
	@Bean
	AttachmentService attachmentService() {
		return new AttachmentServiceImpl();
	}
	
	
}
