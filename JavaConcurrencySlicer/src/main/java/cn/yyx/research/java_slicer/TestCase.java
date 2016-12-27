package cn.yyx.research.java_slicer;

public class TestCase {
	
	private String filename = null;
	private String content = null;
	private String one_case = null;
	
	public TestCase(String filename, String content, String one_case) {
		this.setFilename(filename);
		this.setContent(content);
		this.setOneCase(one_case);
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

	public String getOneCase() {
		return one_case;
	}

	public void setOneCase(String one_case) {
		this.one_case = one_case;
	}
	
}
