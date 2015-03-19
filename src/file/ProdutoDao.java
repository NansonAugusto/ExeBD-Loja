package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Produto;

public class ProdutoDao {
	private String NAME = "out.dat";
	private File out;

	public ProdutoDao() {
		this.out = new File(NAME);
	}

	public void verificar() throws IOException {
		if (!this.out.exists()) {
			this.out.createNewFile();
		}
	}

	public ArrayList<Produto> read() throws IOException {
		ArrayList<Produto> listaProdutos;

		try {
			FileInputStream file = new FileInputStream(out);
			ObjectInputStream readObj = new ObjectInputStream(file);
			
			listaProdutos = (ArrayList<Produto>) readObj.readObject();
			
			readObj.close();
			file.close();
		} catch (Exception e) {
			listaProdutos = new ArrayList<>();
		}

		return listaProdutos;
	}

	public void write(ArrayList<Produto> listaProdutos) throws IOException {
		FileOutputStream file = new FileOutputStream(this.out);

		ObjectOutputStream writeObj = new ObjectOutputStream(file);

		writeObj.writeObject(listaProdutos);

		writeObj.flush();
		writeObj.close();
		file.flush();
		file.close();
	}
}
