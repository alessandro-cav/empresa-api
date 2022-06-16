package br.com.empresa.api.enuns;

public enum Sexo {

	MASCULINO("MASCULINO"), FEMININO("FEMININO");
	
	private String descricao;
	
	public static Sexo getSexo(String nome) {
		Sexo sexo2 = null;
		for (Sexo sexo : Sexo.values()) {
			if (sexo.getDescricao().equals(nome.toUpperCase())) {
				sexo2 = sexo;
			}
		}
		return sexo2;
	}	
	
	private Sexo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
