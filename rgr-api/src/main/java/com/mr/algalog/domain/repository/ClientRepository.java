package com.mr.algalog.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mr.algalog.domain.model.Cliente;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, Long> {
	
	List<Cliente> findBynome(String nome);
	List<Cliente> findBynomeContaining(String nome);
	Optional<Cliente> findByEmail(String email);


}
