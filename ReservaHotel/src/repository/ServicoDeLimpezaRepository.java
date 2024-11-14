package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.ServicoDeLimpeza;
import java.util.List;

public class ServicoDeLimpezaRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotelPU");

    public ServicoDeLimpeza salvar(ServicoDeLimpeza servico) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(servico);
        em.getTransaction().commit();
        em.close();
        return servico;
    }

    public List<ServicoDeLimpeza> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<ServicoDeLimpeza> servicos = em.createQuery("SELECT s FROM ServicoDeLimpeza s", ServicoDeLimpeza.class).getResultList();
        em.close();
        return servicos;
    }

    public ServicoDeLimpeza buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        ServicoDeLimpeza servico = em.find(ServicoDeLimpeza.class, id);
        em.close();
        return servico;
    }

    public void atualizar(ServicoDeLimpeza servico) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(servico);
        em.getTransaction().commit();
        em.close();
    }

    public void deletar(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ServicoDeLimpeza servico = em.find(ServicoDeLimpeza.class, id);
        if (servico != null) {
            em.remove(servico);
        }
        em.getTransaction().commit();
        em.close();
    }
}
