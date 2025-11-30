package com.aurellia.projeto_p2_java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aurellia.projeto_p2_java.model.Aluno;
import com.aurellia.projeto_p2_java.repository.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // GET /api/alunos
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    // POST /api/alunos
    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
}
