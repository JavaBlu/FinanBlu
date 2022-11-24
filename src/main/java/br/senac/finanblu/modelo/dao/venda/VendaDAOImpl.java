package br.senac.finanblu.modelo.dao.venda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.senac.finanblu.modelo.dao.cliente.ClienteDAOImpl;
import br.senac.finanblu.modelo.dao.contato.ContatoDAOImpl;
import br.senac.finanblu.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.finanblu.modelo.entidade.cliente.Cliente;
import br.senac.finanblu.modelo.entidade.contato.Contato;
import br.senac.finanblu.modelo.entidade.endereco.Endereco;
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
			update = conexao.prepareStatement("UPDATE venda SET valor_venda = ? WHERE id_venda = ?");

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
			update = conexao.prepareStatement("UPDATE venda SET valor_venda = ? WHERE id_venda = ?");

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

	public List<Venda> recuperarVendas() {
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Venda> vendas = new ArrayList<Venda>();

		try {
			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(
					"select id_venda, id_cliente, valor_venda , data_venda, forma_pagamento_venda from venda");

			while (resultado.next()) {
				long idVenda = resultado.getLong("id_venda");
				long idCliente = resultado.getLong("id_cliente");
				Cliente cliente = new ClienteDAOImpl().recuperarClientePorId(idCliente);
				float valorVenda = resultado.getFloat("valor_venda");
				LocalDate dataVenda = LocalDate.parse(resultado.getString("data_venda"));
				FormaPagamento formaPagamento = FormaPagamento.valueOf(resultado.getString("forma_pagamento"));
				vendas.add(new Venda(idVenda, cliente, valorVenda, dataVenda, formaPagamento));

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

		return vendas;
	}


	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/finanblu?user=root&password=root");
	}

}
