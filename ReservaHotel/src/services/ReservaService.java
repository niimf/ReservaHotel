package services;

import model.Reserva;
import repository.ReservaRepository;

import java.util.List;

public class ReservaService {
    private ReservaRepository repository;

    public ReservaService() {
        this.repository = new ReservaRepository();
    }

    public Reserva salvar(Reserva reserva) {
        return repository.salvarReserva(reserva);
    }

    public List<Reserva> listarTodos() {
        return repository.listarReservas();
    }

    public Reserva buscarPorId(Long id) {
        return repository.buscarReservaPorId(id);
    }

    public void atualizar(Reserva reserva) {
        repository.atualizarReserva(reserva);
    }

    public void deletar(Long id) {
        repository.removerReserva(id);
    }
}
