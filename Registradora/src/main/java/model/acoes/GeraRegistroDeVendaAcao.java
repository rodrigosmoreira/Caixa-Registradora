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
import model.ControlKey;
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
			Alerts.showAlert(ControlKey.AVISO.getString(), ControlKey.TEXTO_VAZIO.getString(),
					ControlKey.NENHUMA_VENDA_REGISTRADA.getString(), AlertType.WARNING);
			e.printStackTrace();
		} catch (IOException e) {
			Alerts.showAlert(ControlKey.ERRO.getString(), ControlKey.TEXTO_VAZIO.getString(),
					ControlKey.ERRO_REGISTRO_VENDA.getString(), AlertType.ERROR);
			e.printStackTrace();
		}
	}

	private void leRegistros() throws FileNotFoundException, IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(ControlKey.FILE_DATABASE.getString()));
		String linha = ControlKey.TEXTO_VAZIO.getString();
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
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(ControlKey.FILE_REGISTROS.getString()));
		for (Venda reg : registros)
			buffWrite.append(reg + ControlKey.PULA_LINHA.getString());
		buffWrite.append(String.format(ControlKey.MSG_TOTAL_DE_VENDAS.getString(), precoTotal()));
		buffWrite.close();
	}

	private void imprimeRegistroDeVendaNoVisor() {
		StringBuilder sb = new StringBuilder();
		for (Venda reg : registros)
			sb.append(reg + ControlKey.PULA_LINHA.getString());
		sb.append(String.format(ControlKey.MSG_TOTAL_DE_VENDAS.getString(), precoTotal()));
		Alerts.showAlert(ControlKey.REGISTRO_DE_VENDA.getString(), ControlKey.MSG_REGISTRO_SALVO_ARQUIVO.getString(),
				sb.toString(), AlertType.INFORMATION);
	}

	private Double precoTotal() {
		Double resultado = 0.0;
		for (Venda reg : registros)
			resultado += reg.getPreco();
		return resultado;
	}

}
