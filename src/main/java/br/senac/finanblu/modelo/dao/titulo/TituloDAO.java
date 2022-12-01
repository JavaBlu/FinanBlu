package br.senac.finanblu.modelo.dao.titulo;

import java.time.LocalDate;
import java.util.List;

import br.senac.finanblu.modelo.entidade.titulo.Titulo;
import br.senac.finanblu.modelo.enumeracao.FormaPagamento;
import br.senac.finanblu.modelo.enumeracao.Situacao;

public interface TituloDAO {
	void inserirTitulo(Titulo titulo);
	
	void deletarTitulo(Titulo titulo);

	void atualizarTitulo(Titulo titulo);
	
	List<Titulo> recuperarTitulos();
	
	List<Titulo> recuperarTitulosPagos();
	
	List<Titulo> recuperarTitulosPagosPorData();
	
	List<Titulo> recuperarTitulosPagosPorCliente();
	
	List<Titulo> recuperarTitulosAbertos();
	
	List<Titulo> recuperarTitulosAbertosPorData(Titulo titulo, LocalDate dataVenda);
	
	List<Titulo> recuperarTitulosAbertosPorCliente();
	
	List<Titulo> recuperarTitulosVencer();
	
	List<Titulo> recuperarTitulosVencerPorData();
	
	List<Titulo> recuperarTitulosVencerPorCliente();
	
	List<Titulo> recuperarTitulosVencidos();
	
	List<Titulo> recuperarTitulosVencidosPorData();
	
	List<Titulo> recuperarTitulosVencidosPorCliente();
	
	
}
