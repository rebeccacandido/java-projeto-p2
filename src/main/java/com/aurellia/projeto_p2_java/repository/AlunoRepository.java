package com.aurellia.projeto_p2_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aurellia.projeto_p2_java.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {}