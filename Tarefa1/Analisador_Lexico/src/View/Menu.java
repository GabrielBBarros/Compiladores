package View;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Controlador;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;

public class Menu extends JFrame {

    private JTextField inputField;
    private JButton analyzeButton;
    private JTable tokenTable;
    private JMenuItem lexicalMenuItem;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public Menu() {
        setTitle("Analisador Léxico");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

      
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Tela de boas-vindas
        JPanel welcomePanel = new JPanel(new FlowLayout());
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        welcomePanel.add(new JLabel("Bem-vindo ao Analisador Léxico!"));

        // Tela do analisador léxico
        JPanel lexicalAnalyzerPanel = new JPanel(new BorderLayout());
        lexicalAnalyzerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Campo de entrada de texto
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel inputLabel = new JLabel("Insira a expressão:");
        inputField = new JTextField(20);
        analyzeButton = new JButton("Analisar");
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);
        inputPanel.add(analyzeButton);

        // Tabela para exibir os tokens
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Token", "Tipo"}, 0);
        tokenTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(tokenTable);

        // Adiciona o painel de entrada e a tabela ao painel do analisador léxico
        lexicalAnalyzerPanel.add(inputPanel, BorderLayout.NORTH);
        lexicalAnalyzerPanel.add(tableScrollPane, BorderLayout.CENTER);

        // Adiciona os painéis ao cardPanel
        cardPanel.add(welcomePanel, "Welcome");
        cardPanel.add(lexicalAnalyzerPanel, "LexicalAnalyzer");

        // Adiciona o cardPanel ao JFrame
        add(cardPanel, BorderLayout.CENTER);

        // Cria a barra de menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu optionsMenu = new JMenu("Opções");
        menuBar.add(optionsMenu);

        lexicalMenuItem = new JMenuItem("Analisador Léxico");
        optionsMenu.add(lexicalMenuItem);

        cardLayout.show(cardPanel, "Welcome");
    }

    public JTextField getInputField() {
        return inputField;
    }

    public JButton getAnalyzeButton() {
        return analyzeButton;
    }

    public JMenuItem getLexicalMenuItem() {
        return lexicalMenuItem;
    }

    public void showLexicalAnalyzer() {
        cardLayout.show(cardPanel, "LexicalAnalyzer");
    }

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tokenTable.getModel();
        model.setRowCount(0); // Limpa todas as linhas da tabela
    }

    public void addTokenToTable(String value, String type) {
        DefaultTableModel model = (DefaultTableModel) tokenTable.getModel();
        model.addRow(new Object[]{value, type});
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setVisible(true);

        Controlador controlador = new Controlador(menu);
    }
}
