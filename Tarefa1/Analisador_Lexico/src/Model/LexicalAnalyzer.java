package Model;

public class LexicalAnalyzer {
    private String input;
    private char current;
    private int position = 0;

    public LexicalAnalyzer(String input) {
        setInput(input);
    }

    public void setInput(String input) {
        this.input = input;
        this.position = 0;
        this.current = input.isEmpty() ? '\0' : input.charAt(position);
    }

    public void advance() {
        position++;
        if (position >= input.length()) {
            current = '\0';
        } else {
            current = input.charAt(position);
        }
    }

    public void space() {
        while (current != '\0' && Character.isWhitespace(current)) {
            advance();
        }
    }

    public String number() {
        StringBuilder result = new StringBuilder();
        while (current != '\0' && (Character.isDigit(current) || current == '.')) {
            result.append(current);
            advance();
        }
        return result.toString();
    }

    public Token proxT() {
        while (current != '\0') {
            if (Character.isWhitespace(current)) {
                space();
                continue;
            }
            if (Character.isDigit(current)) {
                return new Token(Type.NUMBER, number());
            }
            if (current == '+') {
                advance();
                return new Token(Type.PLUS, " + ");
            }
            if (current == '-') {
                advance();
                return new Token(Type.MINUS, " - ");
            }
            if (current == '*') {
                advance();
                return new Token(Type.MUL, " * ");
            }
            if (current == '/') {
                advance();
                return new Token(Type.DIV, " / ");
            }
            if (current == '(') {
                advance();
                return new Token(Type.OPEN_PARENTHESES, " ( ");
            }
            if (current == ')') {
                advance();
                return new Token(Type.CLOSE_PARENTHESES, " ) ");
            }
            throw new RuntimeException("Unexpected character: " + current);
        }
        return new Token(Type.EOF, "");
    }
}
