package com.aurellia.projeto_p2_java.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.aurellia.projeto_p2_java.model.Aluno;
import com.aurellia.projeto_p2_java.model.AlunoDTO;
import com.aurellia.projeto_p2_java.model.Turma;
import com.aurellia.projeto_p2_java.service.AlunoService;
import com.aurellia.projeto_p2_java.service.TurmaService;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin
public class AlunoController {

    private final AlunoService alunoService;
    private final TurmaService turmaService;

    public AlunoController(AlunoService alunoService, TurmaService turmaService) {
        this.alunoService = alunoService;
        this.turmaService = turmaService;
    }

    // GET /api/alunos -> lista todos
    @GetMapping
    public List<Aluno> listar() {
        return alunoService.listarTodos();
    }

    // POST /api/alunos -> cadastra aluno usando turmaId
    @PostMapping
    public Aluno criar(@RequestBody AlunoDTO dto) {
        Turma turma = turmaService.buscarPorId(dto.getTurmaId());

        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setTurma(turma);

        return alunoService.salvar(aluno);
    }
}
