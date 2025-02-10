package ifpb.edu.br.main.view;

import ifpb.edu.br.main.controller.Controlador;
import ifpb.edu.br.main.model.Disciplina;
import ifpb.edu.br.main.model.Professor;

import java.awt.*;
import javax.swing.*;
import java.util.List;

public class JanelaCalendario extends JPanel {
    private final Controlador controlador;
    private JList<String> disciplinaList;
    private JList<String> professorList;
    private final JLabel[] labelsDias;

    public JanelaCalendario(Controlador controlador) {
        this.controlador = controlador;

        InfoBloco infoBlocoCarregado = InfoBloco.carregarInfoBloco("infoBloco.dat");
        if (infoBlocoCarregado != null) {
            controlador.getBlocoAtual().setInfoBloco(infoBlocoCarregado);
        }

        this.labelsDias = new JLabel[5];
        this.disciplinaList = new JList<>();
        this.professorList = new JList<>();

        this.setLayout(new BorderLayout());

        JPanel navegacaoPanel = criarPainelDeNavegacao();
        this.add(navegacaoPanel, BorderLayout.NORTH);

        JPanel panel = criarPainelDeHorarios();
        this.add(panel, BorderLayout.CENTER);

        atualizarListDisciplinas();
        atualizarListProfessores();
        atualizarDiasDaSemana();
        atualizarBlocos();
    }

    private JPanel criarPainelDeNavegacao() {
        JPanel panel = new JPanel(new GridLayout(1, 3));

        JLabel labelSemana = new JLabel("Semana " + controlador.getCalendario().getSemanaAtual());
        panel.add(labelSemana);

        JButton buttonAnterior = new JButton("<");
        buttonAnterior.addActionListener(e -> controlador.getCalendario().proximaSemana());
        panel.add(buttonAnterior);

        JButton buttonProxima = new JButton(">");
        buttonProxima.addActionListener(e -> controlador.getCalendario().semanaAnterior());
        panel.add(buttonProxima);

        return panel;
    }

    private JPanel criarPainelDeHorarios() {
        JPanel panel = new JPanel(new GridLayout(11, 5));
        for (int i = 0; i < 5; i++) {
            labelsDias[i] = new JLabel("Dia " + i);
            panel.add(labelsDias[i]);
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 5; j++) {
                final int finalI = i;
                final int finalJ = j;

                JButton button = new JButton("Horário");
                button.addActionListener(e -> processarSelecionado(finalI, finalJ));
                panel.add(button);
            }
        }
        return panel;
    }

    private void processarSelecionado(int hora, int dia) {
        if (controlador.getInfoBloco().isOcupado(hora, dia)) {
            JOptionPane.showMessageDialog(this, "Horário já ocupado!");
        } else {
            String disciplinaSelecionada = disciplinaList.getSelectedValue();
            String professorSelecionado = professorList.getSelectedValue();

            if (disciplinaSelecionada != null && professorSelecionado != null) {
                controlador.getInfoBloco().setDisciplina(hora, dia, disciplinaSelecionada);
                controlador.getInfoBloco().setProfessor(hora, dia, professorSelecionado);
                controlador.getInfoBloco().marcarHorario(hora, dia);
                JOptionPane.showMessageDialog(this, "Horário agendado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma disciplina e um professor.");
            }
        }
        atualizarBlocos();
    }

    private void atualizarDiasDaSemana() {
        String[] dias = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta"};
        for (int i = 0; i < 5; i++) {
            labelsDias[i].setText(dias[i]);
        }
    }

    private void atualizarBlocos() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 5; j++) {
                JButton button = (JButton) getComponentAt(i + 1, j + 1);
                if (controlador.getInfoBloco().isOcupado(i, j)) {
                    button.setBackground(Color.RED);
                    button.setText("Ocupado");
                } else {
                    button.setBackground(Color.GREEN);
                    button.setText("Disponível");
                }
            }
        }
    }

    private void atualizarListDisciplinas() {
        List<Disciplina> disciplinas = controlador.getDisciplinasDoProfessorLogado();
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Disciplina disciplina : disciplinas) {
            model.addElement(disciplina.getNomeDisciplina());
        }
        disciplinaList.setModel(model);
    }

    private void atualizarListProfessores() {
        List<Professor> professores = controlador.getProfessores();
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Professor professor : professores) {
            model.addElement(professor.getNome());
        }
        professorList.setModel(model);
    }
}