package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.ServicoDeQuarto;
import java.util.List;

public class ServicoDeQuartoRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotelPU");

    public ServicoDeQuarto salvar(ServicoDeQuarto servico) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(servico);
        em.getTransaction().commit();
        em.close();
        return servico;
    }

    public List<ServicoDeQuarto> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<ServicoDeQuarto> servicos = em.createQuery("SELECT s FROM ServicoDeQuarto s", ServicoDeQuarto.class).getResultList();
        em.close();
        return servicos;
    }

    public ServicoDeQuarto buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        ServicoDeQuarto servico = em.find(ServicoDeQuarto.class, id);
        em.close();
        return servico;
    }

    public void atualizar(ServicoDeQuarto servico) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(servico);
        em.getTransaction().commit();
        em.close();
    }

    public void deletar(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ServicoDeQuarto servico = em.find(ServicoDeQuarto.class, id);
        if (servico != null) {
            em.remove(servico);
        }
        em.getTransaction().commit();
        em.close();
    }
}
