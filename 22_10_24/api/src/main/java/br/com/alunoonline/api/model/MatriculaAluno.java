package br.com.alunoonline.api.model;

import java.io.Serializable;

import br.com.alunoonline.api.enuns.MatriculaAlunoStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class MatriculaAluno implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;

	private Double nota1;

	private Double nota2;

	@Enumerated(EnumType.STRING)
	private MatriculaAlunoStatusEnum status;

}
