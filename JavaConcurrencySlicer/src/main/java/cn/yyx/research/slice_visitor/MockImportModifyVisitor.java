package cn.yyx.research.slice_visitor;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SimpleName;

public class MockImportModifyVisitor extends ASTVisitor {
	
	Set<IBinding> ibset = new HashSet<IBinding>();
	List<String> importlist = new LinkedList<String>();
	
	@Override
	public boolean visit(ImportDeclaration node) {
		String import_name = node.getName().toString();
		if (import_name.startsWith("org.evosuite.runtime.mock."))
		{
			QualifiedName qn = (QualifiedName)node.getName();
			SimpleName sn = qn.getName();
			String snstr = sn.toString();
			if (snstr.startsWith("Mock"))
			{
				ibset.add(sn.resolveBinding());
			}
		}
		return super.visit(node);
	}
	
	@Override
	public void endVisit(ImportDeclaration node) {
		String import_name = node.getName().toString();
		if (import_name.startsWith("org.evosuite.runtime.mock."))
		{
			String import_name_back = import_name.substring("org.evosuite.runtime.mock.".length());
			node.setName(node.getAST().newName(import_name_back));
		}
		String impt = node.getName().toString();
		if (!importlist.contains(impt)) {
			importlist.add(impt);
		} else {
			node.delete();
		}
	}
	
	@Override
	public boolean visit(SimpleName node) {
		IBinding ib = node.resolveBinding();
		if (ibset.contains(ib))
		{
			node.setIdentifier(node.toString().substring("Mock".length()));
		}
		return super.visit(node);
	}
	
}
