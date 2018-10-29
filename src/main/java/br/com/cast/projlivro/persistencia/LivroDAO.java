package br.com.cast.projlivro.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.projlivro.entidade.Livro;

@Repository
public class LivroDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void inserir(Livro livro) {
			em.persist(livro);
	}
	
	public Livro buscarPorId(Integer id) {
		return em.find(Livro.class, id);
	}
	
	public void alterar(Livro livro) {
			em.merge(livro);
	}
	
	public void excluir(Livro livro) {
			em.remove(livro);
	}
	
	@SuppressWarnings("unchecked")
	public List<Livro> buscarTodos() {
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("select l ")
			.append("from ").append(Livro.class.getName()).append(" l ")
			.append("inner join l.autor ")
			.append("inner join l.categoria");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
		
	}

}

