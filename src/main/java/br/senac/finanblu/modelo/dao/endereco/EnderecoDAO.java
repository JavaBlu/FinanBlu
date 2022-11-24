package br.senac.finanblu.modelo.dao.endereco;

import java.util.List;

import br.senac.finanblu.modelo.entidade.endereco.Endereco;

public interface EnderecoDAO {
	
	void inserirEndereco (Endereco endereco);
	void deletarEndereco (Endereco endereco);
	void atualizarCepEndereco(Endereco endereco, String novoCep);
	void atualizarLogradouroEndereco(Endereco endereco, String novoLogradouro);
	void atualizarNumeroEndereco(Endereco endereco, short novoNumero);
	void atualizarBairroEndereco(Endereco endereco, String novoBairro);
	void atualizarCidadeEndereco(Endereco endereco, String novaCidade);
	void atualizarUfEndereco(Endereco endereco, String novaUf);
	void atualizarComplementoEndereco(Endereco endereco, String novoComplemento);

	List<Endereco> recuperarEnderecos();
}
