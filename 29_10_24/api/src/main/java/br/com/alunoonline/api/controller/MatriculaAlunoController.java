package br.com.alunoonline.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

		matriculaAlunoService.criarMatriculaAluno(matriculaAluno);

	}

	@PatchMapping("/trancar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void trancarMatricula(@PathVariable Long id) {

		matriculaAlunoService.trancarMatricula(id);

	}

}
