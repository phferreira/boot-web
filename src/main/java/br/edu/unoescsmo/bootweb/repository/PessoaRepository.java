package br.edu.unoescsmo.bootweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.unoescsmo.bootweb.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	List<Pessoa> findByNomeLike(String nome);
	
	@Query("select p from Pessoa p where p.cpf = :cpf")
	List<Pessoa> findByCpf(String cpf);
}
