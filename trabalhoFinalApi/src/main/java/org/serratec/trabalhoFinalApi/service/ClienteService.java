package org.serratec.trabalhoFinalApi.service;

import org.serratec.trabalhoFinalApi.entity.Cliente;
import org.serratec.trabalhoFinalApi.exception.ClienteNaoEncontradoNatasha;
import org.serratec.trabalhoFinalApi.exception.CpfJaCadastradoNatasha;
import org.serratec.trabalhoFinalApi.model.ClienteAtualizar;
import org.serratec.trabalhoFinalApi.model.ClienteBuscar;
import org.serratec.trabalhoFinalApi.model.ClienteCriar;
import org.serratec.trabalhoFinalApi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.UUID;


public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarCliente (UUID id){
        return this.clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado pelo id: " + id + " especificado. Informe outro!"));
    }

    public ClienteBuscar inserirCliente(ClienteCriar cliente) {
        if (clienteRepository.findByCpf(cliente.getCpf()).isPresent()){
            throw new CpfJaCadastradoNatasha("CPF ja Cadastrado");
        }
        Cliente cliente1 = new Cliente(cliente);
        return new ClienteBuscar(clienteRepository.save(cliente1));
    }

    public ClienteAtualizar atualizarCliente(UUID id, ClienteAtualizar cliente) {

        Optional<Cliente> clienteOpt = clienteRepository.findById(id);

        if(clienteOpt.isEmpty()){
            throw new ClienteNaoEncontradoNatasha("Cliente com id: " + id + ", não Encontrado");
        }

        Cliente clienteAtualizado =  clienteOpt.get();

        clienteAtualizado.setCpf(cliente.getCpf());
        clienteAtualizado.setNome(cliente.getNome());
        clienteAtualizado.setEmail(cliente.getEmail());
        clienteAtualizado.setTelefone(cliente.getTelefone());
        clienteAtualizado.setEndereco(cliente.getEndereco());

        return new ClienteAtualizar(clienteRepository.save(clienteAtualizado));
    }
}

