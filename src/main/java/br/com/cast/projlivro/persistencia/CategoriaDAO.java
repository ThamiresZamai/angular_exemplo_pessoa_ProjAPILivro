package br.com.cast.projlivro.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cast.projlivro.DTO.CategoriaDTO;
import br.com.cast.projlivro.entidade.Categoria;

@Repository
public class CategoriaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public Categoria buscarPOrId(Integer id) {
		return em.find(Categoria.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<CategoriaDTO> buscarTodos() {
		List<CategoriaDTO> lstautor = em.createQuery("Select c from " + Categoria.class.getName() + " c ").getResultList();
		return lstautor;
	}

}

