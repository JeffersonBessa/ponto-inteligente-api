package br.com.bessa.jefferson.pontointeligente.api.repositories;

import static org.junit.Assert.assertEquals;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.bessa.jefferson.pontointeligente.api.entities.Empresa;
import br.com.bessa.jefferson.pontointeligente.api.entities.Funcionario;
import br.com.bessa.jefferson.pontointeligente.api.entities.Lancamento;
import br.com.bessa.jefferson.pontointeligente.api.enums.PerfilEnum;
import br.com.bessa.jefferson.pontointeligente.api.enums.TipoEnum;
import br.com.bessa.jefferson.pontointeligente.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRepositoryTest {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	private Long funcionarioId;
	
	@Before
	public void setUp() throws Exception {
		
		Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());
		
		Funcionario funcionario = this.funcionarioRepository.save(obterDadosFuncionario(empresa));
		this.funcionarioId = funcionario.getId();
		
		this.lancamentoRepository.save(obterDadosLancamentos(funcionario)); 
		this.lancamentoRepository.save(obterDadosLancamentos(funcionario));
	}
	
	@After
	public void tearDown() throws Exception {
		this.empresaRepository.deleteAll();
	}
	@Ignore
	@Test
	public void testBuscarLancamentosPorFuncionarioId() { 
		List<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId);
		assertEquals(2, lancamentos.size());
	}
	
	@Ignore
	@Test
	public void testBuscarLancamentosPorFuncionarioIdPaginado() { 
		PageRequest page = new PageRequest(0, 10);
		Page<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId, page);
		
		assertEquals(2, lancamentos.getTotalElements());
	}

	private Lancamento obterDadosLancamentos(Funcionario funcionario) {
		Lancamento lancamento = new Lancamento();
		lancamento.setData(new Date());
		lancamento.setTipo(TipoEnum.INICIO_ALMOCO);
		lancamento.setFuncionario(funcionario);
		return null;
	}

	private Funcionario obterDadosFuncionario(Empresa empresa) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Jefferson Bessa");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setSenha(PasswordUtils.gerarBCrypt("123456"));
		funcionario.setCpf("08710815473");
		funcionario.setEmail("jefferson.bessa10@gmail.com");
		funcionario.setEmpresa(empresa);
		return funcionario;
	}

	private Empresa obterDadosEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("JeffTech Tecnologia");
		empresa.setCnpj("51463645000100");
		return empresa;
	}
	

}
