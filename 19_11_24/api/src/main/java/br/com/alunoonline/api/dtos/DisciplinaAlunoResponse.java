package br.com.alunoonline.api.dtos;

import br.com.alunoonline.api.enuns.MatriculaAlunoStatusEnum;
import lombok.Data;

@Data
public class DisciplinaAlunoResponse {

	private String nomeDisciplina;
	private String nomeProfessor;
	private Double nota1;
	private Double nota2;
	private MatriculaAlunoStatusEnum status;

}
