package br.senac.finanblu.modelo.dao.empresa;

import java.util.List;

import br.senac.finanblu.modelo.entidade.contato.Contato;
import br.senac.finanblu.modelo.entidade.empresa.Empresa;

public interface EmpresaDAO {

	void inserirEmpresa(Empresa empresa);

	void deletarEmpresa(Empresa empresa);

	void atualizarRazaoSocial(Empresa empresa, String novaRazaoSocial);

	void atualizarNomeFantasia(Empresa empresa, String novoNomeFantasia);

	void atualizarCnpj(Empresa empresa, String novoCnpj);

	void atualizarTelefoneEmpresa(Empresa empresa, String novoTelefone);

	void atualizarEmailEmpresa(Empresa empresa, String novoEmail);

	void atualizarSenha(Empresa empresa, String novaSenha);

	List<Empresa> recuperarEmpresas();

}
