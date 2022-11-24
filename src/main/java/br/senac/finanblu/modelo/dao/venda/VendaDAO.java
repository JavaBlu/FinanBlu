package br.senac.finanblu.modelo.dao.venda;

import java.time.LocalDate;

import br.senac.finanblu.modelo.entidade.venda.Venda;
import br.senac.finanblu.modelo.enumeracao.FormaPagamento;

public interface VendaDAO {

	void inserirVenda(Venda venda);

	void deletarVenda(Venda venda);

	void atualizarRazaoSocialCliente(Venda venda, String novaRazaoSocial);

	void atualizarNomeFantasiaCliente(Venda venda, String novoNomeFantasia);

	void atualizarCnpjCliente(Venda venda, String novoCnpj);

	void atualizarValorVenda(Venda venda, float novoValorVenda);

	void atualizarDataVenda(Venda venda, LocalDate novaDataVenda);

	void atualizarFormaPagamento(Venda venda, FormaPagamento formaPagamento);
	
}
