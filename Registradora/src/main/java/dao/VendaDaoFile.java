package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entidades.Venda;
import estrutura.enums.PATH;
import estrutura.enums.TEXTO;
import exceptions.NenhumaVendaRegistradaException;

public class VendaDaoFile implements VendaDao {
	
	private String path;

	public VendaDaoFile() {
		this.path = PATH.FILE_DATABASE.getPath();
	}

	@Override
	public void salvaVenda(Venda venda) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));
		buffWrite.append(String.format(TEXTO.FORMATO_VENDA_ARQUIVO.getTexto()
						, venda.getPeso(), venda.getValorUnitario(), venda.getPreco()));
		buffWrite.close();
	}

	@Override
	public List<Venda> recuperaVendas() throws IOException {
		List<Venda> retorno = new ArrayList<Venda>();
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = buffRead.readLine();
		while(linha != null) {
			retorno.add(new Venda(linha));
			linha = buffRead.readLine();
		}
		buffRead.close();
		if(retorno.isEmpty()) throw new NenhumaVendaRegistradaException();
		return retorno;
	}

}
