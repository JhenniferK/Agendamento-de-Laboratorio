package ifpb.edu.br.main.controller;

import ifpb.edu.br.main.model.Disciplina;
import ifpb.edu.br.main.dao.Serializador;

import java.util.List;

public class DisciplinaController {

    private Dados dados;
    private Serializador serializador;

    public DisciplinaController(Dados dados, Serializador serializador) {
        this.dados = dados;
        this.serializador = serializador;
    }

    public void addDisciplina(Disciplina disciplina) {
        dados.getDisciplinasList().add(disciplina);
        serializador.salvar();
    }

    public List<Disciplina> getDisciplinas() {
        return dados.getDisciplinasList();
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        dados.setDisciplinasList(disciplinas);
        serializador.salvar();
    }
}