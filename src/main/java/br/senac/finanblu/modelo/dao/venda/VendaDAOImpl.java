package br.senac.finanblu.modelo.dao.venda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import br.senac.finanblu.modelo.entidade.venda.Venda;
import br.senac.finanblu.modelo.enumeracao.FormaPagamento;

public class VendaDAOImpl implements VendaDAO {

	public void inserirVenda(Venda venda) {
		Connection conexao = null;
		PreparedStatement insert = null;
		try {
			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO venda ( valor_venda, data_venda, forma_pagamento_venda, id_cliente) VALUES (?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			insert.setFloat(1, venda.getValorVenda());
			insert.setString(2, venda.getDataVenda().toString());
			insert.setInt(3, venda.getFormaPagamento().ordinal());
			insert.setLong(4, venda.getCliente().getId());
			insert.execute();
			ResultSet chavePrimaria = insert.getGeneratedKeys();

			if (chavePrimaria.next())
				venda.setId(chavePrimaria.getLong(1));
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

	public void deletarVenda(Venda venda) {
		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM venda WHERE id_venda = ?");

			delete.setLong(1, venda.getId());

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

	public void atualizarRazaoSocialCliente(Venda venda, String novaRazaoSocial) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement(
					"UPDATE pessoa_juridica SET razao_social_pessoa_juridica = ? WHERE id_pessoa_juridica = ?");

			update.setString(1, novaRazaoSocial);
			update.setLong(2, venda.getCliente().getId());

			update.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}
	}

	public void atualizarNomeFantasiaCliente(Venda venda, String novoNomeFantasia) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement(
					"UPDATE pessoa_juridica SET nome_fantasia_pessoa_juridica = ? WHERE id_pessoa_juridica = ?");

			update.setString(1, novoNomeFantasia);
			update.setLong(2, venda.getCliente().getId());

			update.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}

	}

	public void atualizarCnpjCliente(Venda venda, String novoCnpj) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement(
					"UPDATE pessoa_juridica SET cnpj_pessoa_juridica = ? WHERE id_pessoa_juridica = ?");

			update.setString(1, novoCnpj);
			update.setLong(2, venda.getCliente().getId());

			update.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}
	}

	public void atualizarValorVenda(Venda venda, float novoValorVenda) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement(
					"UPDATE venda SET valor_venda = ? WHERE id_venda = ?");

			update.setFloat(1, novoValorVenda);
			update.setLong(2, venda.getId());

			update.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}

	}

	public void atualizarDataVenda(Venda venda, LocalDate novaDataVenda) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement(
					"UPDATE venda SET valor_venda = ? WHERE id_venda = ?");

			update.setString(1, novaDataVenda.toString());
			update.setLong(2, venda.getId());

			update.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}
	}

	public void atualizarFormaPagamento(Venda venda, FormaPagamento formaPagamento) {
		// TODO Auto-generated method stub

	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/finanblu?user=root&password=root");
	}

}
