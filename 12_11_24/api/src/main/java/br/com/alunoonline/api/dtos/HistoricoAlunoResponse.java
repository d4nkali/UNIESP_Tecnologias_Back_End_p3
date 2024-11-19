package br.com.alunoonline.api.dtos;

import java.util.List;

import lombok.Data;


@Data
public class HistoricoAlunoResponse {

	private String nomeAluno;
	private String emailAluno;
	private String cpfAluno;

	private List<DisciplinaAlunoResponse> disciplinaAlunoResponses;

}
