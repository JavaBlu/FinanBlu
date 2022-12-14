package br.senac.finanblu.principal;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import br.senac.finanblu.modelo.dao.venda.VendaDAO;
import br.senac.finanblu.modelo.dao.venda.VendaDAOImpl;
import br.senac.finanblu.modelo.entidade.venda.Venda;
import br.senac.finanblu.modelo.enumeracao.AtributoVenda;
import br.senac.finanblu.modelo.enumeracao.FormaPagamento;
import br.senac.finanblu.modelo.enumeracao.Menu;
import br.senac.finanblu.modelo.enumeracao.Ordem;

public class Principal {

	/*
	 * public static void main(String[] args) {
	 * 
	 * PessoaJuridicaDAO dao = new PessoaJuridicaDAOImpl(); List<PessoaJuridica>
	 * pessoasJuridicas = null;
	 * 
	 * System.out.println("Sejam Bem-Vindos.\n");
	 * 
	 * System.out.println("As Opções Disponíveis São:\n");
	 * 
	 * System.out.println("1 - Inserir Pessoa Juridica");
	 * System.out.println("2 - Listar Pessoas Juridicas");
	 * System.out.println("3 - Editar Pessoa Juridica");
	 * System.out.println("4 - Deletar Pessoa Juridica");
	 * 
	 * System.out.print("Selecione Uma das Opções Apresentadas: ");
	 * 
	 * Scanner leitor = new Scanner(System.in); Menu menu =
	 * Menu.values()[Integer.parseInt(leitor.next()) - 1];
	 * 
	 * switch (menu) { case INSERIR: dao.inserirPessoaJuridica(new
	 * PessoaJuridica("bjbasjfkafn", "gsgrgrgsgrgsg", "123456789-12345678"));
	 * System.out.println("Pessoa Salva Com Sucesso.\n"); break;
	 * 
	 * case LISTAR: System.out.println("\n");
	 * System.out.println("As Pessoas Juridicas cadastradas são:"); pessoasJuridicas
	 * = dao.recuperarPessoasJuridicas(); listarPessoasJuridicas(pessoasJuridicas);
	 * 
	 * break; case EDITAR: System.out.println("\n");
	 * System.out.println("As Pessoas Juridicas Cadastradas são:"); pessoasJuridicas
	 * = dao.recuperarPessoasJuridicas(); listarPessoasJuridicas(pessoasJuridicas);
	 * 
	 * System.out.print("Selecione Uma Das Pessoas Juridicas Para Editar: ");
	 * PessoaJuridica pessoaJuridica =
	 * pessoasJuridicas.get(Integer.valueOf(leitor.next()) - 1);
	 * 
	 * System.out.println("\n");
	 * 
	 * System.out.println("Os Opções Disponíveis são: ");
	 * System.out.println("1 - Editar A Razao Social Da Pessoa Juridica.");
	 * System.out.println("2 - Editar O Nome Fantasia Da Pessoa Juridica.");
	 * System.out.println("3 - Editar O CNPJ Da Pessoa Juridica.");
	 * 
	 * System.out.print("Selecione Uma Das Opções Apresentadas: ");
	 * 
	 * AtributoPessoaJuridica atributoPessoaJuridica = AtributoPessoaJuridica
	 * .values()[Integer.parseInt(leitor.next()) - 1];
	 * 
	 * switch (atributoPessoaJuridica) {
	 * 
	 * case RAZAOSOCIAL:
	 * 
	 * System.out.print("\n");
	 * System.out.print("Informe A Nova Razao Social Da Pessoa Juridica: ");
	 * 
	 * dao.atualizarRazaoSocial(pessoaJuridica, leitor.next());
	 * 
	 * break;
	 * 
	 * case NOMEFANTASIA:
	 * 
	 * System.out.print("\n");
	 * System.out.print("Informe O Novo Nome Fantasia Da Pessoa Juridica:");
	 * 
	 * dao.atualizarNomeFantasia(pessoaJuridica, leitor.next());
	 * 
	 * break;
	 * 
	 * case CNPJ:
	 * 
	 * System.out.print("\n");
	 * System.out.print("Informe o Novo CNPJ Da Pessoa Juridica:");
	 * 
	 * dao.atualizarCnpj(pessoaJuridica, leitor.next());
	 * 
	 * break;
	 * 
	 * }
	 * 
	 * System.out.println("\nO Endereço Foi Editado Com Sucesso.\n");
	 * 
	 * break;
	 * 
	 * case DELETAR:
	 * 
	 * System.out.print("\n");
	 * System.out.println("s Pessoas Juridicas Cadastrados São:\n");
	 * pessoasJuridicas = dao.recuperarPessoasJuridicas();
	 * listarPessoasJuridicasNumeradas(pessoasJuridicas);
	 * System.out.print("Selecione Uma Das Pessoas Juridicas Para deletar: ");
	 * pessoaJuridica = pessoasJuridicas.get(Integer.valueOf(leitor.next()) - 1);
	 * 
	 * dao.deletarPessoaJuridica(pessoaJuridica);
	 * System.out.println("A Pessoa Juridica Foi Deletada Com Sucesso.\n");
	 * 
	 * default: break;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * private static void listarPessoasJuridicas(List<PessoaJuridica>
	 * pessoasJuridicas) { for (int i = 0; i < pessoasJuridicas.size(); i++) {
	 * 
	 * PessoaJuridica pessoaJuridica = pessoasJuridicas.get(i);
	 * 
	 * System.out.println("Razao Social: " + pessoaJuridica.getRazaoSocial());
	 * System.out.println("Nome Fantasia " + pessoaJuridica.getNomeFantasia());
	 * System.out.println("Cnpj: " + pessoaJuridica.getCnpj());
	 * System.out.print("\n"); } }
	 * 
	 * private static void listarPessoasJuridicasNumeradas(List<PessoaJuridica>
	 * pessoasJuridicas) { for (int i = 0; i < pessoasJuridicas.size(); i++) {
	 * PessoaJuridica pessoaJuridica = pessoasJuridicas.get(i);
	 * System.out.println("Endereço do Número " + (i + 1));
	 * System.out.println("Razao Social " + pessoaJuridica.getRazaoSocial());
	 * System.out.println("Nome Fantasia " + pessoaJuridica.getNomeFantasia());
	 * System.out.println("Cnph: " + pessoaJuridica.getCnpj());
	 * System.out.println("\n"); } }
	 * 
	 * }
	 * 
	 * public static void main(String[] args) {
	 * 
	 * EmpresaDAO dao = new EmpresaDAOImpl(); List<Empresa> empresas = null;
	 * 
	 * System.out.println("Sejam Bem-Vindos.\n");
	 * 
	 * System.out.println("As Opções Disponíveis São:\n");
	 * 
	 * System.out.println("1 - Inserir Empresa");
	 * System.out.println("2 - Listar Empresa");
	 * System.out.println("3 - Editar Empresa");
	 * System.out.println("4 - Deletar Empresa ");
	 * 
	 * System.out.print("Selecione Uma das Opções Apresentadas: ");
	 * 
	 * Scanner leitor = new Scanner(System.in); Menu menu =
	 * Menu.values()[Integer.parseInt(leitor.next()) - 1];
	 * 
	 * switch (menu) { case INSERIR: dao.inserirEmpresa(null);
	 * System.out.println("Pessoa Salva Com Sucesso.\n"); break;
	 * 
	 * case LISTAR: System.out.println("\n");
	 * System.out.println("As Empresas cadastradas são:"); empresas =
	 * dao.recuperarEmpresas(); listarEmpresas(empresas);
	 * 
	 * break;
	 * 
	 * case EDITAR:
	 * 
	 * System.out.println("\n"); System.out.println("As Empresas Cadastradas são:");
	 * empresas = dao.recuperarEmpresas(); listarEmpresas(empresas);
	 * System.out.print("Selecione Uma Das Empresas Para Editar: "); Empresa empresa
	 * = empresas.get(Integer.valueOf(leitor.next()) - 1);
	 * 
	 * System.out.println("\n");
	 * 
	 * System.out.println("Os Opções Disponíveis são: ");
	 * System.out.println("1 - Editar A Razao Social Da Empresa.");
	 * System.out.println("2 - Editar O Nome Fantasia Da Empresa.");
	 * System.out.println("3 - Editar O CNPJ Da Empresa.");
	 * System.out.println("4 - Editar O Telefone Da Empresa.");
	 * System.out.println("5 - Editar O Email Da Empresa.");
	 * System.out.println("6 - Editar A Senha Da Empresa.");
	 * System.out.print("Selecione Uma Das Opções Apresentadas: ");
	 * 
	 * AtributoEmpresa atributoEmpresa =
	 * AtributoEmpresa.values()[Integer.parseInt(leitor.next()) - 1];
	 * 
	 * switch (atributoEmpresa) {
	 * 
	 * case RAZAOSOCIAL:
	 * 
	 * System.out.print("\n");
	 * System.out.print("Informe A Nova Razao Social Da Empresa: ");
	 * 
	 * dao.atualizarRazaoSocial(empresa, leitor.next());
	 * 
	 * break;
	 * 
	 * case NOMEFANTASIA:
	 * 
	 * System.out.print("\n");
	 * System.out.print("Informe O Novo Nome Fantasia Da Empresa:");
	 * 
	 * dao.atualizarNomeFantasia(empresa, leitor.next());
	 * 
	 * break;
	 * 
	 * case CNPJ:
	 * 
	 * System.out.print("\n"); System.out.print("Informe o Novo CNPJ Da Empresa:");
	 * 
	 * dao.atualizarCnpj(empresa, leitor.next());
	 * 
	 * break;
	 * 
	 * case TELEFONE: System.out.println("\n");
	 * System.out.println("Informe o Novo Telefone Da Empresa");
	 * 
	 * dao.atualizarTelefoneEmpresa(empresa, leitor.next()); break;
	 * 
	 * case EMAIL: System.out.println("\n");
	 * System.out.println("Informe o novo Email Da Empresa");
	 * dao.atualizarEmailEmpresa(empresa, leitor.next()); break;
	 * 
	 * case SENHA: System.out.println("\n");
	 * System.out.println("Informe a nova Senha da Empresa");
	 * dao.atualizarSenha(empresa, leitor.next()); }
	 * 
	 * System.out.println("\nA Empresa Foi Editado Com Sucesso.\n");
	 * 
	 * break;
	 * 
	 * case DELETAR: System.out.print("\n");
	 * System.out.println(" Empresas Cadastradas São:\n"); empresas =
	 * dao.recuperarEmpresas(); listarEmpresasNumeradas(empresas);
	 * System.out.print("Selecione Uma Das Empresas Para deletar: "); empresa =
	 * empresas.get(Integer.valueOf(leitor.next()) - 1);
	 * 
	 * dao.deletarEmpresa(empresa);
	 * 
	 * System.out.println("A Empresa Foi Deletada Com Sucesso.\n");
	 * 
	 * default: break;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * private static void listarEmpresas(List<Empresa> empresas) { for (int i = 0;
	 * i < empresas.size(); i++) { Empresa empresa = empresas.get(i);
	 * System.out.println("Razao Social: " +
	 * empresa.getPessoaJuridica().getRazaoSocial());
	 * System.out.println("Nome Fantasia " +
	 * empresa.getPessoaJuridica().getNomeFantasia()); System.out.println("Cnpj: " +
	 * empresa.getPessoaJuridica().getCnpj()); System.out.println("Telefone: " +
	 * empresa.getContato().getTelefone()); System.out.println("Email: " +
	 * empresa.getContato().getEmail()); System.out.println("Senha: " +
	 * empresa.getSenha()); System.out.print("\n"); } } private static void
	 * listarEmpresasNumeradas(List<Empresa> empresas) { for (int i = 0; i <
	 * empresas.size(); i++) { Empresa empresa = empresas.get(i);
	 * System.out.println("Empresa do Número " + (i + 1));
	 * System.out.println("Razao Social " +
	 * empresa.getPessoaJuridica().getRazaoSocial());
	 * System.out.println("Nome Fantasia " +
	 * empresa.getPessoaJuridica().getNomeFantasia()); System.out.println("CNPJ: " +
	 * empresa.getPessoaJuridica().getCnpj()); System.out.println("Telefone:" +
	 * empresa.getContato().getTelefone()); System.out.println("Email: " +
	 * empresa.getContato().getEmail());
	 * 
	 * System.out.println("\n"); } }
	 * 
	 * public static void main(String[] args) { Endereco endereco = new Endereco();
	 * endereco.setCep("1023310"); endereco.setLogradouro("fsafgsvdsba");
	 * endereco.setNumero((short) 123); endereco.setBairro("Bairaffasfr");
	 * endereco.setCidade("Cidaofqf"); endereco.setUf("Rn");
	 * endereco.setComplemento("53");
	 * 
	 * EnderecoDAO dao = new EnderecoDAOImpl(); dao.inserirEndereco(endereco);
	 * 
	 * Contato contato = new Contato(); contato.setEmail("s2bur32o.com");
	 * contato.setTelefone("4231621693"); ContatoDAO contatodao = new
	 * ContatoDAOImpl(); contatodao.inserirContato(contato);
	 * 
	 * PessoaJuridica pessoaJuridica = new PessoaJuridica();
	 * pessoaJuridica.setCnpj("127756112-22745673");
	 * pessoaJuridica.setNomeFantasia("abag14ia");
	 * pessoaJuridica.setRazaoSocial("se3m01a"); PessoaJuridicaDAO pjdao = new
	 * PessoaJuridicaDAOImpl(); pjdao.inserirPessoaJuridica(pessoaJuridica);
	 * 
	 * Cliente cliente = new Cliente(); cliente.setPessoaJuridica(pessoaJuridica);
	 * cliente.setContato(contato); cliente.setEndereco(endereco);
	 * 
	 * ClienteDAO clientedao = new ClienteDAOImpl();
	 * clientedao.InserirCliente(cliente); }
	 * 
	 * 
	 * public static void main(String[] args) { ClienteDAO dao = new
	 * ClienteDAOImpl(); List<Cliente> clientes = null;
	 * 
	 * System.out.println("Sejam Bem-Vindos.\n");
	 * 
	 * System.out.println("As Opções Disponíveis São:\n");
	 * 
	 * System.out.println("1 - Listar Clientes.");
	 * System.out.println("2 - Editar Clientes.");
	 * System.out.println("3 - Deletar Clientes.");
	 * System.out.println("4 - Sair do Sistema.\n");
	 * 
	 * System.out.print("Selecione Uma das Opções Apresentadas: ");
	 * 
	 * Scanner leitor = new Scanner(System.in); Menu menu =
	 * Menu.values()[Integer.parseInt(leitor.next()) - 1];
	 * 
	 * while (menu != Menu.SAIR) {
	 * 
	 * switch (menu) {
	 * 
	 * case LISTAR:
	 * 
	 * clientes = dao.recuperarClientes(); listarClientes(clientes);
	 * 
	 * break;
	 * 
	 * case EDITAR:
	 * 
	 * System.out.print("\n"); System.out.println("Os Clientes Cadastrados São:\n");
	 * 
	 * clientes = dao.recuperarClientes(); listarClientes(clientes);
	 * 
	 * System.out.print("Selecione Um Dos Clientes Para Editar: "); Cliente cliente
	 * = clientes.get(Integer.parseInt(leitor.next()) - 1);
	 * 
	 * System.out.print("\n");
	 * 
	 * System.out.println("As Opções Disponíveis São:\n");
	 * 
	 * System.out.println("1 - Editar A Razao Social Do Cliente.");
	 * System.out.println("2 - Editar O Nome Fantasia Do Cliente.");
	 * System.out.println("3 - Editar O CNPJ Do Cliente.");
	 * System.out.println("4 - Editar O Telefone Do Cliente.");
	 * System.out.println("5 - Editar O Email Do Cliente.");
	 * System.out.println("6 - Editar O CEP Do Cliente.");
	 * System.out.println("7 - Editar O Logradouro Do Cliente.");
	 * System.out.println("8 - Editar O Numero Do Cliente.");
	 * System.out.println("9 - Editar O Bairro Do Cliente.");
	 * System.out.println("10 - Editar O Cidade Do Cliente.");
	 * System.out.println("11 - Editar O UF Do Cliente.");
	 * System.out.println("12 - Editar O Complemento Do Cliente.");
	 * System.out.print("Selecione Uma Das Opções Apresentadas: "); AtributoCliente
	 * atributoCliente = AtributoCliente.values()[Integer.parseInt(leitor.next()) -
	 * 1];
	 * 
	 * switch (atributoCliente) {
	 * 
	 * case RAZAOSOCIAL:
	 * 
	 * System.out.print("\n");
	 * System.out.print("Informe A Nova Razao Social Do Cliente: ");
	 * 
	 * dao.AtualizarRazaoSocial(cliente, leitor.next());
	 * 
	 * break;
	 * 
	 * case NOMEFANTASIA:
	 * 
	 * System.out.print("\n");
	 * System.out.print("Informe O Novo Nome Fantasia Do Cliente:");
	 * 
	 * dao.AtualizarNomeFantasia(cliente, leitor.next());
	 * 
	 * break;
	 * 
	 * case CNPJ:
	 * 
	 * System.out.print("\n"); System.out.print("Informe o Novo CNPJ Do Cliente:");
	 * 
	 * dao.AtualizarCnpj(cliente, leitor.next());
	 * 
	 * break;
	 * 
	 * case TELEFONE: System.out.println("\n");
	 * System.out.println("Informe o Novo Telefone Do Cliente");
	 * 
	 * dao.AtualizarTelefoneCliente(cliente, leitor.next()); break;
	 * 
	 * case EMAIL: System.out.println("\n");
	 * System.out.println("Informe o novo Email Da Empresa");
	 * dao.AtualizarEmailCliente(cliente, leitor.next()); break;
	 * 
	 * case CEP: System.out.println("\n");
	 * System.out.println("Informe a novo CEP Do Cliente");
	 * dao.atualizarCepEndereco(cliente, leitor.next());
	 * 
	 * break; case LOGRADOURO: System.out.println("\n");
	 * System.out.println("Informe a novo Logradouro Do Cliente");
	 * dao.atualizarLogradouroEndereco(cliente, leitor.next());
	 * 
	 * break; case NUMERO: System.out.println("\n");
	 * System.out.println("Informe a novo Numero Do Cliente");
	 * dao.atualizarNumeroEndereco(cliente, leitor.nextShort());
	 * 
	 * break; case BAIRRO: System.out.println("\n");
	 * System.out.println("Informe a novo Bairro Do Cliente");
	 * dao.atualizarBairroEndereco(cliente, leitor.next());
	 * 
	 * break; case CIDADE: System.out.println("\n");
	 * System.out.println("Informe a novo Cidade Do Cliente");
	 * dao.atualizarCidadeEndereco(cliente, leitor.next());
	 * 
	 * break;
	 * 
	 * case UF: System.out.println("\n");
	 * System.out.println("Informe a nova UF Do Cliente");
	 * dao.atualizarUfEndereco(cliente, leitor.next()); break;
	 * 
	 * case COMPLEMENTO: System.out.println("\n");
	 * System.out.println("Informe a novo Complemento Do Cliente");
	 * dao.atualizarComplementoEndereco(cliente, leitor.next());
	 * 
	 * break;
	 * 
	 * }
	 * 
	 * System.out.println("\nA Empresa Foi Editado Com Sucesso.\n");
	 * 
	 * break;
	 * 
	 * case DELETAR:
	 * 
	 * System.out.print("\n"); System.out.println("Os Clientes Cadastrados São:\n");
	 * 
	 * clientes = dao.recuperarClientes(); listarClientes(clientes);
	 * 
	 * System.out.print("Selecione Um Dos Clientes Para deletar: "); cliente =
	 * clientes.get(Integer.parseInt(leitor.next()) - 1);
	 * 
	 * dao.DeletarCliente(cliente);
	 * System.out.println("O Cliente Foi Deletado Com Sucesso.\n");
	 * 
	 * break;
	 * 
	 * }
	 * 
	 * System.out.println("As Opções Disponíveis São:\n");
	 * 
	 * System.out.println("1 - Listar Clientes.");
	 * System.out.println("2 - Editar Clientes.");
	 * System.out.println("3 - Deletar Clientes.");
	 * System.out.println("4 - Sair do Sistema.\n");
	 * 
	 * System.out.print("Selecione Uma das Opções Apresentadas: ");
	 * 
	 * menu = Menu.values()[Integer.parseInt(leitor.next()) - 1]; }
	 * 
	 * leitor.close();
	 * 
	 * System.out.println("Saindo Do Sistema...");
	 * System.out.println("Muito Obrigado E Volte Sempre.");
	 * 
	 * }
	 * 
	 * private static void listarClientes(List<Cliente> clientes) {
	 * 
	 * for (int i = 0; i < clientes.size(); i++) {
	 * 
	 * Cliente cliente = clientes.get(i);
	 * 
	 * System.out.println("Razão Social: " +
	 * cliente.getPessoaJuridica().getRazaoSocial());
	 * System.out.println("Nome Fantasia: " +
	 * cliente.getPessoaJuridica().getNomeFantasia()); System.out.println("Cnpj: " +
	 * cliente.getPessoaJuridica().getCnpj()); System.out.println("Telefone: " +
	 * cliente.getContato().getTelefone()); System.out.println("Email: " +
	 * cliente.getContato().getEmail()); System.out.println("CEP: " +
	 * cliente.getEndereco().getCep()); System.out.println("Logradouro: " +
	 * cliente.getEndereco().getLogradouro()); System.out.println("Numero: " +
	 * cliente.getEndereco().getNumero()); System.out.println("Bairro: " +
	 * cliente.getEndereco().getBairro()); System.out.println("Cidade: " +
	 * cliente.getEndereco().getCidade()); System.out.println("UF: " +
	 * cliente.getEndereco().getUf()); System.out.println("Complemento: " +
	 * cliente.getEndereco().getComplemento());
	 * 
	 * System.out.print("\n"); } }
	 */
	public static void main(String[] args) {
		/*
		 * float valorVenda = 5000; LocalDate dataVenda = LocalDate.now();
		 * FormaPagamento formaPagamento = FormaPagamento.CARTAO_CREDITO; short parcela
		 * = (short) 5; Cliente cliente = new Cliente(11L); Venda venda = new
		 * Venda(cliente, valorVenda, dataVenda, formaPagamento, parcela); VendaDAO dao
		 * = new VendaDAOImpl(); dao.inserirVenda(venda); }
		 */

		VendaDAO dao = new VendaDAOImpl();
		List<Venda> vendas = null;

		System.out.println("Sejam Bem-Vindos.\n");

		System.out.println("As Opções Disponíveis São:\n");

		System.out.println("1 - Listar Clientes.");
		System.out.println("2 - Editar Clientes.");
		System.out.println("3 - Deletar Clientes.");
		System.out.println("4 - Sair do Sistema.\n");

		System.out.print("Selecione Uma das Opções Apresentadas: ");

		Scanner leitor = new Scanner(System.in);
		Menu menu = Menu.values()[Integer.parseInt(leitor.next()) - 1];
		// while (menu != Menu.SAIR) {
		switch (menu) {

		case LISTAR:
			vendas = dao.recuperarVendas();
			listarVendas(vendas);
			System.out.print("\n");

			System.out.println("As Opções Disponíveis São:\n");

			System.out.println("1 - Listar Vendas pela Data.");
			System.out.println("2 - Listar Vendas pelo Cliente.");

			System.out.print("Selecione Uma Das Opções Apresentadas: ");

			AtributoVenda atributoVenda = AtributoVenda.values()[Integer.parseInt(leitor.next()) - 1];
			Ordem ordem = null;

			System.out.println("\nAs Opções Disponíveis São:\n");

			System.out.println("1 - Listar Em Ordem Ascendente.");
			System.out.println("2 - Listar Em Ordem Descendente.\n");

			System.out.print("Selecione Uma Das Opções Apresentadas: ");


			ordem = Ordem.values()[Integer.parseInt(leitor.next()) - 1];

			switch (atributoVenda) {

			case DATAVENDA:

				switch (ordem) {

				case ASCENDENTE:
					vendas = dao.recuperarVendasPorOrdemDataAscendente();
					listarVendas(vendas);
					break;

				case DESCENDENTE:
					vendas = dao.recuperarVendasPorOrdemDataDescendente();
					break;
				}
				break;
				
			case CLIENTE:

				switch (ordem) {

				case ASCENDENTE:
					vendas = dao.recuperarVendasPorOrdemClienteAscendente();
					break;

				case DESCENDENTE:
					vendas = dao.recuperarVendasPorOrdemClienteDescendente();
					break;
				}
				break;

			}
			listarVendas(vendas);
			break;

		}

		/*
		 * case EDITAR:
		 * 
		 * System.out.print("\n"); System.out.println("Os Clientes Cadastrados São:\n");
		 * 
		 * vendas = dao.recuperarVendas(); listarVendas(vendas);
		 * 
		 * System.out.print("Selecione Um Dos Clientes Para Editar: "); Venda venda =
		 * vendas.get(Integer.parseInt(leitor.next()) - 1);
		 * 
		 * System.out.print("\n");
		 * 
		 * System.out.println("As Opções Disponíveis São:\n");
		 * 
		 * System.out.println("1 - Editar A Razao Social Do Cliente.");
		 * System.out.println("2 - Editar O Nome Fantasia Do Cliente.");
		 * System.out.println("3 - Editar O CNPJ Do Cliente.");
		 * System.out.println("4 - Editar O Valor Da Venda.");
		 * System.out.println("5 - Editar O Data da Venda.");
		 * System.out.println("6 - Editar O Forma De Pagamento.");
		 * System.out.print("Selecione Uma Das Opções Apresentadas: "); atributoVenda =
		 * AtributoVenda.values()[Integer.parseInt(leitor.next()) - 1];
		 * 
		 * 
		 * switch (atributoVenda) {
		 * 
		 * // RAZAOSOCIAL:
		 * 
		 * System.out.print("\n");
		 * System.out.print("Informe A Nova Razao Social Do Cliente: ");
		 * 
		 * dao.atualizarRazaoSocialCliente(venda, leitor.next());
		 * 
		 * break;
		 * 
		 * // case NOMEFANTASIA:
		 * 
		 * System.out.print("\n");
		 * System.out.print("Informe O Novo Nome Fantasia Do Cliente:");
		 * 
		 * dao.atualizarNomeFantasiaCliente(venda, leitor.next());
		 * 
		 * break;
		 * 
		 * case CNPJ:
		 * 
		 * System.out.print("\n"); System.out.print("Informe o Novo CNPJ Do Cliente:");
		 * 
		 * dao.atualizarCnpjCliente(venda, leitor.next());
		 * 
		 * break;
		 * 
		 * case DATAVENDA: System.out.println("\n");
		 * System.out.println("Informe a Data da Venda:");
		 * 
		 * dao.atualizarDataVenda(venda, LocalDate.parse(leitor.next()));
		 * 
		 * break;
		 * 
		 * case FORMAPAGAMENTO: System.out.println("\n");
		 * System.out.println("Informe a Forma de Pagamento");
		 * dao.atualizarFormaPagamento(venda, FormaPagamento.valueOf(leitor.next()));
		 * break;
		 * 
		 * case VALORVENDA: System.out.println("\n");
		 * System.out.println("Informe o Valor da Venda");
		 * 
		 * dao.atualizarValorVenda(venda, leitor.nextFloat()); break;
		 * 
		 * case PARCELA: System.out.println("\n");
		 * System.out.println("Informe a nova Parcela"); dao.atualizarParcela(venda,
		 * leitor.nextShort()); break; }
		 * 
		 * System.out.println("\nA Empresa Foi Editado Com Sucesso.\n"); break; case
		 * DELETAR: System.out.print("\n");
		 * System.out.println("Os Clientes Cadastrados São:\n");
		 * 
		 * vendas = dao.recuperarVendas(); listarVendas(vendas);
		 * 
		 * System.out.print("Selecione Um Dos Clientes Para deletar: "); venda =
		 * vendas.get(Integer.parseInt(leitor.next()) - 1);
		 * 
		 * dao.deletarVenda(venda);
		 * System.out.println("O Cliente Foi Deletado Com Sucesso.\n");
		 * 
		 * break; } System.out.println("As Opções Disponíveis São:\n");
		 * 
		 * System.out.println("1 - Listar Clientes.");
		 * System.out.println("2 - Editar Clientes.");
		 * System.out.println("3 - Deletar Clientes.");
		 * System.out.println("4 - Sair do Sistema.\n");
		 * 
		 * System.out.print("Selecione Uma das Opções Apresentadas: ");
		 * 
		 * menu = Menu.values()[Integer.parseInt(leitor.next()) - 1]; }
		 * 
		 * leitor.close();
		 * 
		 * System.out.println("Saindo Do Sistema...");
		 * System.out.println("Muito Obrigado E Volte Sempre.");
		 */
	}

	private static void listarVendas(List<Venda> vendas) {

		for (int i = 0; i < vendas.size(); i++) {

			Venda venda = vendas.get(i);
			System.out.println("ID venda: " + venda.getId());
			System.out.println("ID Cliente: " + venda.getCliente().getId());
			System.out.println("Razão Social: " + venda.getCliente().getPessoaJuridica().getRazaoSocial());
			System.out.println("Nome Fantasia: " + venda.getCliente().getPessoaJuridica().getNomeFantasia());
			System.out.println("Cnpj: " + venda.getCliente().getPessoaJuridica().getCnpj());
			System.out.println("Valor da Venda: " + venda.getValorVenda());
			System.out.println("Data da Venda: " + venda.getDataVenda());
			System.out.println("Forma de Pagamento " + venda.getFormaPagamento());
			System.out.println("Parcela " + venda.getParcela());

			System.out.print("\n");
		}
	}

}
