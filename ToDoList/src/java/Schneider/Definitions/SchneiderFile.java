package java.Schneider.Definitions;

public class SchneiderFile extends java.io.File{


	private String filePath;
	private String fileName;
	
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public SchneiderFile(String pathName) {
		super(pathName);
		// TODO Auto-generated constructor stub
	}
	

}
