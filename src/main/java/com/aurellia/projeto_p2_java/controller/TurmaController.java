package com.aurellia.projeto_p2_java.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.aurellia.projeto_p2_java.model.Turma;
import com.aurellia.projeto_p2_java.service.TurmaService;

@RestController
@RequestMapping("/api/turmas")
@CrossOrigin
public class TurmaController {

    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    // GET /api/turmas -> lista todas
    @GetMapping
    public List<Turma> listar() {
        return turmaService.listarTodas();
    }

    // POST /api/turmas -> cria nova turma
    @PostMapping
    public Turma criar(@RequestBody Turma turma) {
        return turmaService.salvar(turma);
    }
}
