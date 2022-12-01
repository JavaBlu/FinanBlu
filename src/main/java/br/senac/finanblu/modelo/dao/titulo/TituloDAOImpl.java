package br.senac.finanblu.modelo.dao.titulo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.senac.finanblu.modelo.dao.venda.VendaDAOImpl;
import br.senac.finanblu.modelo.entidade.titulo.Titulo;
import br.senac.finanblu.modelo.entidade.venda.Venda;
import br.senac.finanblu.modelo.enumeracao.FormaPagamento;
import br.senac.finanblu.modelo.enumeracao.Situacao;

public class TituloDAOImpl implements TituloDAO {
	
	public void inserirTitulo(Titulo titulo) {
		Connection conexao = null;
		PreparedStatement insert = null;
		try {
			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO titulo (instituicao_financeira_titulo, data_vencimento_titulo, situacao_titulo, data_pagamento_titulo, id_venda) VALUES (?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			insert.setString(1, titulo.getInstituicaoFinanceira());
			insert.setString(2, titulo.getDataVencimento().toString());
			insert.setString(3, titulo.getSituacao().toString());
			insert.setString(4, titulo.getDataPagamento().toString());
			insert.setLong(5, titulo.getVenda().getId());
			insert.execute();

			ResultSet chavePrimaria = insert.getGeneratedKeys();

			if (chavePrimaria.next())
				titulo.setId(chavePrimaria.getLong(1));
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (insert != null)
					insert.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}

	}

	public void deletarTitulo(Titulo titulo) {
		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM titulo WHERE id_titulo = ?");

			delete.setLong(1, titulo.getId());

			delete.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (delete != null)
					delete.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}

	public void atualizarTitulo(Titulo titulo) {
		Connection conexao = null;
		PreparedStatement update = null;

		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement(
					"Update titulo set instituicao_financeira_titulo = ?, data_vencimento_titulo = ?, situacao_titulo = ?, data_pagamento_titulo = ?, id_venda = ? where id_titulo = ?");
			update.setString(1, titulo.getInstituicaoFinanceira());
			update.setString(2, titulo.getDataVencimento().toString());
			update.setString(3, titulo.getSituacao().toString());
			update.setString(4, titulo.getDataPagamento().toString());
			update.setLong(5, titulo.getVenda().getId());
			update.setLong(6, titulo.getId());
			update.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	public List<Titulo> recuperarTitulos() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Titulo> titulos = new ArrayList<Titulo>();

		try {
			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("select * from titulo");

			while (resultado.next()) {
				long idTitulo = resultado.getLong("id_titulo");
				long idVenda = resultado.getLong("id_venda");
				Venda venda = new VendaDAOImpl().recuperarVendasPorId(idVenda);
				String instituicaoFinanceira = resultado.getString("instituicao_financeira_titulo");
				LocalDate dataVencimento = LocalDate.parse(resultado.getString("data_vencimento_titulo"));
				Situacao situacao = Situacao.valueOf(resultado.getString("situacao_titulo"));
				LocalDate dataPagamento = LocalDate.parse(resultado.getString("data_pagamento_titulo"));

				titulos.add(
						new Titulo(idTitulo, venda, instituicaoFinanceira, dataVencimento, situacao, dataPagamento));

			}

		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (resultado != null)
					resultado.close();

				if (consulta != null)
					consulta.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}

		return titulos;
	}
	public List<Titulo> recuperarTitulosPagos() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Titulo> titulos = new ArrayList<Titulo>();

		try {
			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("select * from titulo where situacao_titulo = 'PAGO'");

			while (resultado.next()) {
				long idTitulo = resultado.getLong("id_titulo");
				long idVenda = resultado.getLong("id_venda");
				Venda venda = new VendaDAOImpl().recuperarVendasPorId(idVenda);
				String instituicaoFinanceira = resultado.getString("instituicao_financeira_titulo");
				LocalDate dataVencimento = LocalDate.parse(resultado.getString("data_vencimento_titulo"));
				Situacao situacao = Situacao.valueOf(resultado.getString("situacao_titulo"));
				LocalDate dataPagamento = LocalDate.parse(resultado.getString("data_pagamento_titulo"));

				titulos.add(
						new Titulo(idTitulo, venda, instituicaoFinanceira, dataVencimento, situacao, dataPagamento));

			}

		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (resultado != null)
					resultado.close();

				if (consulta != null)
					consulta.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}

		return titulos;

		
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/finanblu?user=root&password=root");
	}

	public List<Titulo> recuperarTitulosPagosPorData() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Titulo> recuperarTitulosPagosPorCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Titulo> recuperarTitulosAbertos() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Titulo> recuperarTitulosAbertosPorData(Titulo titulo, LocalDate dataVenda) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Titulo> recuperarTitulosAbertosPorCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Titulo> recuperarTitulosVencer() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Titulo> recuperarTitulosVencerPorData() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Titulo> recuperarTitulosVencerPorCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Titulo> recuperarTitulosVencidos() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Titulo> recuperarTitulosVencidosPorData() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Titulo> recuperarTitulosVencidosPorCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
