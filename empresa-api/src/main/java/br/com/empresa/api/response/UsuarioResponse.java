package br.com.empresa.api.response;

import java.io.Serializable;

import br.com.empresa.api.enuns.Role;
import br.com.empresa.api.enuns.Sexo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private Integer idade;

	private Sexo sexo;

	private Role role;

}
