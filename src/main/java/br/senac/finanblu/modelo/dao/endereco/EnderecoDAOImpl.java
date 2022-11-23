package br.senac.finanblu.modelo.dao.endereco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.senac.finanblu.modelo.entidade.contato.Contato;
import br.senac.finanblu.modelo.entidade.endereco.Endereco;

public class EnderecoDAOImpl implements EnderecoDAO {

	public void inserirEndereco(Endereco endereco) {
		Connection conexao = null;
		PreparedStatement insert = null;

		try {
			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"Insert Into endereco (cep_endereco, logradouro_endereco, numero_endereco, bairro_endereco, cidade_endereco, uf_endereco, complemento_endereco) VALUES (?,?,?,?,?,?,?)",
			PreparedStatement.RETURN_GENERATED_KEYS);

			insert.setString(1, endereco.getCep());
			insert.setString(2, endereco.getLogradouro());
			insert.setShort(3, endereco.getNumero());
			insert.setString(4, endereco.getBairro());
			insert.setString(5, endereco.getCidade());
			insert.setString(6, endereco.getUf());
			insert.setString(7, endereco.getComplemento());

			insert.execute();
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

	public void deletarEndereco(Endereco endereco) {
		Connection conexao = null;
		PreparedStatement delete = null;

		try {
			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM endereco WHERE id_endereco = ?");

			delete.setLong(1, endereco.getId());
			delete.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
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

	public void atualizarCepEndereco(Endereco endereco, String novoCep) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET cep_endereco = ? WHERE id_endereco = ?");

			update.setString(1, novoCep);
			update.setLong(2, endereco.getId());

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

	public void atualizarLogradouroEndereco(Endereco endereco, String novoLogradouro) {
		Connection conexao = null;
		PreparedStatement update = null;

		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET logradouro_endereco = ? WHERE id_endereco = ?");

			update.setString(1, novoLogradouro);
			update.setLong(2, endereco.getId());

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

	public void atualizarNumeroEndereco(Endereco endereco, short novoNumero) {
		Connection conexao = null;
		PreparedStatement update = null;

		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET numero_endereco = ? WHERE id_endereco = ?");

			update.setShort(1, novoNumero);
			update.setLong(2, endereco.getId());

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

	public void atualizarBairroEndereco(Endereco endereco, String novoBairro) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET bairro_endereco = ? WHERE id_endereco = ?");

			update.setString(1, novoBairro);
			update.setLong(2, endereco.getId());

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

	public void atualizarCidadeEndereco(Endereco endereco, String novaCidade) {
		Connection conexao = null;
		PreparedStatement update = null;

		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET cidade_endereco = ? WHERE id_endereco = ?");

			update.setString(1, novaCidade);
			update.setLong(2, endereco.getId());

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

	public void atualizarUfEndereco(Endereco endereco, String novaUf) {
		Connection conexao = null;
		PreparedStatement update = null;

		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET uf_endereco = ? WHERE id_endereco = ?");

			update.setString(1, novaUf);
			update.setLong(2, endereco.getId());

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

	public void atualizarComplementoEndereco(Endereco endereco, String novoComplemento) {
		Connection conexao = null;
		PreparedStatement update = null;

		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET complemento_endereco = ? WHERE id_endereco = ?");

			update.setString(1, novoComplemento);
			update.setLong(2, endereco.getId());

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

	public List<Endereco> recuperarEnderecos() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> enderecos = new ArrayList<Endereco>();

		try {
			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco");

			while (resultado.next()) {
				long id = resultado.getLong("id_endereco");
				String cep = resultado.getString("cep_endereco");
				String logradouro = resultado.getString("logradouro_endereco");
				short numero = resultado.getShort("numero_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String uf = resultado.getString("uf_endereco");
				String complemento = resultado.getString("complemento_endereco");
				enderecos.add(new Endereco(id, cep, logradouro, numero, bairro, cidade, uf, complemento));

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

		return enderecos;
	}
	
	public Endereco recuperarEnderecoPorId(long id) {

		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Endereco endereco = null;
		try {

			conexao = conectarBanco();
			
			consulta = conexao.prepareStatement("SELECT * FROM endereco WHERE id_endereco = ?");
			consulta.setLong(1, id);
			consulta.execute();
			resultado = consulta.getResultSet();
			while (resultado.next()) {
			  
				String cep = resultado.getString("cep_endereco");
				String logradouro = resultado.getString("logradouro_endereco");
				short numero = resultado.getShort("numero_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String uf = resultado.getString("uf_endereco");
				String complemento = resultado.getString("complemento_endereco");

				endereco = new Endereco(id, cep, logradouro, numero, bairro, cidade, uf, complemento);
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

		return endereco;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/finanblu?user=root&password=Cry$talc0ld");
	}

}