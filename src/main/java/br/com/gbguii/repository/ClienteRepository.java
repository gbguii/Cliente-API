package br.com.gbguii.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gbguii.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
