package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Quarto;
import services.EntityManagerFactoryProvider;

import java.util.List;

public class QuartoRepository {

    private EntityManager em;

    public QuartoRepository() {
        this.em = EntityManagerFactoryProvider.getEntityManagerFactory().createEntityManager();
    }

    public void salvar(Quarto quarto) {
        try {
            em.getTransaction().begin();
            em.persist(quarto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Quarto buscarPorId(Long id) {
        return em.find(Quarto.class, id);
    }

    public List<Quarto> listarTodos() {
        TypedQuery<Quarto> query = em.createQuery("SELECT q FROM Quarto q", Quarto.class);
        return query.getResultList();
    }

    public void atualizar(Quarto quarto) {
        try {
            em.getTransaction().begin();
            em.merge(quarto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deletar(Long id) {
        try {
            em.getTransaction().begin();
            Quarto quarto = em.find(Quarto.class, id);
            if (quarto != null) {
                em.remove(quarto);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
