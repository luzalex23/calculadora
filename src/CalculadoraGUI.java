import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI {
    private JFrame frame;
    private JTextField display;
    private double resultado;
    private double numeroEmEspera;
    private ICalculator operacao;

    private boolean novoNumero = true;
    private boolean novaOperacao = true;

    public CalculadoraGUI() {
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        operacao = new Adicao();

        String[] buttonLabels = {
            "CE", "C", "X", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "=", " "
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String command = source.getText();

            if ("0123456789.".contains(command)) {
                if (novoNumero) {
                    display.setText(command);
                    novoNumero = false;
                } else {
                    display.setText(display.getText() + command);
                }
            } else if ("+-*/".contains(command)) {
                if (!novaOperacao) {
                    double num2 = Double.parseDouble(display.getText());
                    resultado = operacao.calcular(resultado, num2);
                    display.setText(Double.toString(resultado));
                    display.setText("");
                }

                if (command.equals("+")) {
                    operacao = new Adicao();
                } else if (command.equals("-")) {
                    operacao = new Subtracao();
                } else if (command.equals("*")) {
                    operacao = new Multiplicacao();
                } else if (command.equals("/")) {
                    operacao = new Divisao();
                }

                novaOperacao = true;
            } else if (command.equals("=")) {
                if (!novaOperacao) {
                    double num2 = Double.parseDouble(display.getText());
                    resultado = operacao.calcular(resultado, num2);
                    display.setText(Double.toString(resultado));
                    novoNumero = true;
                }
            } else if (command.equals("CE")) {
                resultado = 0;
                display.setText("");
                novoNumero = true;
                novaOperacao = true;
            } else if (command.equals("C")) {
                display.setText("");
                novoNumero = true;
                novaOperacao = true;
            } else if (command.equals("X")) {
                String currentText = display.getText();
                if (!currentText.isEmpty()) {
                    display.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraGUI();
            }
        });
    }
}
