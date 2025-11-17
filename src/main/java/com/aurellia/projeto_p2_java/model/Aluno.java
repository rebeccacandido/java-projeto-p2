package com.aurellia.projeto_p2_java.model;

import jakarta.persistence.*;

@Entity
public class Aluno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne(optional = false)
    private Turma turma;

    public Aluno() {}
    public Aluno(Long id, String nome, Turma turma) {
        this.id = id; this.nome = nome; this.turma = turma;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Turma getTurma() { return turma; }
    public void setTurma(Turma turma) { this.turma = turma; }
}

