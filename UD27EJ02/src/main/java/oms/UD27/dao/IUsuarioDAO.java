package oms.UD27.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import oms.UD27.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
}