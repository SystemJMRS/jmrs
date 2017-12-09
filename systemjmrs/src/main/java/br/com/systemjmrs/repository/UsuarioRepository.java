package br.com.systemjmrs.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.systemjmrs.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
