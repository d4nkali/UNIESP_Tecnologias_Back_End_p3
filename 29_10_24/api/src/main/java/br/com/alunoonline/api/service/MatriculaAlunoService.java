package br.com.alunoonline.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;

@Service
public class MatriculaAlunoService {

	@Autowired
	MatriculaAlunoRepository matriculaAlunoRepository;

	public void criarMatriculaAluno(MatriculaAluno matriculaAluno) {

		matriculaAlunoRepository.save(matriculaAluno);

	}

}
