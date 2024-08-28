package br.com.alunoonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alunoonline.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;

}
