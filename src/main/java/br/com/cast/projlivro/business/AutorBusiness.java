package br.com.cast.projlivro.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.projlivro.DTO.AutorDTO;
import br.com.cast.projlivro.entidade.Autor;
import br.com.cast.projlivro.persistencia.AutorDAO;

@Service
public class AutorBusiness {
	
	@Autowired
	private AutorDAO autordao;
	

	public Autor buscarPOrId(Integer id) {
		return autordao.buscarPOrId(id);
	}
	
	@Transactional
	public List<AutorDTO> buscarTodos() {
		List<AutorDTO> lstautordto = autordao.buscarTodos();
		return lstautordto;
	}

}