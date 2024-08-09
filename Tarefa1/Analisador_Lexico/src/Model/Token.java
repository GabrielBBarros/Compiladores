package Model;

public class Token {
	public Tipo type;
	public String valor;
	
	
	public Token() {
		
	}
	
	public Token(Tipo type, String valor) {
		this.type = type;
		this.valor = valor;
	}

	public Tipo getType() {
		return type;
	}

	public void setType(Tipo type) {
		this.type = type;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Token [tipo = " + type + "| valor = " + valor + "]";
	}
	
	
	
	
}
