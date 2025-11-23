package com.aurellia.projeto_p2_java.model;

import jakarta.persistence.*;

@Entity
public class Quiz {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 300)
    private String enunciado;

    @Column(nullable = false, length = 80)
    private String respostaCorreta;

    public Quiz() {}
    public Quiz(Long id, String enunciado, String respostaCorreta) {
        this.id = id; this.enunciado = enunciado; this.respostaCorreta = respostaCorreta;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEnunciado() { return enunciado; }
    public void setEnunciado(String enunciado) { this.enunciado = enunciado; }
    public String getRespostaCorreta() { return respostaCorreta; }
    public void setRespostaCorreta(String respostaCorreta) { this.respostaCorreta = respostaCorreta; }
}
