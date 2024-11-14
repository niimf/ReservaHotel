package services;

import model.ServicoDeLimpeza;
import repository.ServicoDeLimpezaRepository;
import java.util.List;

public class ServicoDeLimpezaService {
    private ServicoDeLimpezaRepository repository = new ServicoDeLimpezaRepository();

    public ServicoDeLimpeza salvar(ServicoDeLimpeza servico) {
        return repository.salvar(servico);
    }

    public List<ServicoDeLimpeza> listarTodos() {
        return repository.listarTodos();
    }

    public ServicoDeLimpeza buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    public void atualizar(ServicoDeLimpeza servico) {
        repository.atualizar(servico);
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }
}

