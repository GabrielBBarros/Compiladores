package Model;

public class Analisador_Lexico {
    private String input;
    private char atual;
    private int posicao = 0;

    public Analisador_Lexico(String input) {
        setInput(input);
    }

    public void setInput(String input) {
        this.input = input;
        this.posicao = 0;
        this.atual = input.isEmpty() ? '\0' : input.charAt(posicao);
    }

    public void avancar() {
        posicao++;
        if (posicao >= input.length()) {
            atual = '\0';
        } else {
            atual = input.charAt(posicao);
        }
    }

    public void espaco() {
        while (atual != '\0' && Character.isWhitespace(atual)) {
            avancar();
        }
    }

    public String numero() {
        StringBuilder result = new StringBuilder();
        while (atual != '\0' && (Character.isDigit(atual) || atual == '.')) {
            result.append(atual);
            avancar();
        }
        return result.toString();
    }

    public Token proxT() {
        while (atual != '\0') {
            if (Character.isWhitespace(atual)) {
                espaco();
                continue;
            }
            if (Character.isDigit(atual)) {
                return new Token(Tipo.NUMERO, numero());
            }
            if (atual == '+') {
                avancar();
                return new Token(Tipo.MAIS, " + ");
            }
            if (atual == '-') {
                avancar();
                return new Token(Tipo.MENOS, " - ");
            }
            if (atual == '*') {
                avancar();
                return new Token(Tipo.MULTIPLICACAO, " * ");
            }
            if (atual == '/') {
                avancar();
                return new Token(Tipo.DIVISAO, " / ");
            }
            if (atual == '(') {
                avancar();
                return new Token(Tipo.ABRE_PARENTESES, " ( ");
            }
            if (atual == ')') {
                avancar();
                return new Token(Tipo.FECHA_PARENTESES, " ) ");
            }
            throw new RuntimeException("Caracter inesperado: " + atual);
        }
        return new Token(Tipo.EOF, "");
    }
}
