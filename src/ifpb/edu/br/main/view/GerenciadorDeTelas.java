package ifpb.edu.br.main.view;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class GerenciadorDeTelas extends JFrame implements Serializable {
    private TelaPrincipal telaPrincipal;
    private final JPanel painelPrincipal;
    private final CardLayout cardLayout;

    public GerenciadorDeTelas() {
        cardLayout = new CardLayout();
        painelPrincipal = new JPanel(cardLayout);

        TelaLogin telaLogin = new TelaLogin(this);
        TelaCadastro telaCadastro = new TelaCadastro(this);

        painelPrincipal.add(telaLogin, "TelaLogin");
        painelPrincipal.add(telaCadastro, "TelaCadastro");

        telaLogin.addCadastrarListener(e -> cardLayout.show(painelPrincipal, "TelaCadastro"));

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(800, 600));
        this.add(painelPrincipal);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        mostrarTela("TelaLogin");
    }

    public void mostrarTela(String nomeDaTela) {
        System.out.println("Mostrando tela: " + nomeDaTela);
        if (nomeDaTela.equals("TelaPrincipal") && telaPrincipal == null) {
            telaPrincipal = new TelaPrincipal();
            painelPrincipal.add(telaPrincipal, "TelaPrincipal");
        }

        cardLayout.show(painelPrincipal, nomeDaTela);
    }

    public static void main(String[] args) { new GerenciadorDeTelas(); }
}