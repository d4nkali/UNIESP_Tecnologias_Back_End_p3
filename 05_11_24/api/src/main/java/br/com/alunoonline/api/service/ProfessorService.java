package br.com.alunoonline.api.service;

import java.util.List;
import java.util.Optional;

import br.com.alunoonline.api.model.Professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.alunoonline.api.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository professorRepository;

	public void criarProfessor(Professor professor) {

		professorRepository.save(professor);

	}

		public List<Professor> listarTodosProfessor() {

		return professorRepository.findAll();

	}

	public Optional<Professor> buscarProfessorPorId(Long id) {

		return professorRepository.findById(id);

	}

	public void deletarProfessorPorId(Long id) {

		professorRepository.deleteById(id);

	}

		public void atualizarProfessorPorID(Long id, Professor professor) {

		//* Verificar se existe no Banco de Dados
		Optional<Professor> professorDoBancoDeDados = buscarProfessorPorId(id);

		//* Caso não exista:
		if (professorDoBancoDeDados.isEmpty()) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado no banco de dados");

		}

		//* Se chegar aqui quer dizer que existe o professor, então:

		Professor professorEditado = professorDoBancoDeDados.get();

		// Com esse professor editado de cima, faço os sets necessários para atualizar os atributos
		professorEditado.setNome(professor.getNome());
		professorEditado.setCpf(professor.getCpf());
		professorEditado.setEmail(professor.getEmail());

		// Com o professor totalmente editado acima, devolve ele atualizado ao banco de dados
		professorRepository.save(professorEditado);

	}

}
