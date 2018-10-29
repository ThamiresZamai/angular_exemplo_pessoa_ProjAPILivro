package br.com.cast.projlivro.DTO;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

	private Integer id;
	@NotBlank(message="Campo em branco!")
	private String descricao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}