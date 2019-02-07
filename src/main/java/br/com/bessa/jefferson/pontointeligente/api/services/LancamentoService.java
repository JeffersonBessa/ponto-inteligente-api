package br.com.bessa.jefferson.pontointeligente.api.services;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.bessa.jefferson.pontointeligente.api.entities.Lancamento;

public interface LancamentoService {
	
	/**
	 * Retorna uma lista paginada de lançamentos de um determinado funcionário
	 * 
	 * @param funcionarioId
	 * @param pageRequest
	 * @return Page<Lancamento>
	 */	
	Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);
	
	/**
	 * Retorna um lançamento por Id
	 * 
	 * @param id
	 * @return Optional<Lancamento>
	 */	
	Optional<Optional<Lancamento>> buscarPorId(Long id);

	
	/**
	 * Persiste um lançamento na base de dados
	 * 
	 * @param id
	 * @return lancamento
	 */	
	Lancamento persistir(Lancamento lancamento);
	
	/**
	 * Remove um lançamento da base de dados
	 * 
	 * @param id
	 */	
	void remover(Long id);
	
	
}
