package Controller;

import Model.LexicalAnalyzer;
import Model.Token;
import Model.Type;
import View.Menu;

import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Menu view;
    private LexicalAnalyzer model;

    public Controller(Menu view) {
        this.view = view;
        this.model = new LexicalAnalyzer("");
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
        model.setInput(input);

        // Atualiza a tabela na thread de eventos da GUI
        SwingUtilities.invokeLater(() -> {
            view.clearTable();

            Token token;
            while ((token = model.proxT()).getType() != Type.EOF) {
                view.addTokenToTable(token.getValue(), token.getType().toString());
            }
        });
    }
}
