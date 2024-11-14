package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Hospede;
import services.EntityManagerFactoryProvider;

import java.util.List;

public class HospedeRepository {

    private EntityManager em;

    public HospedeRepository() {
        this.em = EntityManagerFactoryProvider.getEntityManagerFactory().createEntityManager();
    }

    public void salvar(Hospede hospede) {
        try {
            em.getTransaction().begin();
            em.persist(hospede);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Hospede buscarPorId(Long id) {
        return em.find(Hospede.class, id);
    }

    public List<Hospede> listarTodos() {
        TypedQuery<Hospede> query = em.createQuery("SELECT h FROM Hospede h", Hospede.class);
        return query.getResultList();
    }

    public void atualizar(Hospede hospede) {
        try {
            em.getTransaction().begin();
            em.merge(hospede);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deletar(Long id) {
        try {
            em.getTransaction().begin();
            Hospede hospede = em.find(Hospede.class, id);
            if (hospede != null) {
                em.remove(hospede);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
