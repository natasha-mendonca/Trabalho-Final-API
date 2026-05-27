package org.serratec.trabalhoFinalApi.service;

import org.serratec.trabalhoFinalApi.entity.Cliente;
import org.serratec.trabalhoFinalApi.entity.Endereco;
import org.serratec.trabalhoFinalApi.exception.ClienteNaoEncontradoNatasha;
import org.serratec.trabalhoFinalApi.exception.CpfJaCadastradoNatasha;
import org.serratec.trabalhoFinalApi.model.ClienteAtualizar;
import org.serratec.trabalhoFinalApi.model.ClienteBuscar;
import org.serratec.trabalhoFinalApi.model.ClienteCriar;
import org.serratec.trabalhoFinalApi.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private EmailService emailService;
    private EnderecoService enderecoService;

    public ClienteService(ClienteRepository clienteRepository, EmailService emailService, EnderecoService enderecoService) {
        this.clienteRepository = clienteRepository;
        this.emailService = emailService;
        this.enderecoService = enderecoService;
    }

    public Cliente buscarCliente (UUID id){
        return this.clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado pelo id: " + id + " especificado. Informe outro!"));
    }

    public ClienteBuscar inserirCliente(ClienteCriar cliente) {

        if (clienteRepository.findByCpf(cliente.getCpf()).isPresent()){
            throw new CpfJaCadastradoNatasha("CPF ja Cadastrado");
        }

        Endereco endereco = enderecoService.adicionarEndereco(cliente.getEndereco());

        Cliente cliente1 = new Cliente(cliente, endereco);
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

        Endereco enderecoAtualizado = enderecoService.adicionarEndereco(cliente.getEndereco());

        clienteAtualizado.setEndereco(enderecoAtualizado);

        clienteRepository.save(clienteAtualizado);
        emailService.enviarEmailAlteracao(clienteAtualizado.getEmail());

        return new ClienteAtualizar(clienteAtualizado);
    }
}

