package cn.yyx.research.slice_visitor.util;

import java.util.List;

import cn.yyx.research.java_slicer.TestCase;

public class TestSuite {
	
	private String import_content = null;
	private List<TestCase> cases = null;
	
	public TestSuite(String import_content, List<TestCase> cases) {
		this.setImport_content(import_content);
		this.setCases(cases);
	}

	public String getImport_content() {
		return import_content;
	}

	public void setImport_content(String import_content) {
		this.import_content = import_content;
	}

	public List<TestCase> getCases() {
		return cases;
	}

	public void setCases(List<TestCase> cases) {
		this.cases = cases;
	}
	
}
