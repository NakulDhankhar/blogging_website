package com.cts.bloggingwebsite.dao;

import com.cts.bloggingwebsite.entities.Attachment;

public interface AttachmentDao {
	public void addAttachment(Attachment attachment);
	public boolean deleteAttachment(int attachment_id);
	
}
