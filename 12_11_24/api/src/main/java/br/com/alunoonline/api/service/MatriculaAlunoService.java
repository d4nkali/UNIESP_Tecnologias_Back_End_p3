package br.com.alunoonline.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.alunoonline.api.dtos.AtualizarNotasRequest;
import br.com.alunoonline.api.dtos.HistoricoAlunoResponse;
import br.com.alunoonline.api.enuns.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;

@Service
public class MatriculaAlunoService {

	public static final double MEDIA_PARA_APROVACAO = 7.0;

	@Autowired
	MatriculaAlunoRepository matriculaAlunoRepository;

	public void criarMatriculaAluno(MatriculaAluno matriculaAluno) {

		matriculaAluno.setStatus(MatriculaAlunoStatusEnum.MATRICULADO);
		matriculaAlunoRepository.save(matriculaAluno);

	}

	//* É aqui que o aluno vai trancar sua matricula	
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

	public void atualizarNotas(Long matriculaAlunoId, AtualizarNotasRequest atualizarNotasRequest) {

		MatriculaAluno matriculaAluno = matriculaAlunoRepository.findById(matriculaAlunoId)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matricula Aluno não encontrada"));

		//* Verifica se o front está mandando a nota 1
		if (atualizarNotasRequest.getNota1() != null) {

			// Se sim, o 'atualizarNotasRequest.getNota1()' pega a nota 1 do front

			// Atualiza a nota 1 do Banco
			matriculaAluno.setNota1(atualizarNotasRequest.getNota1());

		}

		//* Verifica se o front está mandando a nota 2
		if (atualizarNotasRequest.getNota2() != null) {

			// Se sim, o 'atualizarNotasRequest.getNota2()' pega a nota 2 do front
		
			// Atualiza a nota 2 do Banco
			matriculaAluno.setNota2(atualizarNotasRequest.getNota2());

		}

		// Apos atualizar as notas, chama a função calcularMedia e salva no banco de dados
		calcularMedia(matriculaAluno);
		matriculaAlunoRepository.save(matriculaAluno);

	}

	private void calcularMedia(MatriculaAluno matriculaAluno) {

		Double nota1 = matriculaAluno.getNota1();
		Double nota2 = matriculaAluno.getNota2();

		if (nota1 != null && nota2 != null) {

			Double media = (nota1 + nota2) / 2;

			/*
			* Se a media for maior que a media para aprovação (?)
			* define como aprovado, senão (:) define como reprovado
			*/
			matriculaAluno.setStatus(media >= MEDIA_PARA_APROVACAO ?
			MatriculaAlunoStatusEnum.APROVADO : 
			MatriculaAlunoStatusEnum.REPROVADO);

		}

	}

	public HistoricoAlunoResponse emitirHistorico(Long alunoId) {

		List<MatriculaAluno> matriculasDoAluno = matriculaAlunoRepository.findByAlunoId(alunoId);

		if (matriculasDoAluno.isEmpty()){

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Esse aluno não possui matriculas");

		}

		return null; // Temporário

	}

}
