package cn.yyx.research.JavaSlicer;

import org.junit.Test;

import cn.yyx.research.integrate.ConcatMain;
import cn.yyx.research.integrate.DisplayInfo;

public class ProcessTest {

	@Test
	public void testx1() {
		ConcatMain cm = new ConcatMain(new String[]{"-Djava7=\"C:/Program Files/Java/jdk1.7.0_79\""});
		String cmd = "javac -version";
		cm.RunOneProcess(cmd, false, new DisplayInfo(System.out), new DisplayInfo(System.err), -1);
		cmd = "java -version";
		cm.RunOneProcess(cmd, false, new DisplayInfo(System.out), new DisplayInfo(System.err), -1);
	}
	
	@Test
	public void testx2()
	{
		String av = "as";
		String cd = av.substring(0, av.lastIndexOf('.')+1);
		System.out.println(cd);
	}

}
