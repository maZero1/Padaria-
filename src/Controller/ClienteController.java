package src.Controller;

import src.Model.Dao.ClienteDAO;
import src.Model.Entities.Cliente;
import java.util.List;

public class ClienteController {
	private ClienteDAO clienteDAO;
    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }
    public void adicionarCliente(String nome, String email, String telefone, String cpf) {
        Cliente cliente = new Cliente(nome, email, telefone, cpf);
        clienteDAO.adicionarCliente(cliente);
    }
    public List<Cliente> listarClientes() {
        return clienteDAO.listarClientes();
    }
    public void atualizarPontosFidelidade(int clienteId, int novosPontos) {
        clienteDAO.atualizarPontosFidelidade(clienteId, novosPontos);
    }
    public void removerCliente(int clienteId) {
        clienteDAO.removerCliente(clienteId);
    }
}
