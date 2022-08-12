package br.edu.ifsp.arq.dw2s6.assistencia_informatica.resources;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.dw2s6.assistencia_informatica.domain.model.Cliente;
import br.edu.ifsp.arq.dw2s6.assistencia_informatica.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteResources {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/todos")
	public List<Cliente> listar(){
		return clienteRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente criar(@RequestBody Cliente cliente, HttpServletResponse response) {
		return clienteRepository.save(cliente); 
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Cliente> listarPeloCodigo(@PathVariable Long codigo){
		Optional<Cliente> cliente = clienteRepository.findById(codigo);
		
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Cliente> deletarPeloCodigo(@PathVariable Long codigo){
		Optional<Cliente> cliente = clienteRepository.findById(codigo);
		
		if(cliente.isPresent()) {
			clienteRepository.deleteById(codigo);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Cliente> atualizarPeloCodigo(@RequestBody Cliente cliente, HttpServletResponse response,  @PathVariable Long codigo){
		Optional<Cliente> auxCliente = clienteRepository.findById(codigo);
		
		if(auxCliente.isPresent()) {
			auxCliente.get().setEmail(cliente.getEmail());
			auxCliente.get().setNome(cliente.getNome());
			auxCliente.get().setTelefone(cliente.getTelefone());
			clienteRepository.save(auxCliente.get());
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}
