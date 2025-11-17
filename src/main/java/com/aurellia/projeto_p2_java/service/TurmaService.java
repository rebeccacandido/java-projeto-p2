package com.aurellia.projeto_p2_java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aurellia.projeto_p2_java.model.Turma;
import com.aurellia.projeto_p2_java.repository.TurmaRepository;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    // usado pelo GET /api/turmas
    public List<Turma> listarTodas() {
        return turmaRepository.findAll();
    }

    // usado pelo POST /api/turmas
    public Turma salvar(Turma turma) {
        return turmaRepository.save(turma);
    }

    // usado pelo POST /api/alunos (quando recebe turmaId)
    public Turma buscarPorId(Long id) {
        return turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada: " + id));
    }
}
