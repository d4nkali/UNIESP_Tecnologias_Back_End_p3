package br.com.alunoonline.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.alunoonline.api.enuns.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;

@Service
public class MatriculaAlunoService {

	@Autowired
	MatriculaAlunoRepository matriculaAlunoRepository;

	public void criarMatriculaAluno(MatriculaAluno matriculaAluno) {

		matriculaAluno.setStatus(MatriculaAlunoStatusEnum.MATRICULADO);
		matriculaAlunoRepository.save(matriculaAluno);

	}

	/*
	É aqui que o aluno vai trancar sua matricula	
	*/

	public void trancarMatricula(Long matriculaAlunoId) {

		MatriculaAluno matriculaAluno = matriculaAlunoRepository.findById(matriculaAlunoId)
		.orElseThrow(() ->
		new ResponseStatusException(HttpStatus.NOT_FOUND, "Matricula Aluno não encontrada"));


		if (!MatriculaAlunoStatusEnum.MATRICULADO.equals(matriculaAluno.getStatus())) {

			// Lançar o erro se o status não for matriculado

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Só possivel trancar uma matricula com o Status Matriculado");

		}

		matriculaAluno.setStatus(MatriculaAlunoStatusEnum.TRANCADO);
		matriculaAlunoRepository.save(matriculaAluno);

	}

}
