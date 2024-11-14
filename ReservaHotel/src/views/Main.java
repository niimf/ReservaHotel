package views;

import model.Hospede;
import model.Quarto;
import model.Reserva;
import model.ServicoDeLimpeza;
import services.EntityManagerFactoryProvider;
import services.ReservaService;
import services.ServicoDeLimpezaService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ReservaService reservaService = new ReservaService();
        ServicoDeLimpezaService limpezaService = new ServicoDeLimpezaService();

        Quarto quarto = new Quarto("101", "Suite", 200.0);

        Hospede hospede = new Hospede("João Silva", "12345678900", "joao@email.com");

        Reserva reserva = new Reserva(quarto, hospede, new Date(), new Date());

        reservaService.salvar(reserva);

        ServicoDeLimpeza limpeza = new ServicoDeLimpeza(quarto, "Funcionário A", new Date());

        limpezaService.salvar(limpeza);

        System.out.println("Reservas:");
        reservaService.listarTodos().forEach(r -> System.out.println("Reserva ID: " + r.getId()));

        System.out.println("Serviços de Limpeza:");
        limpezaService.listarTodos().forEach(s -> System.out.println("Serviço de Limpeza ID: " + s.getId()));

        EntityManagerFactoryProvider.close();
    }
}


