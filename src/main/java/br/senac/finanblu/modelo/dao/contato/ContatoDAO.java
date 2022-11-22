package br.senac.finanblu.modelo.dao.contato;

import java.util.List;

import br.senac.finanblu.modelo.entidade.contato.Contato;

public interface ContatoDAO {
	
	void inserirContato (Contato contato);
	
	void deletarContato (Contato contato);
	
	void atualizarEmailContato (Contato contato, String novoEmail);
	
	void atualizarTelefoneContato(Contato contato, String novoTelefone);
	
	List<Contato> recuperarContatos();

}
