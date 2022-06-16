package br.com.empresa.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.api.request.UsuarioRequest;
import br.com.empresa.api.response.UsuarioResponse;
import br.com.empresa.api.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioService service;

	@PostMapping
	public ResponseEntity<UsuarioResponse> save(@Valid @RequestBody UsuarioRequest usuarioRequest) {
		return ResponseEntity.ok(this.service.save(usuarioRequest));
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponse> findById(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(this.service.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<UsuarioResponse>> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
		this.service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<UsuarioResponse> update(@PathVariable(name = "id") Long id,
			@Valid @RequestBody UsuarioRequest usuarioRequest) {
		return ResponseEntity.ok( this.service.update(id, usuarioRequest));
	}
}
