package com.exxeta.iss.sonar.esql.api.tree;

import com.exxeta.iss.sonar.esql.api.tree.expression.ExpressionTree;
import com.exxeta.iss.sonar.esql.api.tree.lexical.SyntaxToken;
import com.exxeta.iss.sonar.esql.tree.impl.SeparatedList;
import com.exxeta.iss.sonar.esql.tree.impl.lexical.InternalSyntaxToken;

public interface PathElementTree extends Tree {
	SyntaxToken typeOpenParen();
	SeparatedList<InternalSyntaxToken> typeExpressionList();
	SyntaxToken typeCloseParen();
	NamespaceTree namespace();
	SyntaxToken namespaceCurlyOpen();
	ExpressionTree namespaceExpression();
	SyntaxToken namespaceCurlyClose();
	SyntaxToken namespaceStar();
	SyntaxToken colon();
	SyntaxToken nameCurlyOpen();
	ExpressionTree nameExpression();
	SyntaxToken nameCurlyClose();
	SyntaxToken name();
	IndexTree index();

}