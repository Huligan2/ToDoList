package java.Schneider.Definitions;

import java.io.*;
import java.util.Date;

public class PersonalToDoItem extends ToDoItem{

	private ByteArrayOutputStream attachment;	
	private String fileName;
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private boolean attachmentExists;
	 
	public boolean isAttachmentExists() {
		return attachmentExists;
	}

	public void setAttachmentExists(boolean attachmentExists) {
		this.attachmentExists = attachmentExists;
	}

	public ByteArrayOutputStream getAttachment() {
		return attachment;
	}

	public void setAttachment(ByteArrayOutputStream attachment) {
		this.attachment = attachment;
	}

	public PersonalToDoItem() 
	{
		// TODO Auto-generated constructor stub
	}

}
