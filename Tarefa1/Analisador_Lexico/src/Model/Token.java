package Model;

public class Token {
	public Type type;
	public String value;
	
	
	public Token() {
		
	}
	
	public Token(Tipo type, String value) {
		this.type = type;
		this.value = value;
	}

	public Type getType() {
		return type;
	}

	public void setType(Tipo type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Token [tipo = " + type + "| valor = " + value + "]";
	}
	
	
	
	
}
