import java.util.LinkedList;
import java.util.Scanner;

public class StringHandlerFacade {
	static Scanner in;
	static Lexer lex;
	static Parser p;
	static LinkedList<Token> tokens = new LinkedList<>();

	public static void EvaluateOneString() {
		in = new Scanner(System.in);
		
		if(in.hasNext()) {
			lex = new Lexer(in.nextLine());
			Token next = lex.GetNextToken();
			while(next != null) {
				tokens.add(next);
				next = lex.GetNextToken();
			}
		}
		p = new Parser(tokens);
		System.out.println(p.Parse().Value());
	}
	
	/*public String ListTokens() {
		
	}*/
	
	public static void ListTokens() {
		
		System.out.println("Token Type     Lexeme       Value");
		System.out.println("=================================");
		
		for (Token t: tokens) {
			System.out.printf("%-11s%10s%12s\n", t.type.toString(), t.name, t.value);
		}
	}
	
	public static void main(String[] args) {
		EvaluateOneString();
		ListTokens();
		//System.out.println(tokens.size());
	}
}
