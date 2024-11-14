package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.Reserva;
import services.EntityManagerFactoryProvider;

import java.util.List;

public class ReservaRepository {
    private EntityManagerFactory emf;

    public ReservaRepository() {
        this.emf = EntityManagerFactoryProvider.getEntityManagerFactory();
    }

    public Reserva salvarReserva(Reserva reserva) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(reserva);
        em.getTransaction().commit();
        em.close();
        return reserva;
    }

    public Reserva buscarReservaPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Reserva reserva = em.find(Reserva.class, id);
        em.close();
        return reserva;
    }

    public List<Reserva> listarReservas() {
        EntityManager em = emf.createEntityManager();
        List<Reserva> reservas = em.createQuery("SELECT r FROM Reserva r", Reserva.class).getResultList();
        em.close();
        return reservas;
    }

    public void atualizarReserva(Reserva reserva) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(reserva);
        em.getTransaction().commit();
        em.close();
    }

    public void removerReserva(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Reserva reserva = em.find(Reserva.class, id);
        if (reserva != null) {
            em.remove(reserva);
        }
        em.getTransaction().commit();
        em.close();
    }
}
