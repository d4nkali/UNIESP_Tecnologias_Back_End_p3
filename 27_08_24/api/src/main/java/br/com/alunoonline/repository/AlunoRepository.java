package br.com.alunoonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alunoonline.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long>{

}
