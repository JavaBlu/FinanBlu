package br.senac.finanblu.modelo.dao.endereco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
            ResultSet chavePrimaria = insert.getGeneratedKeys();

            if (chavePrimaria.next())
                endereco.setId(chavePrimaria.getLong(1));
            
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

	public void atualizarCepEndereco(Endereco endereco, String cep) {

	}

	public void atualizarLogradouroEndereco(Endereco endereco, String logradouro) {

	}

	public void atualizarNumeroEndereco(Endereco endereco, short numero) {

	}

	public void atualizarBairroEndereco(Endereco endereco, String bairro) {

	}

	public void atualizarCidadeEndereco(Endereco endereco, String cidade) {

	}

	public void atualizarUfEndereco(Endereco endereco, String uf) {

	}

	public void atualizarComplementoEndereco(Endereco endereco, String uf) {

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

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/finanblu?user=root&password=Cry$talc0ld");
	}

}
