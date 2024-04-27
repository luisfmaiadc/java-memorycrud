import java.util.Collection;

/**
 * @author lf_mc
 */

public interface IClienteDAO {

    public boolean cadastrar(Cliente cliente);
    public boolean excluir(Integer cpf);
    public boolean alterar(Cliente cliente);
    public Cliente consultar(Integer cpf);
}
