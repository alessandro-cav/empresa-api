package br.com.empresa.api.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "Nome não pode ser vazio")
	@NotNull(message = "Nome é obrigatorio")
	private String nome;

	@NotBlank(message = "Sexo não pode ser em branco")
	@NotNull(message = "Sexo é obrigatorio")
	private String sexo;

	@NotBlank(message = "Role não pode ser em branco")
	@NotNull(message = "Role é obrigatorio")
	private String role;

}
