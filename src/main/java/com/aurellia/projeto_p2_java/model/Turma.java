package com.aurellia.projeto_p2_java.model;

import jakarta.persistence.*;

@Entity
public class Turma {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String professorNome;

    public Turma() {}
    public Turma(Long id, String nome, String professorNome) {
        this.id = id; this.nome = nome; this.professorNome = professorNome;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getProfessorNome() { return professorNome; }
    public void setProfessorNome(String professorNome) { this.professorNome = professorNome; }
}
