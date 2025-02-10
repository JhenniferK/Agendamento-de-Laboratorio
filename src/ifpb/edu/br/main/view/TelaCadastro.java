package ifpb.edu.br.main.view;

import ifpb.edu.br.main.controller.Controlador;
import ifpb.edu.br.main.model.Disciplina;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastro extends JPanel implements Serializable {
    private final Controlador controlador;
    private final List<Disciplina> disciplinas;
    private final GerenciadorDeTelas gerenciadorDeTelas;
    private JTextField textDisciplina;
    private JTextField textMatricula;
    private JTextField textNome;
    private JPasswordField textSenha;

    private static final Color COR_FUNDO = new Color(0xFFF8B8D9, true);
    private static final Color COR_BOTAO = new Color(0x9D1888);
    private static final Color COR_TEXTO = new Color(0xFFFFFF);
    private static final Font FONT_PADRAO = new Font("Arial", Font.BOLD, 15);
    private static final Color COR_TEXTO_LABEL = new Color(0x9D1888);

    public TelaCadastro(GerenciadorDeTelas gerenciadorDeTelas) {
        controlador = Controlador.getInstance();
        this.gerenciadorDeTelas = gerenciadorDeTelas;
        disciplinas = new ArrayList<>();
        configurar();
    }

    private void configurar() {
        this.setBackground(COR_FUNDO);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel labelTitulo = criarLabel("CADASTRO", FONT_PADRAO, COR_TEXTO_LABEL);
        textNome = criarTextField(20);
        textMatricula = criarTextField(20);
        textSenha = new JPasswordField(20);
        textDisciplina = new JTextField(20);

        JButton btnAdicionar = criarBotao("+");
        JButton btnCadastrar = criarBotao("Cadastrar");
        JButton btnVoltar = criarBotao("Voltar");

        c.insets = new Insets(10, 0, 10, 10);

        adicionarComponente(labelTitulo, c, 0, 0, 2, GridBagConstraints.CENTER);
        adicionarComponente(criarLabel("Nome:", FONT_PADRAO, COR_TEXTO_LABEL), c, 0, 1, 1, GridBagConstraints.LINE_START);
        adicionarComponente(textNome, c, 1, 1, 1, GridBagConstraints.LINE_START);
        adicionarComponente(criarLabel("Matrícula:", FONT_PADRAO, COR_TEXTO_LABEL), c, 0, 2, 1, GridBagConstraints.LINE_START);
        adicionarComponente(textMatricula, c, 1, 2, 1, GridBagConstraints.LINE_START);
        adicionarComponente(criarLabel("Senha:", FONT_PADRAO, COR_TEXTO_LABEL), c, 0, 3, 1, GridBagConstraints.LINE_START);
        adicionarComponente(textSenha, c, 1, 3, 1, GridBagConstraints.LINE_START);
        adicionarComponente(criarLabel("Disciplina:", FONT_PADRAO, COR_TEXTO_LABEL), c, 0, 4, 1, GridBagConstraints.LINE_START);
        adicionarComponente(textDisciplina, c, 1, 4, 1, GridBagConstraints.LINE_START);
        adicionarComponente(btnAdicionar, c, 2, 4, 1, GridBagConstraints.LINE_START);
        adicionarComponente(btnVoltar, c, 0, 5, 1, GridBagConstraints.LINE_START);
        adicionarComponente(btnCadastrar, c, 1, 5, 1, GridBagConstraints.LINE_START);

        btnAdicionar.addActionListener(e -> adicionarDisciplina());
        btnVoltar.addActionListener(e -> gerenciadorDeTelas.mostrarTela("TelaLogin"));
        btnCadastrar.addActionListener(e -> cadastrarProfessor());
    }

    private JLabel criarLabel(String texto, Font font, Color cor) {
        JLabel label = new JLabel(texto);
        label.setFont(font);
        label.setForeground(cor);
        return label;
    }

    private JTextField criarTextField(int tamanho) {
        return new JTextField(tamanho);
    }

    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setBackground(COR_BOTAO);
        botao.setForeground(COR_TEXTO);
        return botao;
    }

    private void adicionarComponente(Component componente, GridBagConstraints c, int x, int y, int gridwidth, int anchor) {
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = gridwidth;
        c.anchor = anchor;
        this.add(componente, c);
    }

    private void adicionarDisciplina() {
        String nomeDisciplina = textDisciplina.getText().trim();
        if (!nomeDisciplina.isEmpty()) {
            Disciplina disciplina = new Disciplina(nomeDisciplina);
            disciplinas.add(disciplina);
            JOptionPane.showMessageDialog(this, "Disciplina adicionada com sucesso!");
            textDisciplina.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, insira um nome para a disciplina.");
        }
    }

    private void cadastrarProfessor() {
        String nome = textNome.getText().trim();
        String matricula = textMatricula.getText().trim();
        String senha = new String(textSenha.getPassword()).trim();

        if (nome.isEmpty() || matricula.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
        } else if (disciplinas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, adicione pelo menos uma disciplina.");
        } else {
            controlador.cadastrarProfessor(nome, matricula, senha, disciplinas);
            JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
            gerenciadorDeTelas.mostrarTela("TelaLogin");
        }
    }
}