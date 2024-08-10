package Model;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "3 + 5 * (10-4) / 2.5";
		LexicalAnalyzer lexical = new LexicalAnalyzer(input);
		Token token = lexical.proxT();
		while(token.getType() != Type.EOF) {
			System.out.println(token);
			token = lexical.proxT();
			
		}

	}

}
