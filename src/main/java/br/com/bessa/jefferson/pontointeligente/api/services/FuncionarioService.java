package br.com.bessa.jefferson.pontointeligente.api.services;

import java.util.Optional;
import br.com.bessa.jefferson.pontointeligente.api.entities.Funcionario;

public interface FuncionarioService {
	
	/**
	 * Persiste um funcionário na base de dados
	 * 
	 * @param funcionario
	 * @return funcionario 
	 */	
	Funcionario persistir (Funcionario funcionario);

	/**
	 * Busca e retorna um funcionário dado um CPF
	 * 
	 * @param cpf
	 * @return Optional<Funcionario> 
	 */
	Optional<Funcionario> buscarPorCpf(String cpf);
	
	/**
	 * Busca e retorna um funcionário dado um Email
	 * 
	 * @param email
	 * @return Optional<Funcionario> 
	 */
	Optional<Funcionario> buscarPorEmail(String email);
	
	/**
	 * Busca e retorna um funcionário por ID
	 * 
	 * @param id
	 * @return Optional<Funcionario> 
	 */
	Optional<Optional<Funcionario>> buscarPorId(Long id);
}