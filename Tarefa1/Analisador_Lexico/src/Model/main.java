package Model;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "3 + 5 * (10-4) / 2.5";
		Analisador_Lexico lexico = new Analisador_Lexico(input);
		Token token = lexico.proxT();
		while(token.getType() != Tipo.EOF) {
			System.out.println(token);
			token = lexico.proxT();
			
		}

	}

}
