package br.com.gbguii.controller;


import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.gbguii.model.Cliente;
import br.com.gbguii.repository.ClienteRepository;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> getClientes(){
		return clienteRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Cliente getClientePorId(@PathVariable("id") Long id) {
		return clienteRepository.findById(id).
				orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente addCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PatchMapping("/{id}")
	public Cliente updateCliente(@RequestBody Cliente newCliente ,@PathVariable("id") Long id) {
		Cliente existCliente = clienteRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
		newCliente.setId(id);
		this.copyProperties(newCliente, existCliente);
		return clienteRepository.save(existCliente);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable("id") Long id) {
		Cliente toDelete = clienteRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
		clienteRepository.delete(toDelete);
	}
	
	
	private void copyProperties(Cliente newCliente, Cliente existCliente) {
		if(newCliente.getNome() != null) {
			existCliente.setNome(newCliente.getNome());
		}
		if(newCliente.getNascimento() != null) {
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(newCliente.getNascimento().getTime());
			existCliente.setNascimento(newCliente.getNascimento());
		}
		if(newCliente.getCpf() != null) {
			existCliente.setCpf(newCliente.getCpf());
		}
		if(newCliente.getRua() != null) {
			existCliente.setRua(newCliente.getRua());
		}
		if(newCliente.getNumero() != null) {
			existCliente.setNumero(newCliente.getNumero());
		}
		if(newCliente.getCidade() != null) {
			existCliente.setCidade(newCliente.getCidade());
		}
		if(newCliente.getEstado() != null) {
			existCliente.setEstado(newCliente.getEstado());
		}
		if(newCliente.getCep() != null) {
			existCliente.setCep(newCliente.getCep());
		}
		if(newCliente.getTelefone() != null) {
			existCliente.setTelefone(newCliente.getTelefone());
		}
		if(newCliente.getEmail() != null) {
			existCliente.setEmail(newCliente.getEmail());
		}
	}
	
}
