package br.senac.finanblu.modelo.dao.cliente;

import java.util.List;

import br.senac.finanblu.modelo.entidade.cliente.Cliente;
import br.senac.finanblu.modelo.entidade.contato.Contato;
import br.senac.finanblu.modelo.entidade.endereco.Endereco;
public interface ClienteDAO {

    void InserirCliente(Cliente cliente);

    void DeletarCliente(Cliente cliente);

    void AtualizarRazaoSocial(Cliente cliente, String novaRazaoSocial);

    void AtualizarNomeFantasia(Cliente cliente, String novoNomeFantasia);

    void AtualizarCnpj(Cliente cliente, String novoCnpj);

    void AtualizarEmailCliente(Cliente cliente, String novoEmail);

    void AtualizarTelefoneCliente(Cliente cliente, String novoTelefone);

    void atualizarCepEndereco(Cliente cliente, String novoCep);

    void atualizarLogradouroEndereco(Cliente cliente, String novoLogradouro);

    void atualizarNumeroEndereco(Cliente cliente, short novoNumero);

	void atualizarBairroEndereco(Cliente cliente, String novoBairro);

	void atualizarCidadeEndereco(Cliente cliente, String novaCidade);

	void atualizarUfEndereco(Cliente cliente, String novaUf);

	void atualizarComplementoEndereco(Cliente cliente, String novoComplemento);
    
    List<Cliente> recuperarClientes();

}