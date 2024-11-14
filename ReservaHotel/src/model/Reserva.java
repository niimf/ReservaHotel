package model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST) 
    @JoinColumn(name = "quarto_id")
    private Quarto quarto;

    @ManyToOne(cascade = CascadeType.PERSIST) 
    @JoinColumn(name = "hospede_id")
    private Hospede hospede;

    @Temporal(TemporalType.DATE)
    private Date dataCheckIn;

    @Temporal(TemporalType.DATE)
    private Date dataCheckOut;

    public Reserva() {}

    public Reserva(Quarto quarto, Hospede hospede, Date dataCheckIn, Date dataCheckOut) {
        this.quarto = quarto;
        this.hospede = hospede;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Date getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(Date dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public Date getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(Date dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }
}
