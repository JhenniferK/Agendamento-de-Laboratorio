package ifpb.edu.br.main.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Professor implements Serializable {
    private String matricula;
    private String nome;
    private String senha;
    private List<Disciplina> disciplinas;

    public Professor(String matricula, String nome, String senha, List<Disciplina> disciplinas) {
        this.matricula = matricula;
        this.nome = nome;
        this.senha = senha;
        this.disciplinas = disciplinas != null ? disciplinas : new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return getNome() + " " + getMatricula();
    }

    public Object getLogin() { return matricula; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return matricula.equals(professor.matricula);
    }

    @Override
    public int hashCode() {
        return matricula.hashCode();
    }
}

