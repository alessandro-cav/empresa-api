package br.com.empresa.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.empresa.api.entity.Usuario;
import br.com.empresa.api.enuns.Role;
import br.com.empresa.api.enuns.Sexo;
import br.com.empresa.api.handler.UsuarioNotFoundException;
import br.com.empresa.api.repository.UsuarioRepository;
import br.com.empresa.api.request.UsuarioRequest;
import br.com.empresa.api.response.UsuarioResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository repository;

	public UsuarioResponse save(UsuarioRequest usuarioRequest) {

		if (this.repository.findByNome(usuarioRequest.getNome()).isPresent()) {
			throw new UsuarioNotFoundException("Nome de usuario já sendo usado");
		}

		Usuario usuario = Usuario.builder().nome(usuarioRequest.getNome()).sexo(Sexo.getSexo(usuarioRequest.getSexo()))
				.role(Role.getRole(usuarioRequest.getRole())).build();

		usuario = this.repository.save(usuario);

		return UsuarioResponse.builder().id(usuario.getId()).nome(usuario.getNome()).sexo(usuario.getSexo())
				.role(usuario.getRole()).build();
	}

	public UsuarioResponse findById(Long id) {
		Optional<Usuario> usuario = this.repository.findById(id);

		return UsuarioResponse.builder().id(usuario.get().getId()).nome(usuario.get().getNome())
				.sexo(usuario.get().getSexo()).role(usuario.get().getRole()).build();
	}

	public List<UsuarioResponse> findAll() {
		List<Usuario> usuarios = this.repository.findAll();

		return usuarios.stream().map(usuario -> UsuarioResponse.builder().id(usuario.getId()).nome(usuario.getNome())
				.sexo(usuario.getSexo()).role(usuario.getRole()).build()).collect(Collectors.toList());
	}

	public void delete(Long id) {
		Optional<Usuario> usuario = this.repository.findById(id);
		this.repository.delete(usuario.get());
	}

	public UsuarioResponse update(Long id, UsuarioRequest usuarioRequest) {

		if (this.repository.findByNome(usuarioRequest.getNome()).isPresent()) {
			throw new UsuarioNotFoundException("Nome de usuario já sendo usado");
		}
		Optional<Usuario> usuario = this.repository.findById(id);

		usuario.get().setNome(usuarioRequest.getNome());
		usuario.get().setSexo(Sexo.getSexo(usuarioRequest.getSexo()));
		usuario.get().setRole(Role.getRole(usuarioRequest.getRole()));

		Usuario user = this.repository.saveAndFlush(usuario.get());

		return UsuarioResponse.builder().id(user.getId()).nome(user.getNome()).sexo(user.getSexo()).role(user.getRole())
				.build();
	}

}
