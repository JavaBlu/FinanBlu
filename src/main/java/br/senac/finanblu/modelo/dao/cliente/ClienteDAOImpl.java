package br.senac.finanblu.modelo.dao.cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.senac.finanblu.modelo.entidade.cliente.Cliente;
import br.senac.finanblu.modelo.entidade.contato.Contato;
import br.senac.finanblu.modelo.entidade.endereco.Endereco;

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
			if(chavePrimaria.next()) {
				cliente.setId(chavePrimaria.getLong(1));
			}
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
		// TODO Auto-generated method stub

	}

	public void AtualizarNomeFantasia(Cliente cliente, String novoNomeFantasia) {
		// TODO Auto-generated method stub

	}

	public void AtualizarCnpj(Cliente cliente, String novoCnpj) {
		// TODO Auto-generated method stub

	}

	public void AtualizarEmailContato(Contato contato, String novoEmail) {
		// TODO Auto-generated method stub

	}

	public void AtualizarTelefoneContato(Contato contato, String novoTelefone) {
		// TODO Auto-generated method stub

	}

	public void atualizarCepEndereco(Endereco endereco, String novoCep) {
		// TODO Auto-generated method stub

	}

	public void atualizarLogradouroEndereco(Endereco endereco, String novoLogradouro) {
		// TODO Auto-generated method stub

	}

	public void atualizarNumeroEndereco(Endereco endereco, short novoNumero) {
		// TODO Auto-generated method stub

	}

	public void atualizarBairroEndereco(Endereco endereco, String novoBairro) {
		// TODO Auto-generated method stub

	}

	public void atualizarCidadeEndereco(Endereco endereco, String novaCidade) {
		// TODO Auto-generated method stub

	}

	public void atualizarUfEndereco(Endereco endereco, String uf) {
		// TODO Auto-generated method stub

	}

	public void atualizarComplementoEndereco(Endereco endereco, String uf) {
		// TODO Auto-generated method stub

	}

	public List<Cliente> recuperarClientes() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(
					"select razao_social_pessoa_juridica, nome_fantasia_pessoa_juridica, cnpj_pessoa_juridica, telefone_contato, email_contato, cep_endereco, logradouro_endereco, numero_endereco, bairro_endereco, cidade_endereco, uf_endereco, complemento_endereco from pessoa_juridica p inner join cliente c on p.id_pessoa_juridica = c.id_pessoa_juridica inner join contato t on c.id_contato = t.id_contato inner join endereco e on c.id_endereco = e.id_endereco;");

			while (resultado.next()) {

				String razaoSocial = resultado.getString("razao_social_pessoa_juridica");
				String nomeFantasia = resultado.getString("nome_fantasia_pessoa_juridica");
				String cnpj = resultado.getString("cnpj_pessoa_juridica");
				long id = resultado.getInt("id_contato");
				String telefone = resultado.getString("telefone_contato");
				String email = resultado.getString("email_contato");
				String cep = resultado.getString("cep_endereco");
				String logradouro = resultado.getString("logradouro_endereco");
				short numero = resultado.getShort("numero_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String uf = resultado.getString("uf_endereco");
				String complemento = resultado.getString("uf_endereco");

				clientes.add(new Cliente());
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

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/finanblu?user=root&password=Cry$talc0ld");
	}

}
