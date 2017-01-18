package cn.yyx.research.util;

import java.io.File;
import java.lang.ProcessBuilder.Redirect;
import java.util.Map;

public class TestUtil {
	
	public static void main(String[] args) {
		System.out.println(System.getenv("JAVA_HOME"));
		System.out.println(new File("haha").getAbsolutePath().replace('\\', '/'));
		System.out.println("abc.java".matches(".+(\\.java)$"));
		System.out.println("abc.class".matches(".+(TestCase([0-9]+)\\.class)$"));
		System.out.println("TestCase12.class".matches(".+(TestCase([0-9]+)\\.class)$"));
		System.out.println("TestCase12$2.class".matches(".+(TestCase([0-9]+)\\.class)$"));
		System.out.println("HaHaTestCase12.class".matches(".+(TestCase([0-9]+)\\.class)$"));
		
//		File heihei = new File(".kj");
//		List<String> res = new LinkedList<String>();
//		res.add("iu");
//		res.add("op");
//		FileUtil.AppendToFile(heihei.getAbsolutePath(), res);
		
//		try {
//			String str = "add your string content";
//			InputStream inputStream = new ByteArrayInputStream(str.getBytes());
//			FileUtil.ReadFromStreamAndWriteToFile(inputStream, "D:/ddd.ddd");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		System.out.println(new File(".").getAbsolutePath());
//		String here = new File("here").getAbsolutePath();
//		here = here.substring(0, here.length()-"here".length());
//		System.out.println("here:"+here);
		
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "java", "-version");
		Map<String, String> e = pb.environment();
		System.out.println(e.get("JAVA_HOME").replace('\\', '/'));
		System.out.println(e.get("PATH").replace('\\', '/'));
		System.out.println(e.get("CLASSPATH").replace('\\', '/'));
		
		String replaced = e.get("JAVA_HOME").replace('\\', '/');
		String replace = "C:/Program Files/Java/jdk1.7.0_79";
		e.put("JAVA_HOME", e.get("JAVA_HOME").replace('\\', '/').replace(replaced, replace));
		e.put("PATH", e.get("PATH").replace('\\', '/').replace(replaced, replace));
		e.put("CLASSPATH", e.get("CLASSPATH").replace('\\', '/').replace(replaced, replace));
		System.out.println(e.get("JAVA_HOME").replace('\\', '/'));
		System.out.println(e.get("PATH").replace('\\', '/'));
		System.out.println(e.get("CLASSPATH").replace('\\', '/'));
		try {
			pb.redirectOutput(Redirect.INHERIT);
			pb.redirectError(Redirect.INHERIT);
			Process process = pb.start();
			process.waitFor();
			Thread.sleep(1000);
			SystemStreamUtil.Flush();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
}
