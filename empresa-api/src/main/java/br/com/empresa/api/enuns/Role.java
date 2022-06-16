package br.com.empresa.api.enuns;

public enum Role {

	USER("USER"), ADMIN("ADMIN");

	private String descricao;

	public static Role getRole(String name) {
		Role role2 = null;
		for (Role role : Role.values()) {
			if (role.getDescricao().equals(name.toUpperCase())) {
				role2 = role;
			}
		}
		return role2;
	}	
	
	private Role(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
