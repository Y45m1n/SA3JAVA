import javax.swing.SwingUtilities;

public class AppDesconto {
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraDesconto calculadora = new CalculadoraDesconto();
            calculadora.setVisible(true);
        });
    }
}
