import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import control.ProdutoControl;

import model.Produto;

import file.ProdutoDao;

public class Main {

	public static void main(String[] args) {
		ProdutoDao dao = new ProdutoDao();

		try {
			dao.verificar();
			ProdutoControl pc = new ProdutoControl(dao);
			
			int option = 0;
			
			while(option != 3){
				printMenu();
				option = new Scanner(System.in).nextInt();
				
				switch(option){
					case 1 : 
						addProduto(pc);
						break;
					case 2 : 
						pc.listarProdutos();
						break;
					case 3:
						break;
					default:
						System.out.println("Opção inválida!");
				}
				
			}
			
		} catch (IOException e) {
			System.out.println("Erro na leitura/criação do arquivo!");
			e.printStackTrace();
		}
	}

	private static void addProduto(ProdutoControl pc) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Insira o código do produto:");
		int cod = in.nextInt();
		String descricao = JOptionPane.showInputDialog("Insira a descrição do produto:");
		System.out.println("Insira a quantidade do produto:");
		int qtdEmEstoque = in.nextInt();
		
		try {
			pc.addProduto(new Produto(cod, descricao, qtdEmEstoque));
			System.out.println("Produto add. com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro ao salvar!");
		}
		
	}

	private static void printMenu(){
		System.out.println("1 - add produto");
		System.out.println("2 - listar produtos");
		System.out.println("3 - sair");
	}

}
