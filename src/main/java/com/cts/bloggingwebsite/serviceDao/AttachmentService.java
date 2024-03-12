package com.cts.bloggingwebsite.serviceDao;

import com.cts.bloggingwebsite.entities.Attachment;

public interface AttachmentService {
	public void addAttachment(Attachment attachment);
	public boolean deleteAttachment(int attachment_id);
}
