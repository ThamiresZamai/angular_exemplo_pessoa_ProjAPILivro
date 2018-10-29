package br.com.cast.projlivro.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.projlivro.DTO.AutorDTO;
import br.com.cast.projlivro.DTO.CategoriaDTO;
import br.com.cast.projlivro.DTO.LivroDTO;
import br.com.cast.projlivro.entidade.Autor;
import br.com.cast.projlivro.entidade.Categoria;
import br.com.cast.projlivro.entidade.Livro;
import br.com.cast.projlivro.persistencia.AutorDAO;
import br.com.cast.projlivro.persistencia.CategoriaDAO;
import br.com.cast.projlivro.persistencia.LivroDAO;

@Service
public class LivroBusiness {

	@Autowired
	public LivroDAO livrodao;
	@Autowired
	public CategoriaDAO categoriadao;
	@Autowired
	public AutorDAO autordao;
	
	
	@Transactional
	public void salvar(LivroDTO livrodto) {
		Categoria categoria = categoriadao.buscarPOrId(livrodto.getCategoriadto().getId());
		Autor autor = autordao.buscarPOrId(livrodto.getAutordto().getId());
		
		Livro livro = new Livro();
		livro.setId(livrodto.getId());
		livro.setTitulo(livrodto.getTitulo());
		livro.setDataPublicacao(livrodto.getDataPublicacao());
		livro.setAutor(autor);
		livro.setCategoria(categoria);
		
		if(livro.getId() != null) {
			livrodao.alterar(livro);
		}else {
			livrodao.inserir(livro);
		}
		
		
	}
	
	public LivroDTO buscarPorId(Integer id) {
		Livro livro = livrodao.buscarPorId(id);
		
		LivroDTO livrodto = new LivroDTO();
		livrodto.setId(livro.getId());
		livrodto.setTitulo(livro.getTitulo());
		livrodto.setDataPublicacao(livro.getDataPublicacao());
		
		Categoria categoria = livro.getCategoria();
		if(categoria != null) {
			CategoriaDTO categoriadto = new CategoriaDTO();
			categoriadto.setId(categoria.getId());
			categoriadto.setDescricao(categoria.getDescricao());
			livrodto.setCategoriadto(categoriadto);
		}
		Autor autor = livro.getAutor();
		if(autor != null) {
			AutorDTO autordto = new AutorDTO();
			autordto.setId(autor.getId());
			autordto.setNome(autor.getNome());
			autordto.setPseudonimo(autor.getPseudonimo());
			livrodto.setAutordto(autordto);
		}
		return livrodto;
	}
	
	@Transactional
	public void excluir(Integer id) {
		Livro livro = livrodao.buscarPorId(id);
		livrodao.excluir(livro);
	}
	
	@Transactional
	public List<LivroDTO> buscarTodos() {
		
		List<Livro> livros = livrodao.buscarTodos();
		List<LivroDTO> livrosdto = new ArrayList<>();
		
		for (Livro livro : livros) {
			LivroDTO livrodto = new LivroDTO();
			livrodto.setId(livro.getId());
			livrodto.setTitulo(livro.getTitulo());
			livrodto.setDataPublicacao(livro.getDataPublicacao());
			
			Categoria categoria = livro.getCategoria();
			if(categoria != null) {
				CategoriaDTO categoriadto = new CategoriaDTO();
				categoriadto.setId(categoria.getId());
				categoriadto.setDescricao(categoria.getDescricao());
				
				livrodto.setCategoriadto(categoriadto);
			}
			
			Autor autor = livro.getAutor();
			if(autor != null) {
				AutorDTO autordto = new AutorDTO();
				autordto.setId(autor.getId());
				autordto.setNome(autor.getNome());
				autordto.setPseudonimo(autor.getPseudonimo());
				livrodto.setAutordto(autordto);
			}
			
			livrosdto.add(livrodto);
		}
		return livrosdto;
	}
}

