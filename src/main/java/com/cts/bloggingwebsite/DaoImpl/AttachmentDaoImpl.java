package com.cts.bloggingwebsite.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cts.bloggingwebsite.dao.AttachmentDao;
import com.cts.bloggingwebsite.entities.Attachment;

@Component
public class AttachmentDaoImpl implements AttachmentDao{
	@Autowired
    private  JdbcTemplate jdbcTemplate;

   

	@Override
	public void addAttachment(Attachment attachment) {
		String sql = "INSERT INTO Attachment (file_path, file_type) VALUES ( ?, ?)";
        jdbcTemplate.update(sql, attachment.getFile_path(), attachment.getFile_type());
		
		
	}

	@Override
	public boolean deleteAttachment(int attachment_id) {
		String sql = "DELETE FROM Attachment WHERE attachment_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, attachment_id);
        return rowsAffected > 0;
	}

}
