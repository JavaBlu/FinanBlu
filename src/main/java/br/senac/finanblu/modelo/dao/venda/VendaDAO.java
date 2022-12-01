package br.senac.finanblu.modelo.dao.venda;

import java.time.LocalDate;
import java.util.List;

import br.senac.finanblu.modelo.entidade.venda.Venda;
import br.senac.finanblu.modelo.enumeracao.FormaPagamento;

public interface VendaDAO {

	void inserirVenda(Venda venda);

	void deletarVenda(Venda venda);

	void atualizarVenda(Venda venda);
	
	List<Venda> recuperarVendas();
	
	List<Venda> recuperarVendasPorOrdemDataAscendente();
	
	List<Venda> recuperarVendasPorOrdemDataDescendente();
	
	List<Venda> recuperarVendasPorOrdemClienteAscendente();
	
	List<Venda> recuperarVendasPorOrdemClienteDescendente();

}
