import javax.swing.SwingUtilities;

public class AppSelecao {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaginaSelecao selecao = new PaginaSelecao();
            selecao.setVisible(true);
        });
    }
}
