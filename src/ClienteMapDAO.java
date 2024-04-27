import java.util.HashMap;
import java.util.Map;

/**
 * @author lf_mc
 */

public class ClienteMapDAO implements IClienteDAO {

    private Map<Integer, Cliente> map;

    public ClienteMapDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public boolean cadastrar(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf())) {
            return false;
        } else {
            this.map.put(cliente.getCpf(), cliente);
            return true;
        }
    }

    @Override
    public boolean excluir(Integer cpf) {
        Cliente clienteCadastrado = this.map.get(cpf);
        if (clienteCadastrado != null) {
            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean alterar(Cliente cliente) {
        Cliente clienteCadastrado = this.map.get(cliente.getCpf());
        if (clienteCadastrado != null) {
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setEndereco(cliente.getEndereco());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Cliente consultar(Integer cpf) {
        return this.map.get(cpf);
    }

}
