package br.senac.finanblu.modelo.dao.cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.senac.finanblu.modelo.dao.contato.ContatoDAOImpl;
import br.senac.finanblu.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.finanblu.modelo.dao.pessoaJuridica.PessoaJuridicaDAOImpl;
import br.senac.finanblu.modelo.entidade.cliente.Cliente;
import br.senac.finanblu.modelo.entidade.contato.Contato;
import br.senac.finanblu.modelo.entidade.endereco.Endereco;
import br.senac.finanblu.modelo.entidade.pessoaJuridica.PessoaJuridica;

public class ClienteDAOImpl implements ClienteDAO {

	public void InserirCliente(Cliente cliente) {
		Connection conexao = null;
		PreparedStatement insert = null;

		try {
			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO cliente (id_pessoa_juridica, id_contato, id_endereco) VALUES (?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			insert.setLong(1, cliente.getPessoaJuridica().getId());
			Contato contato = cliente.getContato();
			insert.setLong(2, contato.getId());
			Endereco endereco = cliente.getEndereco();
			insert.setLong(3, endereco.getId());

			insert.execute();
			ResultSet chavePrimaria = insert.getGeneratedKeys();

			if (chavePrimaria.next())
				cliente.setId(chavePrimaria.getLong(1));
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

	public void DeletarCliente(Cliente cliente) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM cliente WHERE id_cliente = ?");

			delete.setLong(1, cliente.getId());

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

	public void AtualizarRazaoSocial(Cliente cliente, String novaRazaoSocial) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement(
					"UPDATE pessoa_juridica SET razao_social_pessoa_juridica = ? WHERE id_pessoa_juridica = ?");

			update.setString(1, novaRazaoSocial);
			update.setLong(2, cliente.getPessoaJuridica().getId());

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

	public void AtualizarNomeFantasia(Cliente cliente, String novoNomeFantasia) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement(
					"UPDATE pessoa_juridica SET nome_fantasia_pessoa_juridica = ? WHERE id_pessoa_juridica = ?");

			update.setString(1, novoNomeFantasia);
			update.setLong(2, cliente.getPessoaJuridica().getId());

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

	public void AtualizarCnpj(Cliente cliente, String novoCnpj) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement(
					"UPDATE pessoa_juridica SET cnpj_pessoa_juridica = ? WHERE id_pessoa_juridica = ?");

			update.setString(1, novoCnpj);
			update.setLong(2, cliente.getPessoaJuridica().getId());

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

	public void AtualizarTelefoneCliente(Cliente cliente, String novoTelefone) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE contato SET telefone_contato = ? WHERE id_contato = ?");

			update.setString(1, novoTelefone);
			update.setLong(2, cliente.getContato().getId());

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

	public void AtualizarEmailCliente(Cliente cliente, String novoEmail) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE contato SET email_contato = ? WHERE id_contato = ?");

			update.setString(1, novoEmail);
			update.setLong(2, cliente.getContato().getId());

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

	public void atualizarCepEndereco(Cliente cliente, String novoCep) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET cep_endereco = ? WHERE id_endereco = ?");

			update.setString(1, novoCep);
			update.setLong(2, cliente.getEndereco().getId());

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

	public void atualizarLogradouroEndereco(Cliente cliente, String novoLogradouro) {
		Connection conexao = null;
		PreparedStatement update = null;

		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET logradouro_endereco = ? WHERE id_endereco = ?");

			update.setString(1, novoLogradouro);
			update.setLong(2, cliente.getEndereco().getId());

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

	public void atualizarNumeroEndereco(Cliente cliente, short novoNumero) {
		Connection conexao = null;
		PreparedStatement update = null;

		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET numero_endereco = ? WHERE id_endereco = ?");

			update.setShort(1, novoNumero);
			update.setLong(2, cliente.getEndereco().getId());

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

	public void atualizarBairroEndereco(Cliente cliente, String novoBairro) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET bairro_endereco = ? WHERE id_endereco = ?");

			update.setString(1, novoBairro);
			update.setLong(2, cliente.getEndereco().getId());

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

	public void atualizarCidadeEndereco(Cliente cliente, String novaCidade) {
		Connection conexao = null;
		PreparedStatement update = null;

		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET cidade_endereco = ? WHERE id_endereco = ?");

			update.setString(1, novaCidade);
			update.setLong(2, cliente.getEndereco().getId());

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

	public void atualizarUfEndereco(Cliente cliente, String novaUf) {
		Connection conexao = null;
		PreparedStatement update = null;

		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET uf_endereco = ? WHERE id_endereco = ?");

			update.setString(1, novaUf);
			update.setLong(2, cliente.getEndereco().getId());

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

	public void atualizarComplementoEndereco(Cliente cliente, String novoComplemento) {
		Connection conexao = null;
		PreparedStatement update = null;

		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET complemento_endereco = ? WHERE id_endereco = ?");

			update.setString(1, novoComplemento);
			update.setLong(2, cliente.getEndereco().getId());

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


	public List<Cliente> recuperarClientes() {
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Cliente> clientes = new ArrayList<Cliente>();

		try {
			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta
					.executeQuery("select id_cliente, id_pessoa_juridica, id_contato, id_endereco from cliente");

			while (resultado.next()) {
				long idCliente = resultado.getLong("id_cliente");
				long idPessoaJuridica = resultado.getLong("id_pessoa_juridica");
				PessoaJuridica pessoaJuridica = new PessoaJuridicaDAOImpl()
						.recuperarPessoaJuridicaPorId(idPessoaJuridica);
				long idContato = resultado.getLong("id_contato");
				Contato contato = new ContatoDAOImpl().recuperarContatoPorId(idContato);
				long idEndereco = resultado.getLong("id_endereco");
				Endereco endereco = new EnderecoDAOImpl().recuperarEnderecoPorId(idEndereco);
				clientes.add(new Cliente(idCliente, pessoaJuridica, contato, endereco));

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

		return clientes;
	}
	public Cliente recuperarClientePorId(long id) {

		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Cliente cliente = null;
		try {

			conexao = conectarBanco();

			consulta = conexao.prepareStatement("SELECT * FROM cliente WHERE id_cliente = ?");
			consulta.setLong(1, id);
			consulta.execute();
			resultado = consulta.getResultSet();
			while (resultado.next()) {
				long idPessoaJuridica = resultado.getLong("id_pessoa_juridica");
				PessoaJuridica pessoaJuridica = new PessoaJuridicaDAOImpl()
						.recuperarPessoaJuridicaPorId(idPessoaJuridica);
				long idContato = resultado.getLong("id_contato");
				Contato contato = new ContatoDAOImpl().recuperarContatoPorId(idContato);
				long idEndereco = resultado.getLong("id_endereco");
				Endereco endereco = new EnderecoDAOImpl().recuperarEnderecoPorId(idEndereco);

				cliente = new Cliente(id, pessoaJuridica, contato, endereco);
			}

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

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

		return cliente;
	}
	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/finanblu?user=root&password=root");
	}

}
