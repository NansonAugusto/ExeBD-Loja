package control;

import java.io.IOException;
import java.util.ArrayList;

import file.ProdutoDao;

import model.Produto;

public class ProdutoControl {
	private ArrayList<Produto> listaProdutos;
	private ProdutoDao produtoDao;
	
	public ProdutoControl(ProdutoDao produtoDao) throws IOException{
		this.produtoDao = produtoDao;		
		this.listaProdutos = this.produtoDao.read();
	}
	
	public void addProduto(Produto produto) throws IOException{
		listaProdutos.add(produto);
		this.produtoDao.write(listaProdutos);
	}
	
	public void listarProdutos(){
		System.out.println("Lista\n");
		
		for(Produto p : listaProdutos){
			System.out.println(p);
		}
		
		System.out.println("\n");
	}

}
