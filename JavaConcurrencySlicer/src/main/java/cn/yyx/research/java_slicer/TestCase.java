package cn.yyx.research.java_slicer;

public class TestCase {
	
	private String filename = null;
	private String content = null;
	
	public TestCase(String filename, String content) {
		this.setFilename(filename);
		this.setContent(content);
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
