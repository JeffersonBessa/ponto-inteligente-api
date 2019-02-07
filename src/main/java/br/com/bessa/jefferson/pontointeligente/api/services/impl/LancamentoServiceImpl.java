package br.com.bessa.jefferson.pontointeligente.api.services.impl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import br.com.bessa.jefferson.pontointeligente.api.entities.Lancamento;
import br.com.bessa.jefferson.pontointeligente.api.repositories.LancamentoRepository;
import br.com.bessa.jefferson.pontointeligente.api.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {

	private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	
	public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
		log.info("Buscando lançamentos para o funcionário Id {}", funcionarioId);
		return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
	}
	
	@Override
	public Optional<Optional<Lancamento>> buscarPorId(Long id) {
		log.info("Buscando lançamento pelo Id {}", id);
		return Optional.ofNullable(this.lancamentoRepository.findById(id));
	}

	@Override
	public Lancamento persistir(Lancamento lancamento) {
		log.info("Persistindo o lançamento: {}", lancamento);
		return this.lancamentoRepository.save(lancamento);
	}

	@Override
	public void remover(Long id) {
		log.info("Removendo o lançamento Id {}", id);
		this.lancamentoRepository.deleteById(id);
	}


}
