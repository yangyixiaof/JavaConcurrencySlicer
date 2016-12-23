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
	
	String testdir = null;
	
	public Slicer(String testDir) {
		this.testdir = testDir;
	}
	
	public void SliceSuffixedTestInDirectory(String suffix)
	{
		SliceSuffixedTestInDirectory(suffix, testdir);
	}
	
	private void SliceSuffixedTestInDirectory(String suffix, String testDir)
	{
		if (testDir.endsWith("/") || testDir.endsWith("\\"))
		{
			testDir = testDir.substring(0, testDir.length()-1);
		}
		File root = new File(testDir);
		// System.out.println(rootDir.listFiles());
		if (root != null)
		{
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
			
			testDir = testDir.replace('\\', '/');
			String prename = testDir.substring(testDir.indexOf('/')+1).replace('/', '_');
			
			Iterator<File> fitr = handlefiles.iterator();
			while (fitr.hasNext())
			{
				File f = fitr.next();
				String targetclass = f.getName().substring(0, f.getName().lastIndexOf(suffix + ".java"));
				String prefix = targetclass + "_";
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
					FileUtil.WriteToFile(prename+"_"+(tc.getFilename().endsWith(".java") ? prefix+tc.getFilename() : prefix+tc.getFilename()+".java"), tc.getContent(), testdir + "/" + SlicedCodeGenerator.PACKAGE);
				}
			}
			
			for (File f : files) {
				if (f.isDirectory()) {
					SliceSuffixedTestInDirectory(suffix, testDir+"/"+f.getName());
				}
			}
			
		}
	}
	
}
