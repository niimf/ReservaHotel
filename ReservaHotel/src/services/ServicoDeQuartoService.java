package services;

import model.ServicoDeQuarto;
import repository.ServicoDeQuartoRepository;
import java.util.List;

public class ServicoDeQuartoService {
    private ServicoDeQuartoRepository repository = new ServicoDeQuartoRepository();

    public ServicoDeQuarto salvar(ServicoDeQuarto servico) {
        return repository.salvar(servico);
    }

    public List<ServicoDeQuarto> listarTodos() {
        return repository.listarTodos();
    }

    public ServicoDeQuarto buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    public void atualizar(ServicoDeQuarto servico) {
        repository.atualizar(servico);
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }
}
