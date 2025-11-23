package com.aurellia.projeto_p2_java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aurellia.projeto_p2_java.model.Aluno;
import com.aurellia.projeto_p2_java.model.Quiz;
import com.aurellia.projeto_p2_java.model.Resposta;
import com.aurellia.projeto_p2_java.repository.AlunoRepository;
import com.aurellia.projeto_p2_java.repository.QuizRepository;
import com.aurellia.projeto_p2_java.repository.RespostaRepository;

@Service
public class QuizService {

    private final QuizRepository perguntaRepository;
    private final RespostaRepository respostaRepository;
    private final AlunoRepository alunoRepository;

    public QuizService(QuizRepository perguntaRepository,
                       RespostaRepository respostaRepository,
                       AlunoRepository alunoRepository) {
        this.perguntaRepository = perguntaRepository;
        this.respostaRepository = respostaRepository;
        this.alunoRepository = alunoRepository;
    }

    //lista todas as perguntas do Quiz
    public List<Quiz> perguntas() {
        return perguntaRepository.findAll();
    }

    //registra a resposta de um aluno para uma pergunta do quiz.
    public Resposta responder(Long alunoId, Long perguntaId, String resposta) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado: " + alunoId));

        Quiz pergunta = perguntaRepository.findById(perguntaId)
                .orElseThrow(() -> new IllegalArgumentException("Pergunta não encontrada: " + perguntaId));

        Resposta r = new Resposta(null, aluno, pergunta, resposta);
        return respostaRepository.save(r);
    }

    //busca as respostas do aluno
    public List<Resposta> respostasDoAluno(Long alunoId) {
        return respostaRepository.findByAluno_Id(alunoId);
    }
}
