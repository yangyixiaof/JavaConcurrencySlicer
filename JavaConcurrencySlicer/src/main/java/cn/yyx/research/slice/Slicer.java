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
	
	public static final String consuitedir = "consuite-tests";
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
		if (root != null && root.listFiles() != null)
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
			String prename = testDir.substring(testDir.indexOf('/', testdir.length())+1).replace('/', '_');
			
			int count = 0;
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
					count++;
					TestCase tc = litr.next();
					String testname = prename+"_"+(tc.getFilename().endsWith(".java") ? prefix+tc.getFilename() : prefix+tc.getFilename()+".java");
					String classname = testname.substring(0, testname.indexOf(".java"));
					classname = classname + count;
					String packagename = prename.replaceAll("_", ".");
					String filepackagename = prename.replaceAll("_", "/");
					FileUtil.WriteToFile(classname + ".java", tc.getContent().replace(SlicedCodeGenerator.Class_Final_Name, classname).replace(SlicedCodeGenerator.PACKAGE, packagename), consuitedir + "/" + filepackagename);
				}
				
				// unit test.
//				String unit_class_test = prename + "_" + prefix + "Test";
//				StringBuilder unit_test = new StringBuilder("");
//				String import_content = psv.GetImportContent().trim();
//				import_content += "\n\nimport org.junit.Test;\n\n";
//				unit_test.append(import_content);
//				unit_test.append("public class " + unit_class_test + " {\n\n");
//				count = 0;
//				litr = lts.iterator();
//				while (litr.hasNext())
//				{
//					count++;
//					TestCase tc = litr.next();
//					unit_test.append(SlicedCodeGenerator.ONE_LINETAB + "@Test\n");
//					unit_test.append(SlicedCodeGenerator.ONE_LINETAB + "public void test" + count + "() {\n");
//					unit_test.append(tc.getOneCase());
//					unit_test.append(SlicedCodeGenerator.ONE_LINETAB + "}\n\n");
//				}
//				unit_test.append("}\n");
//				FileUtil.WriteToFile(unit_class_test + ".java", unit_test.toString(), testdir + "/" + SlicedCodeGenerator.PACKAGE);
			}
			
			for (File f : files) {
				if (f.isDirectory()) {
					SliceSuffixedTestInDirectory(suffix, testDir+"/"+f.getName());
				}
			}
			
		}
	}
	
}
