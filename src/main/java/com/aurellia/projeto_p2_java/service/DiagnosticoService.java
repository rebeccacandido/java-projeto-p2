package com.aurellia.projeto_p2_java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aurellia.projeto_p2_java.model.Diagnostico;
import com.aurellia.projeto_p2_java.model.Resposta;

@Service
public class DiagnosticoService {

    private final QuizService quiz;

    public DiagnosticoService(QuizService quiz) {
        this.quiz = quiz;
    }

    public Diagnostico gerar(Long alunoId) {
        List<Resposta> respostas = quiz.respostasDoAluno(alunoId);
        int total = quiz.perguntas().size();
        int acertos = (int) respostas.stream()
                .filter(r -> r.getPergunta().getRespostaCorreta().equalsIgnoreCase(r.getResposta()))
                .count();

        double nota = (total == 0) ? 0.0 : (acertos * 1.0 / total);
        String trilha;
        if (nota >= 0.8)       trilha = "Trilha Avançada";
        else if (nota >= 0.6)  trilha = "Trilha Intermediária";
        else                   trilha = "Trilha Básica";

        return new Diagnostico(alunoId, acertos, total, trilha);
    }
}
