package com.aurellia.projeto_p2_java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurellia.projeto_p2_java.model.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {

    // busca todas as respostas de um aluno pelo id do aluno (Aluno.id)
    List<Resposta> findByAluno_Id(Long alunoId);
}
