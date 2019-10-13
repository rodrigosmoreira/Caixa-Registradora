package model.acoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gui.ViewController;
import gui.utils.Alerts;
import javafx.scene.control.Alert.AlertType;
import model.entidades.Venda;
import model.exception.NenhumaVendaRegistradaException;
import model.interfaces.Acao;

public class GeraRegistroDeVendaAcao implements Acao {

	private List<Venda> registros = new ArrayList<Venda>();

	public GeraRegistroDeVendaAcao(ViewController viewController) {
	}

	@Override
	public void executa() {
		try {
			leRegistros();
			if (contemRegistros()) {
				imprimeRegistroDeVendaNoArquivo();
				imprimeRegistroDeVendaNoVisor();
			} else
				throw new NenhumaVendaRegistradaException();
		} catch (FileNotFoundException | NenhumaVendaRegistradaException e) {
			Alerts.showAlert("Aviso", "", "Nenhuma venda foi registrada", AlertType.WARNING);
			e.printStackTrace();
		} catch (IOException e) {
			Alerts.showAlert("Erro ", "", "Erro na geracao do total de vendas", AlertType.ERROR);
			e.printStackTrace();
		}
	}

	private void leRegistros() throws FileNotFoundException, IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader("database.txt"));
		String linha = "";
		do {
			linha = buffRead.readLine();
			if (linha != null)
				registros.add(new Venda(linha));
		} while (linha != null);
		buffRead.close();
	}

	private boolean contemRegistros() {
		return registros != null && registros.size() > 0;
	}

	private void imprimeRegistroDeVendaNoArquivo() throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("registros.txt"));
		for (Venda reg : registros)
			buffWrite.append(reg + "\n");
		buffWrite.append(String.format("Total = R$ %.02f\n", precoTotal()));
		buffWrite.close();
	}

	private void imprimeRegistroDeVendaNoVisor() {
		StringBuilder sb = new StringBuilder();
		for (Venda reg : registros)
			sb.append(reg + "\n");
		sb.append(String.format("Total = R$ %.02f\n", precoTotal()));
		Alerts.showAlert("Registro de Venda", "Salvo no arquivo 'registros.txt' no projeto", sb.toString(), AlertType.INFORMATION);
	}

	private Double precoTotal() {
		Double resultado = 0.0;
		for (Venda reg : registros)
			resultado += reg.getPreco();
		return resultado;
	}

}
