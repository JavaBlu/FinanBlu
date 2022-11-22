package br.senac.finanblu.modelo.entidade.empresa;

import br.senac.finanblu.modelo.entidade.contato.Contato;
import br.senac.finanblu.modelo.entidade.endereco.Endereco;
import br.senac.finanblu.modelo.entidade.pessoaJuridica.PessoaJuridica;

public class Empresa extends PessoaJuridica {
	private long id;
	private Endereco endereco;
	private Contato contato;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Empresa(String razaoSocial, String nomeFantasia, String cnpj, Contato contato, Endereco endereco, long id) {
		super(razaoSocial, nomeFantasia, cnpj);
		this.setId(id);
	}

	public Empresa(String razaoSocial, String nomeFantasia, String cnpj, Contato contato, Endereco endereco) {
		super(razaoSocial, nomeFantasia, cnpj);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean equals(Object objeto) {

		if (this == objeto)
			return true;

		if (objeto == null)
			return false;

		if (getClass() != objeto.getClass())
			return false;

		Empresa empresa = (Empresa) objeto;

		return getId() == empresa.getId() && getRazaoSocial().equals(empresa.getRazaoSocial())
				&& getNomeFantasia().equals(empresa.getNomeFantasia()) && getCnpj().equals(empresa.getCnpj());
	}
}