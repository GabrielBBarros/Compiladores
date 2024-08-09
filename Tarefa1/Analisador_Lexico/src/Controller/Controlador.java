package Controller;

import Model.Analisador_Lexico;
import Model.Token;
import Model.Tipo;
import View.Menu;

import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {
    private Menu view;
    private Analisador_Lexico modelo;

    public Controlador(Menu view) {
        this.view = view;
        this.modelo = new Analisador_Lexico("");
        initListeners();
    }

    private void initListeners() {
        view.getLexicalMenuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.showLexicalAnalyzer();
            }
        });

        view.getAnalyzeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processInput();
            }
        });
    }

    private void processInput() {
        // Obt�m a entrada do usu�rio da vis�o
        String input = view.getInputField().getText();
        modelo.setInput(input);

        // Atualiza a tabela na thread de eventos da GUI
        SwingUtilities.invokeLater(() -> {
            view.clearTable();

            Token token;
            while ((token = modelo.proxT()).getType() != Tipo.EOF) {
                view.addTokenToTable(token.getValor(), token.getType().toString());
            }
        });
    }
}
