package br.com.alunoonline.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	DisciplinaRepository disciplinaRepository;

	public void criarDisciplina(Disciplina disciplina) {

		disciplinaRepository.save(disciplina);

	}

	public List<Disciplina> listarDisciplinasDoProf(Long professorId) {

		return disciplinaRepository.findByProfessorId(professorId);

	}

	public List<Disciplina> listarTodosDisciplinas() {

		return disciplinaRepository.findAll();

	}

	public Optional<Disciplina> buscarDisciplinaPorId(Long id) {

		return disciplinaRepository.findById(id);

	}

	public void deletarDisciplinaPorId(Long id) {

		disciplinaRepository.deleteById(id);

	}

	public void atualizarDisciplinaPorID(Long id, Disciplina disciplina) {

		//* Verificar se existe no Banco de Dados
		Optional<Disciplina> disciplinaDoBancoDeDados = buscarDisciplinaPorId(id);

		//* Caso não exista:
		if (disciplinaDoBancoDeDados.isEmpty()) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada no banco de dados");

		}

		//* Se chegar aqui quer dizer que existe a disciplina, então:

		Disciplina disciplinaEditado = disciplinaDoBancoDeDados.get();

		// Com esse professor editado de cima, faço os sets necessários para atualizar os atributos
		disciplinaEditado.setNome(disciplina.getNome());
		disciplinaEditado.setProfessor(disciplina.getProfessor());

		// Com o professor totalmente editado acima, devolve ele atualizado ao banco de dados
		disciplinaRepository.save(disciplinaEditado);

	}

}
