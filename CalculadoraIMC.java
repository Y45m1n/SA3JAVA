import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraIMC extends JFrame implements ActionListener {

    private JTextField weightTextField;   // Campo de texto para inserir o peso
    private JTextField heightTextField;   // Campo de texto para inserir a altura
    private JLabel resultLabel;           // Rótulo para exibir o resultado do IMC

    public CalculadoraIMC() {
        setTitle("Calculadora IMC");       // Define o título da janela
        setSize(300, 150);                 // Define o tamanho da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE);   // Define a ação de fechamento
        setLayout(new FlowLayout());       // Define o layout da janela como FlowLayout

        JLabel weightLabel = new JLabel("Peso (kg):");        // Rótulo para o peso
        weightTextField = new JTextField(10);                 // Campo de texto para o peso

        JLabel heightLabel = new JLabel("Altura (cm):");       // Rótulo para a altura
        heightTextField = new JTextField(10);                 // Campo de texto para a altura

        JButton calculateButton = new JButton("Calcular");    // Botão para calcular o IMC
        calculateButton.addActionListener(this);               // Adiciona ouvinte de eventos

        resultLabel = new JLabel("Resultado: ");              // Rótulo para exibir o resultado

        JPanel panel = new JPanel();                            // Cria um painel para organizar os componentes
        panel.setLayout(new GridLayout(3, 2));                 // Define um layout de grade para o painel
        panel.add(weightLabel);
        panel.add(weightTextField);
        panel.add(heightLabel);
        panel.add(heightTextField);
        panel.add(calculateButton);
        panel.add(resultLabel);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Adiciona uma margem ao painel

        add(panel);  // Adiciona o painel à janela
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calcular")) {  // Verifica se o botão "Calcular" foi pressionado
            try {
                double weight = Double.parseDouble(weightTextField.getText()); // Obtém o peso
                double heightInCm = Double.parseDouble(heightTextField.getText()); // Obtém a altura em cm
                
                // Converte altura de centímetros para metros
                double heightInMeters = heightInCm / 100.0;

                double bmi = calculateBMI(weight, heightInMeters); // Calcula o IMC
                String result = interpretBMI(bmi); // Interpreta o resultado do IMC

                resultLabel.setText("Resultado: " + result); // Exibe o resultado na janela
            } catch (NumberFormatException ex) {
                resultLabel.setText("Por favor, insira valores válidos."); // Lida com exceções de entrada inválida
            }
        }
    }

    private double calculateBMI(double weight, double height) {
        return weight / (height * height); // Calcula o IMC
    }

    private String interpretBMI(double bmi) {
        if (bmi < 18.5) {
            return "Abaixo do peso"; // Interpretação para IMC abaixo de 18.5
        } else if (bmi < 24.9) {
            return "Peso normal";  // Interpretação para IMC entre 18.5 e 24.9
        } else if (bmi < 29.9) {
            return "Sobrepeso";    // Interpretação para IMC entre 25.0 e 29.9
        } else {
            return "Obeso";        // Interpretação para IMC igual ou acima de 30.0
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraIMC calculator = new CalculadoraIMC();
            calculator.setVisible(true); // Torna a janela visível
        });
    }
}
