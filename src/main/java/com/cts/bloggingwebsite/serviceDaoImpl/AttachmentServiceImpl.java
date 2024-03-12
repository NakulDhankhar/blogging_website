package com.cts.bloggingwebsite.serviceDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bloggingwebsite.dao.AttachmentDao;
import com.cts.bloggingwebsite.entities.Attachment;
import com.cts.bloggingwebsite.serviceDao.AttachmentService;

@Service
public class AttachmentServiceImpl implements AttachmentService{
	@Autowired
	private AttachmentDao attachmentDao;
	
	
	@Override
	public void addAttachment(Attachment attachment) {
		attachmentDao.addAttachment(attachment);
		
	}

	@Override
	public boolean deleteAttachment(int attachment_id) {
		return attachmentDao.deleteAttachment(attachment_id);
	}

}
