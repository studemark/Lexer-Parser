
public class Lexer {
	
	String inputString;
	
	public Lexer(String in) {
		inputString = in;
	}
	
	public Token GetNextToken() {
		StringBuilder stringToken = new StringBuilder();
		StringBuilder doubleToken = new StringBuilder();
		char curChar;
		
		if (!inputString.equals("")) {
			curChar = inputString.charAt(0);
		}
		else {
			return null;
		}
		
		while (Character.isWhitespace(curChar)) {
			if (inputString.length() == 1) {
				return null;
			}
			if (!inputString.equals("")) {
				inputString = inputString.substring(1);
				curChar = inputString.charAt(0);
			}
			else {
				return null;
			}
		}
		
		switch(curChar) {
			case '=':
				inputString = inputString.length() == 1 ? "" : inputString.substring(1);
				return new Token(Token.TokenType.EQUALS, "=", 0.000);
			
			case '+':
				inputString = inputString.length() == 1 ? "" : inputString.substring(1);
				return new Token(Token.TokenType.PLUS, "+", 0.000);
			
			case '-':
				inputString = inputString.length() == 1 ? "" : inputString.substring(1);
				return new Token(Token.TokenType.MINUS, "-", 0.000);
		
			case '*':
				inputString = inputString.length() == 1 ? "" : inputString.substring(1);
				return new Token(Token.TokenType.MULT, "*", 0.000);

			case '/':
				inputString = inputString.length() == 1 ? "" : inputString.substring(1);
				return new Token(Token.TokenType.DIV, "/", 0.000);

			case '(':
				inputString = inputString.length() == 1 ? "" : inputString.substring(1);
				return new Token(Token.TokenType.LPAREN, "(", 0.000);
					
			case ')':
				inputString = inputString.length() == 1 ? "" : inputString.substring(1);
				return new Token(Token.TokenType.RPAREN, ")", 0.000);
					
			default:
				if ((Character.toString(curChar)).matches("([a-z]|[A-Z])+")) {
					stringToken.append(curChar);
					if (inputString.length() == 1) {
						inputString = "";
						return new Token(Token.TokenType.ID, stringToken.toString(), 0.000);
					}
					inputString = inputString.substring(1);
					curChar = inputString.charAt(0);
					while (Character.toString(curChar).matches("([a-z]|[A-Z]|[0-9])*")) {
						stringToken.append(curChar);
						if (inputString.length() == 1) {
							inputString = "";
							return new Token(Token.TokenType.ID, stringToken.toString(), 0.000);
						}
						inputString = inputString.substring(1);
						curChar = inputString.charAt(0);
					}
					inputString = inputString.substring(1);
					return new Token(Token.TokenType.ID, stringToken.toString(), 0.000);
				}
					
				else if (Character.toString(curChar).matches("([0-9]|[.])+")) {
					doubleToken.append(curChar);
					if (inputString.length() == 1) {
						inputString = "";
						return new Token(Token.TokenType.DOUBLE, doubleToken.toString(), Double.valueOf(doubleToken.toString()));
					}
					inputString = inputString.substring(1);
					curChar = inputString.charAt(0);
					while (Character.toString(curChar).matches("([0-9]|[.])+")) {
						doubleToken.append(curChar);
						if (inputString.length() == 1) {
							inputString = "";
							return new Token(Token.TokenType.DOUBLE, doubleToken.toString(), Double.valueOf(doubleToken.toString()));
						}
						inputString = inputString.substring(1);
						curChar = inputString.charAt(0);
					}
					return new Token(Token.TokenType.DOUBLE, doubleToken.toString(), Double.valueOf(doubleToken.toString()));
				}
		}
		return null; 
	}
	
	/*public void GetNextToken(String token) {
		
	}*/
}
