package model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class ServicoDeLimpeza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quarto_id")
    private Quarto quarto;

    private String funcionario;
    
    @Temporal(TemporalType.DATE)
    private Date dataLimpeza;

    public ServicoDeLimpeza() {}

    public ServicoDeLimpeza(Quarto quarto, String funcionario, Date dataLimpeza) {
        this.quarto = quarto;
        this.funcionario = funcionario;
        this.dataLimpeza = dataLimpeza;
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

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataLimpeza() {
        return dataLimpeza;
    }

    public void setDataLimpeza(Date dataLimpeza) {
        this.dataLimpeza = dataLimpeza;
    }
}
