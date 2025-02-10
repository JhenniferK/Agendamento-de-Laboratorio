package ifpb.edu.br.main.view;

import ifpb.edu.br.main.controller.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class TelaLogin extends JPanel implements Serializable {
    private final Controlador controlador;
    private final GerenciadorDeTelas gerenciadorDeTelas;
    private JTextField textMatricula;
    private JPasswordField textSenha;
    private JButton btnEntrar;
    private JButton btnCadastrar;

    private static final Color BUTTON_COLOR = new Color(0x9D1888);
    private static final Color TEXT_COLOR = new Color(0xFFFFFF);
    private static final Font LABEL_FONT = new Font("Arial", Font.BOLD, 15);
    private static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 24);

    public TelaLogin(GerenciadorDeTelas gerenciadorDeTelas) {
        this.gerenciadorDeTelas = gerenciadorDeTelas;
        controlador = Controlador.getInstance();
        configurar();
    }

    private void configurar() {
        this.setBackground(new Color(0xFFF8B8D9, true));
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel labelNomeSistema = createLabel("<html><center>Reservas de Horário<br>para Uso de Laboratório</center></html>", TITLE_FONT, new Color(0x9D1888));
        JLabel labelTitulo = createLabel("LOGIN", LABEL_FONT);
        JLabel labelMatricula = createLabel("Matrícula:", LABEL_FONT);
        JLabel labelSenha = createLabel("Senha:", LABEL_FONT);

        textMatricula = new JTextField(20);
        textSenha = new JPasswordField(20);

        btnEntrar = createButton("Entrar");
        btnCadastrar = createButton("Cadastrar");

        c.insets = new Insets(10, 0, 10, 10);

        addComponent(labelNomeSistema, 0, 0, 2, c, GridBagConstraints.CENTER);
        addComponent(labelTitulo, 0, 1, 2, c, GridBagConstraints.CENTER);
        addComponent(labelMatricula, 0, 2, 1, c, GridBagConstraints.LINE_END);
        addComponent(textMatricula, 1, 2, 1, c, GridBagConstraints.LINE_START);
        addComponent(labelSenha, 0, 3, 1, c, GridBagConstraints.LINE_END);
        addComponent(textSenha, 1, 3, 1, c, GridBagConstraints.LINE_START);
        addComponent(btnEntrar, 1, 4, 1, c, GridBagConstraints.LINE_END);
        addComponent(btnCadastrar, 0, 4, 1, c, GridBagConstraints.LINE_END);

        btnEntrar.addActionListener(e -> {
            String matricula = textMatricula.getText().trim();
            String senha = new String(textSenha.getPassword()).trim();
            if (validarLogin(matricula, senha)) {
                JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
                gerenciadorDeTelas.mostrarTela("TelaPrincipal");
            }
        });

        btnCadastrar.addActionListener(e -> gerenciadorDeTelas.mostrarTela("TelaCadastro"));
    }

    private void addComponent(Component comp, int gridx, int gridy, int gridwidth, GridBagConstraints c, int anchor) {
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;
        c.anchor = anchor;
        this.add(comp, c);
    }

    private JLabel createLabel(String text, Font font) {
        return createLabel(text, font, Color.BLACK);
    }

    private JLabel createLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setBackground(BUTTON_COLOR);
        button.setForeground(TEXT_COLOR);
        return button;
    }

    private boolean validarLogin(String matricula, String senha) {
        if (matricula.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro de Login", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (controlador.validarLogin(matricula, senha)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Matrícula ou senha incorretos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void addCadastrarListener(ActionListener listener) {
        btnCadastrar.addActionListener(listener);
    }
}