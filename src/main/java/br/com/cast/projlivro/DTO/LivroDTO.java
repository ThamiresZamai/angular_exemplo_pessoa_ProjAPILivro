package br.com.cast.projlivro.DTO;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LivroDTO {

	
	private Integer id;
	@NotBlank(message="Campo em branco!")
	private String titulo;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPublicacao;
	private AutorDTO autordto;
	private CategoriaDTO categoriadto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public AutorDTO getAutordto() {
		return autordto;
	}
	public void setAutordto(AutorDTO autordto) {
		this.autordto = autordto;
	}
	public CategoriaDTO getCategoriadto() {
		return categoriadto;
	}
	public void setCategoriadto(CategoriaDTO categoriadto) {
		this.categoriadto = categoriadto;
	}
	
}
