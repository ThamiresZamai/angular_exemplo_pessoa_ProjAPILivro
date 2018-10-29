package br.com.cast.projlivro.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.projlivro.DTO.AutorDTO;
import br.com.cast.projlivro.DTO.CategoriaDTO;
import br.com.cast.projlivro.DTO.LivroDTO;
import br.com.cast.projlivro.business.AutorBusiness;
import br.com.cast.projlivro.business.CategoriaBusiness;
import br.com.cast.projlivro.business.LivroBusiness;

@RestController
@RequestMapping(path = "livro")
public class LivroAPI {

	@Autowired
	private LivroBusiness livrobusiness;
	@Autowired
	private CategoriaBusiness catbusiness;
	@Autowired
	private AutorBusiness autorbusiness;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<LivroDTO> buscarTodos() {
		return livrobusiness.buscarTodos();
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void excluir(@PathVariable("id") Integer id) {
		livrobusiness.excluir(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void inserir(@RequestBody LivroDTO livrodto) {
		livrobusiness.salvar(livrodto);
	}
	
	@RequestMapping(path= "/autores", method = RequestMethod.GET)
	public List<AutorDTO> buscarTodosAutores() {
		return autorbusiness.buscarTodos();
	}
	
	@RequestMapping(path= "/categoria", method = RequestMethod.GET)
	public List<CategoriaDTO> buscarTodoscategoria() {
		return catbusiness.buscarTodos();
	}
	
	@RequestMapping(path= "/{id}", method = RequestMethod.GET)
	public LivroDTO buscarPorId(@PathVariable("id") Integer id) {
		return livrobusiness.buscarPorId(id);
	}
	
	
}
