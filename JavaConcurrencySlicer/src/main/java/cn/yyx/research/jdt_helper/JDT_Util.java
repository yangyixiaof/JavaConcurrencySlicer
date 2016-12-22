package cn.yyx.research.jdt_helper;

import java.util.Map;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jface.text.IDocument;

public class JDT_Util {

	public static CompilationUnit parseSourceCode(String identifier, IDocument pdocument) {
		ASTParser parser = ASTParser.newParser(AST.JLS8);
		
		parser.setResolveBindings(true);
		parser.setBindingsRecovery(true);
		String[] sources = { };
		String[] encodings = new String[] { }; // "UTF-8"
		String javahome = System.getProperty("java.home");
		String rtpath = javahome+"/lib/rt.jar";
		String[] classpath = { rtpath };
		parser.setEnvironment(classpath, sources, encodings, true);
		
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setUnitName(identifier);
		Map<String, String> options = JavaCore.getOptions();
		options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_8);
		parser.setCompilerOptions(options);
		parser.setSource(pdocument.get().toCharArray());
		CompilationUnit compilationUnit = (CompilationUnit) parser.createAST(null);
		return compilationUnit;
	}

}
