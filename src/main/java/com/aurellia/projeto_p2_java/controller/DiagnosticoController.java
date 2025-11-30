package com.aurellia.projeto_p2_java.controller;

import org.springframework.web.bind.annotation.*;

import com.aurellia.projeto_p2_java.model.Diagnostico;
import com.aurellia.projeto_p2_java.service.DiagnosticoService;

@RestController
@RequestMapping("/api/diagnostico")
@CrossOrigin
public class DiagnosticoController {

    private final DiagnosticoService diag;

    public DiagnosticoController(DiagnosticoService diag) { this.diag = diag; }

    @GetMapping("/{alunoId}")
    public Diagnostico gerar(@PathVariable Long alunoId) {
        return diag.gerar(alunoId);
    }
}
