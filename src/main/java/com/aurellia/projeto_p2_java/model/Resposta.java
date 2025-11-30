package com.aurellia.projeto_p2_java.model;

import jakarta.persistence.*;

@Entity
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Aluno aluno;

    @ManyToOne(optional = false)
    private Quiz pergunta;

    @Column(nullable = false, length = 200)
    private String resposta;

    // construtor s/ argumentos
    public Resposta() {
    }

    // construtor completo *único
    public Resposta(Long id, Aluno aluno, Quiz pergunta, String resposta) {
        this.id = id;
        this.aluno = aluno;
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Quiz getPergunta() {
        return pergunta;
    }

    public void setPergunta(Quiz pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
