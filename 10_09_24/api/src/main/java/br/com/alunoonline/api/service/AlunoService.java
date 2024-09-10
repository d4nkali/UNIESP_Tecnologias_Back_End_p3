package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alunoonline.api.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;

	public void criarAluno(Aluno aluno) {
		
		alunoRepository.save(aluno);
		
	}
	
}
