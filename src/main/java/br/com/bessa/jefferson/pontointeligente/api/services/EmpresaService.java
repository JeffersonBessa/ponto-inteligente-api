package br.com.bessa.jefferson.pontointeligente.api.services;

import java.util.Optional;
import br.com.bessa.jefferson.pontointeligente.api.entities.Empresa;

public interface EmpresaService {
	
	/**
	 * Retorna uam empresa dado um CNPJ
	 * 
	 * @param cnpj
	 * @return Optional<Empresa>
	 */
	Optional<Empresa> buscarPorCnj(String cnpj);
		
	/**
	 * Cadastra uma nova empresa na base de dados
	 * 
	 * @param empresa
	 * @return Empresa
	 */
	Empresa persistir(Empresa empresa);


}
