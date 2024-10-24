package br.com.alunoonline.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.alunoonline.api.enuns.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.service.MatriculaAlunoService;

@RestController
@RequestMapping("/matriculas-alunos")
public class MatriculaAlunoController {

	@Autowired
	MatriculaAlunoService matriculaAlunoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criarMatriculaAluno(@RequestBody MatriculaAluno matriculaAluno) {

		matriculaAluno.setStatus(MatriculaAlunoStatusEnum.MATRICULADO);
		matriculaAlunoService.criarMatriculaAluno(matriculaAluno);

	}

}
