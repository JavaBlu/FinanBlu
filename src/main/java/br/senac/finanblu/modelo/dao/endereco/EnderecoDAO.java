package br.senac.finanblu.modelo.dao.endereco;

import java.util.List;

import br.senac.finanblu.modelo.entidade.endereco.Endereco;

public interface EnderecoDAO {

	void inserirEndereco(Endereco endereco);

	void deletarEndereco(Endereco endereco);

	void atualizarCepEndereco(Endereco endereco, String cep);

	void atualizarLogradouroEndereco(Endereco endereco, String logradouro);

	void atualizarNumeroEndereco(Endereco endereco, short numero);

	void atualizarBairroEndereco(Endereco endereco, String bairro);

	void atualizarCidadeEndereco(Endereco endereco, String cidade);

	void atualizarUfEndereco(Endereco endereco, String uf);

	void atualizarComplementoEndereco(Endereco endereco, String uf);

	List<Endereco> recuperarEnderecos();
}
