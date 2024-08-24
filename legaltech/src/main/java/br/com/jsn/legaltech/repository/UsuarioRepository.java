package br.com.jsn.legaltech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jsn.legaltech.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
}
