package model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class ServicoDeQuarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quarto_id")
    private Quarto quarto;

    private String descricaoServico;
    private String funcionario;
    
    @Temporal(TemporalType.DATE)
    private Date dataServico;

    public ServicoDeQuarto() {}

    public ServicoDeQuarto(Quarto quarto, String descricaoServico, String funcionario, Date dataServico) {
        this.quarto = quarto;
        this.descricaoServico = descricaoServico;
        this.funcionario = funcionario;
        this.dataServico = dataServico;
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

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataServico() {
        return dataServico;
    }

    public void setDataServico(Date dataServico) {
        this.dataServico = dataServico;
    }
}
