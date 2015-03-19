package model;

import java.io.Serializable;

public class Produto implements Serializable {

	private int codigo;
	private String descricao;
	private int quantidadeEmEstoque;

	public Produto(int codigo, String descricao, int quantidadeEmEstoque) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(int quantidade) {
		this.quantidadeEmEstoque = quantidade;
	}
	
	public String toString(){
		return "cod: "+ this.codigo
				+ " | Descrição: " + this.descricao
				+ " | Qtd em estoque: "+ this.quantidadeEmEstoque;
	}

}
