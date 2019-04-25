
public class Token {
	String name;
	double value;
	TokenType type;
	enum TokenType {
		ID, EQUALS, DOUBLE, PLUS, MINUS, MULT, DIV, LPAREN, RPAREN; 
	};
	
	public Token(TokenType t, String n, double v) {
		this.type = t;
		this.name = n;
		this.value = v;
	}
	
}
