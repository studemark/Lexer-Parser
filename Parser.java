import java.util.Iterator;
import java.util.LinkedList;

public class Parser {
	LinkedList<Token> tokenList;
	Token currentToken;
	Iterator<Token> i;
	
	Parser(LinkedList<Token> tokens) {
		tokenList = tokens;
		i = tokenList.iterator();
	}
	
	public ExpressionNode Parse() {
		if (i.hasNext())
			currentToken = i.next();
		return Expression();
	}
	
	private ExpressionNode Expression() {
		ExpressionNode node1 = Term();
		node1 = RestExpression(node1);
		return node1;
	}
	
	private ExpressionNode RestExpression(ExpressionNode n) {
		if (tokenList.isEmpty()) {
			return n;
		}
		
		if (currentToken.type == Token.TokenType.PLUS) {
			currentToken = i.next();
			ExpressionNode node2 = Term();
			node2 = new AddNode(n, node2);
			node2 = RestExpression(node2);
			return node2;
		}
		
		if (currentToken.type == Token.TokenType.MINUS) {
			currentToken = i.next();
			ExpressionNode node2 = Term();
			node2 = new SubNode(n, node2);
			node2 = RestExpression(node2);
			return node2;
		}
		else {
			return n;
		}
	}
	
	private ExpressionNode Term() {
		ExpressionNode node3 = Factor();
		node3 = RestTerm(node3);
		return node3;
	}
	
	private ExpressionNode RestTerm(ExpressionNode n) {
		if (tokenList.isEmpty()) {
			return n;
		}
		
		else if (currentToken.type == Token.TokenType.MULT) {
			currentToken = i.next();
			ExpressionNode node5 = Term();
			node5 = new MultNode(n, node5);
			node5 = RestTerm(node5);
			return node5;
		}
		
		else if (currentToken.type == Token.TokenType.DIV) {
			currentToken = i.next();
			ExpressionNode node5 = Term();
			node5 = new DivNode(n, node5);
			node5 = RestTerm(node5);
			return node5;
		}
		else {
			return n;
		}
	}
	
	private ExpressionNode Factor() {
		if (currentToken.type == Token.TokenType.DOUBLE) {
			ExpressionNode dNode = new DoubleNode(currentToken.value);
			if (i.hasNext())
				currentToken = i.next();
			return dNode;
		}
		
		else {
			return null;
		}
		
	}
}
