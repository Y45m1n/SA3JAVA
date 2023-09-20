//importa as bibliotecas
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//PaginaSelecao é uma extensão de JFrame que implementa a interface ActionListener (para eventos de ação, ex: selecionar calculadora)
public class PaginaSelecao extends JFrame implements ActionListener {
    //botao para selecionar a acao e declaracao da matriz com os nomes das calculadoras
    private JButton[] botoesCalculadora; 
    private String[] nomesCalculadoras = {"Calculadora IMC", "Calculadora Desconto", "Calculadora Viagem"};

    public PaginaSelecao() {
        //configuracao da janela principal
        setTitle("Seleção de Calculadora"); //titulo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //acao de fechar janela

        //cria um painel para os botões usando um layout Grid
        //hgap:espaçamento horizontal entre os botoes
        JPanel painelBotoes = new JPanel(new GridLayout(1, nomesCalculadoras.length, 10, 0));

        //cria array de botões com o mesmo comprimento que o array nomesCalculadoras
        botoesCalculadora = new JButton[nomesCalculadoras.length]; 
        //loop que corre cada elemento do array 
        for (int i = 0; i < nomesCalculadoras.length; i++) {
            //aqui cria os botoes e coloca de nome as Strings com os nomes das calculadoras
            botoesCalculadora[i] = criarBotao(nomesCalculadoras[i]);
            painelBotoes.add(botoesCalculadora[i]);
        }

        //adiciona o painel de botões à janela
        adicionarPainel(painelBotoes);  
    }

    //método para criar o botão com um determinado texto e configuracao
    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.PLAIN, 16));
        botao.addActionListener(this); //esse botao "escuta" os cliques e chama o ActionEvent para executar 
        return botao;
    }

    //método para adicionar um painel à janela e config centralizado na tela
    private void adicionarPainel(JPanel painel) {
        setLayout(new BorderLayout()); //o Border organiza os componentes em regiões
        add(painel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null); //centraliza a janela
    }

    //método que é chamado quando um botão é clicado
    @Override
    public void actionPerformed(ActionEvent e) {
        //"e" é um objeto do ActionEvent
        JButton botaoSelecionado = (JButton) e.getSource();
        String calculadoraSelecionada = botaoSelecionado.getText();

        //abre a calculadora correspondente com base no texto do botão clicado
        //se selecionar calculadora IMC vai mandar abrir a calculadora IMC
        switch (calculadoraSelecionada) {
            case "Calculadora IMC":
                abrirCalculadoraIMC();
                break;
            case "Calculadora Desconto":
                abrirCalculadoraDesconto();
                break;
            case "Calculadora Viagem":
                abrirCalculadoraViagem();
                break;
        }

        dispose(); //fecha a janela de seleção depois de abrir a calculadora
    }

    //métodos para abrir cada calculadora selecionada
    private void abrirCalculadoraIMC() {
        CalculadoraIMC calculadora = new CalculadoraIMC();
        calculadora.setSize(400, 500);//tamanho da janela da calculadora
        calculadora.setVisible(true);//torna a janela visível 
      calculadora.setLocationRelativeTo(null);//centraliza a tela ao meio
    }

    private void abrirCalculadoraDesconto() {
        CalculadoraDesconto calculadora = new CalculadoraDesconto();
        calculadora.setSize(400, 500);
        calculadora.setVisible(true);
        calculadora.setLocationRelativeTo(null);
    }

    private void abrirCalculadoraViagem() {
        CalculadoraViagem calculadora = new CalculadoraViagem();
        calculadora.setSize(400, 500);
        calculadora.setVisible(true);
        calculadora.setLocationRelativeTo(null);
        
    }
}
