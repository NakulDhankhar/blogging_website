package com.cts.bloggingwebsite.entities;

public class Attachment {
	private int attachment_id;
	private int post_id;
	private String file_path;
	private String file_type;
	
	public Attachment()
	{
		super();
	}
	@Override
	public String toString() {
		return "Attachment [attachment_id=" + attachment_id + ", post_id=" + post_id + ", file_path=" + file_path
				+ ", file_type=" + file_type + "]";
	}
	public int getAttachment_id() {
		return attachment_id;
	}
	public void setAttachment_id(int attachment_id) {
		this.attachment_id = attachment_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getFile_type() {
		return file_type;
	}
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	
	public Attachment(int attachment_id, int post_id, String file_path, String file_type) {
		super();
		this.attachment_id = attachment_id;
		this.post_id = post_id;
		this.file_path = file_path;
		this.file_type = file_type;
	}
	

}
