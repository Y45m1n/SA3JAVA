//importa as bibliotecas
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
//é uma extensão de JFrame que implementa a interface ActionListener
public class CalculadoraDesconto extends JFrame implements ActionListener {
    //cria 3 campos para texto
    private JTextField campoValorOriginal, campoPercentagemDesconto, campoValorComDesconto;
    //botão para cálculo do desconto
    private JButton botaoCalcular;

    public CalculadoraDesconto() {
         //configuracao da janela 
        setTitle("Calculadora de Desconto");//titulo
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//acao de fechar janela

        //painel para os componentes com FlowLayout (posiciona os componentes em um contêiner, como uma janela)
        JPanel painel = new JPanel(new FlowLayout());

        //cria os componentes
        JLabel rotuloValorOriginal = new JLabel("Valor Original:");//aparece isso na tela
        campoValorOriginal = new JTextField(10);// espaço para digitar o valor
        JLabel rotuloPercentagemDesconto = new JLabel("Porcentagem de Desconto:");
        campoPercentagemDesconto = new JTextField(10);
        botaoCalcular = new JButton("Calcular");
        JLabel rotuloValorComDesconto = new JLabel("Valor com Desconto:");
        campoValorComDesconto = new JTextField(10);
        campoValorComDesconto.setEditable(false); //faz o campo somente leitura

        //adiciona os componentes ao painel
        painel.add(rotuloValorOriginal);
        painel.add(campoValorOriginal);
        painel.add(rotuloPercentagemDesconto);
        painel.add(campoPercentagemDesconto);
        botaoCalcular.setPreferredSize(new Dimension(200, 30)); //ajuste da largura e altura do botão
        painel.add(botaoCalcular);
        painel.add(rotuloValorComDesconto);
        painel.add(campoValorComDesconto);

        //adiciona a acao de ouvinte ao botão, entao quando for clicado ele vai acionar e ir para a actionPerfomed
        botaoCalcular.addActionListener(this);

        //configurações da janela
        setLayout(new BorderLayout());
        add(painel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null); //centalizada
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //verifica se acao que acionou ele é igual ao botaoCalcular, se for ele executa o calcular desconto
        if (e.getSource() == botaoCalcular) {
            calcularDesconto();
        }
    }

    private void calcularDesconto() {
        try {
            //guarda o valor original da compra, desconto e transforma o valor
            double valorOriginal = Double.parseDouble(campoValorOriginal.getText());
            double percentagemDesconto = Double.parseDouble(campoPercentagemDesconto.getText());
           //ve se a % de desconto está fora do intervalo e se tiver manda uma mensagem de erro
            if (percentagemDesconto < 0 || percentagemDesconto > 100) {
                JOptionPane.showMessageDialog(this, "A porcentagem de desconto deve estar entre 0 e 100.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                //formata o valor para 2 casas
                double valorComDesconto = valorOriginal - (valorOriginal * percentagemDesconto / 100);
                DecimalFormat formato = new DecimalFormat("#0.00");
                //faz aparecer no campo valor com desconto
                campoValorComDesconto.setText(formato.format(valorComDesconto));
            }
               //aqui é a exception quando da erro na hora de formatar o valor inserido, ent aparece a mensagem para inserir os valores
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

   
}
