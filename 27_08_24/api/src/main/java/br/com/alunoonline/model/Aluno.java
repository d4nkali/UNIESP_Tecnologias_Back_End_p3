package br.com.alunoonline.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Aluno implements Serializable{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;

	private String nome;

	private String email;

	private String cpf;

}
