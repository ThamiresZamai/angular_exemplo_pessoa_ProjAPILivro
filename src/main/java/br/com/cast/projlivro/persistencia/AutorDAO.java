package br.com.cast.projlivro.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cast.projlivro.DTO.AutorDTO;
import br.com.cast.projlivro.entidade.Autor;

@Repository
public class AutorDAO {

	@PersistenceContext
	private EntityManager em;


	public Autor buscarPOrId(Integer id) {
		return em.find(Autor.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<AutorDTO> buscarTodos() {
		List<AutorDTO> lstautor = em.createQuery("Select a from " + Autor.class.getName() + " a ").getResultList();
		return lstautor;
	}
}
