package br.com.bessa.jefferson.pontointeligente.api.security.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.bessa.jefferson.pontointeligente.api.entities.Funcionario;
import br.com.bessa.jefferson.pontointeligente.api.security.JwtUserFactory;
import br.com.bessa.jefferson.pontointeligente.api.services.FuncionarioService;

@Service
public class JwtUserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Funcionario> funcionario = funcionarioService.buscarPorEmail(username);
		
		if (funcionario.isPresent()) {
			return JwtUserFactory.create(funcionario.get());
		}
		
		throw new UsernameNotFoundException("Email não encontrado.");
	}

}
