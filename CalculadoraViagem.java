import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Comecei Importantando todos as bibliotecas 

public class CalculadoraViagem extends JFrame {

    private JTextField distanciaField;
    private JTextField consumoField;
    private JTextField precoField;
    private JButton calcularButton;
    private JLabel resultadoLabel;

    public CalculadoraViagem() {
        // Configurar a janela
        // Configuramos o título da janela, seu tamanho, a ação de fechamento padrão
        // (encerrar o programa) e a posição inicial da janela (centralizada).
        setTitle("Calculadora de Viagem");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar os componentes
        distanciaField = new JTextField(10);
        consumoField = new JTextField(10);
        precoField = new JTextField(10);
        calcularButton = new JButton("Calcular");
        resultadoLabel = new JLabel();

        // Configurar o layout
        // Configuramos o layout da janela como uma grade de 4 linhas e 2 colunas, que
        // organiza os componentes na interface.
        setLayout(new GridLayout(4, 2));
        // Adicionamos os componentes à janela, incluindo rótulos, campos de texto, o
        // botão "Calcular" e o rótulo de resultado.
        add(new JLabel("Distância (km):"));
        add(distanciaField);
        add(new JLabel("Consumo (km/l):"));
        add(consumoField);
        add(new JLabel("Preço do combustível (R$/l):"));
        add(precoField);
        add(calcularButton);

        // Adicionar o ActionListener ao botão
        // Definimos um ActionListener para o botão "Calcular", que chama o método
        // calcularGastos() quando o botão é clicado.
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularGastos();
            }
        });

        // Adicionar o resultado
        add(resultadoLabel);

        // Exibir a janela
        setVisible(true);
    }

    private void calcularGastos() {
         // Código para calcular os gastos da viagem
        try {
            double distancia = Double.parseDouble(distanciaField.getText());
            double consumo = Double.parseDouble(consumoField.getText());
            double precoCombustivel = Double.parseDouble(precoField.getText());

            double custoTotal = (distancia / consumo) * precoCombustivel;
            resultadoLabel.setText("Custo Total: R$" + String.format("%.2f", custoTotal));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraViagem();
            }
        });
    }
}
