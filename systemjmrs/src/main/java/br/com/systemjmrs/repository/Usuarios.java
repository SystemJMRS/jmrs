package br.com.systemjmrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.systemjmrs.entity.Usuario;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Long> {

	@PostMapping("/Cadastrar")
	public static String salvar(Usuario usuario){
		return "formulario-login";
		
		
	}
	
}
