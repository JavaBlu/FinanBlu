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

    void AtualizarEmailContato(Contato contato, String novoEmail);

    void AtualizarTelefoneContato(Contato contato, String novoTelefone);

    void atualizarCepEndereco(Endereco endereco, String novoCep);

    void atualizarLogradouroEndereco(Endereco endereco, String novoLogradouro);

    void atualizarNumeroEndereco(Endereco endereco, short novoNumero);

	void atualizarBairroEndereco(Endereco endereco, String novoBairro);

	void atualizarCidadeEndereco(Endereco endereco, String novaCidade);

	void atualizarUfEndereco(Endereco endereco, String uf);

	void atualizarComplementoEndereco(Endereco endereco, String uf);
    
    List<Cliente> recuperarClientes();

}
