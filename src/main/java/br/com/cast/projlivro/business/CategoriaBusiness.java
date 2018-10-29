package br.com.cast.projlivro.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.projlivro.DTO.CategoriaDTO;
import br.com.cast.projlivro.entidade.Categoria;
import br.com.cast.projlivro.persistencia.CategoriaDAO;

@Service
public class CategoriaBusiness {
	
	@Autowired
	private CategoriaDAO categoriadao;
	
	
	@Transactional
	public List<CategoriaDTO> buscarTodos() {
		List<CategoriaDTO> lstcategoriadto = categoriadao.buscarTodos();
		return lstcategoriadto;
	}
	
	public Categoria buscarPOrId(Integer id) {
		return categoriadao.buscarPOrId(id);
	}

}
