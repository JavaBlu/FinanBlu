package br.senac.finanblu.principal;

import java.util.List;
import java.util.Scanner;

import br.senac.finanblu.modelo.dao.cliente.ClienteDAO;
import br.senac.finanblu.modelo.dao.cliente.ClienteDAOImpl;
import br.senac.finanblu.modelo.entidade.cliente.Cliente;
import br.senac.finanblu.modelo.enumeracao.Menu;


public class Principal {

	public static void main(String[] args) {
/*
		Endereco endereco = new Endereco();
		endereco.setCep("003310");
		endereco.setLogradouro("avestruz");
		endereco.setNumero((short) 123);
		endereco.setBairro("Bairror");
		endereco.setCidade("Cidado");
		endereco.setUf("RJ");
		endereco.setComplemento("50");

		EnderecoDAO dao = new EnderecoDAOImpl();
		dao.inserirEndereco(endereco);

		Contato contato = new Contato();
		contato.setEmail("saburgo.com");
		contato.setTelefone("47992661693");
		ContatoDAO contatodao = new ContatoDAOImpl();
		contatodao.inserirContato(contato);

		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setCnpj("127756119-12745678");
		pessoaJuridica.setNomeFantasia("abadia");
		pessoaJuridica.setRazaoSocial("semila");
		PessoaJuridicaDAO pjdao = new PessoaJuridicaDAOImpl();
		pjdao.inserirPessoaJuridica(pessoaJuridica);

		Cliente cliente = new Cliente();
		cliente.setId(pessoaJuridica.getId());
		cliente.setContato(contato);
		cliente.setEndereco(endereco);

		ClienteDAO clientedao = new ClienteDAOImpl();
		clientedao.InserirCliente(cliente);
	*/	
		
		
		ClienteDAO dao = new ClienteDAOImpl();
		List<Cliente> clientes = null;

		System.out.println("Sejam Bem-Vindos.\n");

		System.out.println("As Opções Disponíveis São:\n");

		System.out.println("1 - Listar Clientes.");
		System.out.println("2 - Editar Clientes.");
		System.out.println("3 - Deletar Clientes.");
		System.out.println("4 - Sair do Sistema.\n");

		System.out.print("Selecione Uma das Opções Apresentadas: ");

		Scanner leitor = new Scanner(System.in);
		Menu menu = Menu.values()[Integer.parseInt(leitor.next()) - 1];

		while (menu != Menu.SAIR) {

			switch (menu) {


			case LISTAR:

					clientes = dao.recuperarClientes();
					listarClientes(clientes);
						

				break;

			case EDITAR:

				System.out.print("\n");
				System.out.println("Os Clientes Cadastrados São:\n");

				clientes = dao.recuperarClientes();
				listarClientes(clientes);

				System.out.print("Selecione Um Dos Clientes Para Editar: ");
				Cliente cliente = clientes.get(Integer.parseInt(leitor.next()) - 1);

				System.out.print("\n");

				System.out.println("As Opções Disponíveis São:\n");

				System.out.println("1 - Editar O Nome Do Cliente.");
				System.out.println("2 - Editar O CPF Do Cliente.");
				System.out.println("3 - Editar A Idade Do Cliente.");
				System.out.println("4 - Editar A Dívida Do Cliente.\n");

				System.out.print("Selecione Uma Das Opções Apresentadas: ");
				break;

			case DELETAR:

				System.out.print("\n");
				System.out.println("Os Clientes Cadastrados São:\n");
				
				clientes = dao.recuperarClientes();
				listarClientes(clientes);

				System.out.print("Selecione Um Dos Clientes Para deletar: ");
				cliente = clientes.get(Integer.parseInt(leitor.next()) - 1);

				dao.DeletarCliente(cliente);
				System.out.println("O Cliente Foi Deletado Com Sucesso.\n");

				break;

			}

			System.out.println("As Opções Disponíveis São:\n");

			System.out.println("1 - Listar Clientes.");
			System.out.println("2 - Editar Clientes.");
			System.out.println("3 - Deletar Clientes.");
			System.out.println("4 - Sair do Sistema.\n");

			System.out.print("Selecione Uma das Opções Apresentadas: ");

			menu = Menu.values()[Integer.parseInt(leitor.next()) - 1];
		}

		leitor.close();

		System.out.println("Saindo Do Sistema...");
		System.out.println("Muito Obrigado E Volte Sempre.");

	}

	private static void listarClientes(List<Cliente> clientes) {

		for (int i = 0; i < clientes.size(); i++) {

			Cliente cliente = clientes.get(i);

			System.out.println("Razão Social: " + cliente.getPessoaJuridica().getRazaoSocial());
			System.out.println("Nome Fantasia: " + cliente.getPessoaJuridica().getNomeFantasia());
			System.out.println("Cnpj: " + cliente.getPessoaJuridica().getCnpj());
            System.out.println("Telefone: " + cliente.getContato().getTelefone());
            System.out.println("Email: " + cliente.getContato().getEmail());
        	System.out.println("CEP: " + cliente.getEndereco().getCep());
        	System.out.println("Logradouro: " + cliente.getEndereco().getLogradouro());
        	System.out.println("Numero: " + cliente.getEndereco().getNumero());
        	System.out.println("Bairro: " + cliente.getEndereco().getBairro());
        	System.out.println("Cidade: " + cliente.getEndereco().getCidade());
        	System.out.println("UF: " + cliente.getEndereco().getUf());
        	System.out.println("Complemento: " + cliente.getEndereco().getComplemento());


			System.out.print("\n");
		}
	}

 }

