package org.serratec.trabalhoFinalApi.service;

import org.serratec.trabalhoFinalApi.entity.Cliente;
import org.serratec.trabalhoFinalApi.exception.ClienteNaoEncontradoNatasha;
import org.serratec.trabalhoFinalApi.exception.CpfJaCadastradoNatasha;
import org.serratec.trabalhoFinalApi.model.ClienteAtualizar;
import org.serratec.trabalhoFinalApi.model.ClienteBuscar;
import org.serratec.trabalhoFinalApi.model.ClienteCriar;
import org.serratec.trabalhoFinalApi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private EmailService emailService;

    public ClienteService(ClienteRepository clienteRepository, EmailService emailService) {
        this.clienteRepository = clienteRepository;
        this.emailService = emailService;
    }

    public Cliente buscarCliente (UUID id){
        return this.clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado pelo id: " + id + " especificado. Informe outro!"));
    }

    public ClienteBuscar inserirCliente(ClienteCriar cliente) {
        if (clienteRepository.findByCpf(cliente.getCpf()).isPresent()){
            throw new CpfJaCadastradoNatasha("CPF ja Cadastrado");
        }
        Cliente cliente1 = new Cliente(cliente);
        Cliente clienteSalvo = clienteRepository.save(cliente1);
        emailService.enviarEmailCadastro(clienteSalvo.getEmail());
        return new ClienteBuscar(clienteSalvo);
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

        clienteRepository.save(clienteAtualizado);
        emailService.enviarEmailAlteracao(clienteAtualizado.getEmail());

        return new ClienteAtualizar(clienteAtualizado);
    }
}

