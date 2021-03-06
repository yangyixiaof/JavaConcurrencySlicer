package cn.yyx.research.file_util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileUtil {

	public static String ReadFromFile(File f) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(f));
			StringBuilder content = new StringBuilder();
			String tmp = null;
			while ((tmp = reader.readLine()) != null) {
				content.append(tmp);
				content.append("\n");
			}
			reader.close();
			reader = null;
			String source = content.toString();
			return source;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

	public static void WriteToFile(String filename, String filecontent, String directory) {
		if (directory == null) {
			directory = "";
		}

		String filepath = directory + "/" + filename;
		if (directory.endsWith("/") || directory.endsWith("\\")) {
			filepath = directory + filename;
		}
		try {
			if (!directory.equals(""))
			{
				File diret = new File(directory);
				if (!diret.exists())
				{
					diret.mkdirs();
				}
			}
			File f = new File(filepath);
			if (!f.exists()) {
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(filecontent);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("There are errors in creating files or directories.");
			System.exit(1);
		}
	}

}
