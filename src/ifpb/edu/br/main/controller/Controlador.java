package ifpb.edu.br.main.controller;

import ifpb.edu.br.main.dao.Serializador;
import ifpb.edu.br.main.model.Disciplina;
import ifpb.edu.br.main.model.Professor;
import ifpb.edu.br.main.view.BlocoDeHorario;
import ifpb.edu.br.main.view.CalendarioSemanal;
import ifpb.edu.br.main.view.InfoBloco;

import java.io.Serializable;
import java.util.List;

public class Controlador implements Serializable {
    private static final long serialVersionUID = 1L;
    private static Controlador instancia;

    private final ProfessorController professorController;
    private final DisciplinaController disciplinaController;
    private Dados dados;
    private final Serializador serializador;
    private Professor usuarioLogado;
    private CalendarioSemanal calendario;
    private InfoBloco infoBloco;

    private Controlador() {
        this.dados = new Dados();
        this.serializador = new Serializador();
        this.professorController = new ProfessorController(dados, serializador);
        this.disciplinaController = new DisciplinaController(dados, serializador);
        this.calendario = new CalendarioSemanal();
    }

    public static Controlador getInstance() {
        if (instancia == null) {
            synchronized (Controlador.class) {
                if (instancia == null) {
                    instancia = new Controlador();
                }
            }
        }
        return instancia;
    }

    public void cadastrarProfessor(String nome, String matricula, String senha, List<Disciplina> disciplinas) {
        Professor professor = new Professor(nome, matricula, senha, disciplinas);
        professorController.addProfessor(professor);
        serializador.salvar();
    }

    public boolean validarLogin(String matricula, String senha) {
        return professorController.validarLogin(matricula, senha);
    }

    public boolean matriculaExistente(String matricula) {
        return professorController.matriculaExistente(matricula);
    }

    public Professor getUsuarioLogado() { return usuarioLogado; }
    public void setUsuarioLogado(Professor professor) { this.usuarioLogado = professor; }

    public List<Disciplina> getDisciplinas() { return disciplinaController.getDisciplinas(); }
    public List<Disciplina> getDisciplinasDoProfessorLogado() {
        return getUsuarioLogado().getDisciplinas();
    }

    public void addDisciplina(Disciplina d) { disciplinaController.addDisciplina(d); }
    public void setDisciplinas(List<Disciplina> disciplinas) {
        disciplinaController.setDisciplinas(disciplinas);
    }

    public CalendarioSemanal getCalendario() { return calendario; }
    public void setCalendario(CalendarioSemanal calendario) {
        this.calendario = calendario;
        serializador.salvar();
    }

    public BlocoDeHorario getBlocoAtual() {
        if (calendario == null) {
            System.out.println("Calendário não inicializado.");
            return null;
        }
        return calendario.getBlocoAtual();
    }

    public void inicializarInfoBloco() {
        if (infoBloco == null) {
            infoBloco = new InfoBloco();
        }
    }

    public InfoBloco getInfoBloco() { return infoBloco; }

    public void setInfoBloco(InfoBloco infoBloco) {
        this.infoBloco = infoBloco;
        serializador.salvar();
    }

    public List<Professor> getProfessores() {
        return professorController.getProfessores(); // Certifique-se de que esse método existe na classe ProfessorController
    }
}