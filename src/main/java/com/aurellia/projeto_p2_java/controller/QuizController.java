package com.aurellia.projeto_p2_java.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.aurellia.projeto_p2_java.model.Quiz;
import com.aurellia.projeto_p2_java.service.QuizService;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin
public class QuizController {

    private final QuizService quiz;

    public QuizController(QuizService quiz) {
        this.quiz = quiz;
    }

    @GetMapping("/perguntas")
    public List<Quiz> perguntas() {
        return quiz.perguntas();
    }

    @PostMapping("/responder")
    public void responder(@RequestParam("alunoId") Long alunoId,
                          @RequestParam("perguntaId") Long perguntaId,
                          @RequestParam("resposta") String resposta) {
        quiz.responder(alunoId, perguntaId, resposta);
    }
}
