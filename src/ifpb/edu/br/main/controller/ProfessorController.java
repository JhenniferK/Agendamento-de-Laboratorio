package ifpb.edu.br.main.controller;

import ifpb.edu.br.main.dao.Serializador;
import ifpb.edu.br.main.model.Professor;

import java.util.List;
import java.util.Optional;

public class ProfessorController {
    private Dados dados;
    private Serializador serializador;
    private Controlador controlador;

    public ProfessorController(Dados dados, Serializador serializador) {
        this.dados = dados;
        this.serializador = serializador;
    }

    public void addProfessor(Professor p) {
        dados.getProfessoresList().add(p);
        serializador.salvar();
    }

    public List<Professor> getProfessores() {
        return dados.getProfessoresList();
    }

    public boolean matriculaExistente(String matricula) {
        return dados.getProfessoresList().stream()
                .anyMatch(professor -> professor.getMatricula().equals(matricula));
    }

    public boolean validarLogin(String matricula, String senha) {
        Optional<Professor> resultado = dados.getProfessoresList().stream()
                .filter(p -> p.getMatricula().equals(matricula) && p.getSenha().equals(senha))
                .findFirst();

        if (resultado.isPresent()) {
            controlador.setUsuarioLogado(resultado.get());
        }
        return resultado.isPresent();
    }
}