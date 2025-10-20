package src.Test;

import src.Controller.ClienteController;
import src.Model.Entities.Cliente;

public class TesteCliente {
    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();

        clienteController.adicionarCliente("João Silva", "1983922710", "99999-9999", "tkmiasomdo@gmail.com", 3);
        System.out.println("Cliente adicionado com sucesso!");
        for(Cliente cliente : clienteController.listarClientes()) {
            System.out.println(cliente);
        }
    }
}
