package cn.yyx.research.slice;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jface.text.Document;

import cn.yyx.research.file_util.FileUtil;
import cn.yyx.research.java_slicer.TestCase;
import cn.yyx.research.jdt_helper.JDT_Util;
import cn.yyx.research.slice_visitor.ParseSliceVisitor;
import cn.yyx.research.slice_visitor.util.SlicedCodeGenerator;

public class Slicer {
	
	String targetclass = null;
	
	public Slicer(String targetclass) {
		this.targetclass = targetclass;
	}
	
	public void SliceSuffixedTestInDirectory(String suffix, String testDir)
	{
		File root = new File(testDir);
		// System.out.println(rootDir.listFiles());
		File[] files = root.listFiles();
		List<File> handlefiles = new LinkedList<File>();
		
		for (File f : files) {
			if (f.isFile()) {
				String filename = f.getName();
				if (filename.endsWith(suffix + ".java"))
				{
					handlefiles.add(f);
				}
			}
		}
		
		Iterator<File> fitr = handlefiles.iterator();
		while (fitr.hasNext())
		{
			File f = fitr.next();
			String prefix = f.getName().substring(0, f.getName().lastIndexOf(suffix + ".java")) + "_";
			ParseSliceVisitor psv = new ParseSliceVisitor(targetclass);
			CompilationUnit cu = JDT_Util.parseSourceCode(f.getName(), new Document(FileUtil.ReadFromFile(f)));
			// testing code.
			// cu.accept(new TestVisitor());
			cu.accept(psv);
			List<TestCase> lts = psv.GetTestCases();
			Iterator<TestCase> litr = lts.iterator();
			while (litr.hasNext())
			{
				TestCase tc = litr.next();
				FileUtil.WriteToFile((tc.getFilename().endsWith(".java") ? prefix+tc.getFilename() : prefix+tc.getFilename()+".java"), tc.getContent(), SlicedCodeGenerator.PACKAGE);
			}
		}
		
	}
	
}
