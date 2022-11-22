package br.senac.finanblu.modelo.dao.pessoaJuridica;

import java.util.List;

import br.senac.finanblu.modelo.entidade.pessoaJuridica.PessoaJuridica;

public interface PessoaJuridicaDAO {
	void inserirPessoaJuridica(PessoaJuridica pessoaJuridica);

	void deletarPessoaJuridica(PessoaJuridica pessoaJuridica);

	void atualizarRazaoSocial(PessoaJuridica pessoaJuridica, String novaRazaoSocial);

	void atualizarNomeFantasia(PessoaJuridica pessoaJuridica, String novoNomeFantasia);
	
	void atualizarCnpj(PessoaJuridica pessoaJuridica, String novoCnpj);
	
	List<PessoaJuridica> recuperarPessoasJuridicas();
}
