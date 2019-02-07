package br.com.bessa.jefferson.pontointeligente.api.services.impl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bessa.jefferson.pontointeligente.api.entities.Empresa;
import br.com.bessa.jefferson.pontointeligente.api.repositories.EmpresaRepository;
import br.com.bessa.jefferson.pontointeligente.api.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public Optional<Empresa> buscarPorCnj(String cnpj) {
		log.info("Buscando uma nova empresa para o CNPJ {}", cnpj);
		return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
	}

	@Override
	public Empresa persistir(Empresa empresa) {
		log.info("Persistindo empresa na base de dados: {}", empresa);
		return this.empresaRepository.save(empresa);
	}

}
