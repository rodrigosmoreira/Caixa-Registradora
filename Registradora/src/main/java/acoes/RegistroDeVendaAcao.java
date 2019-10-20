package acoes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import entidades.Venda;
import estrutura.ControlKey;
import exceptions.NenhumaVendaRegistradaException;
import gui.ViewController;
import gui.utils.Alerts;
import javafx.scene.control.Alert.AlertType;

public class RegistroDeVendaAcao implements Acao {

	private List<Venda> vendas = new ArrayList<Venda>();
	private Double precoTotal;

	public RegistroDeVendaAcao(ViewController viewController) {
	}

	@Override
	public void executa() {
		try {
			vendas = DaoFactory.getInstanceVendaDao().recuperaVendas();
			if (seNaoExisteVenda()) throw new NenhumaVendaRegistradaException();
			calculaPrecoTotal();
			imprimeRegistroDeVendaNoVisor();
			imprimeRegistroDeVendaNoArquivo();
		} catch (NenhumaVendaRegistradaException e) {
			mostraAvisoNenhumaVendaRegistrada();
		} catch (IOException e) {
			mostraErroRegistroVenda();
			e.printStackTrace();
		}
	}

	private void mostraErroRegistroVenda() {
		Alerts.showAlert(ControlKey.ERRO.getString(), ControlKey.TEXTO_VAZIO.getString(),
				ControlKey.ERRO_REGISTRO_VENDA.getString(), AlertType.ERROR);
	}

	private void mostraAvisoNenhumaVendaRegistrada() {
		Alerts.showAlert(ControlKey.AVISO.getString(), ControlKey.TEXTO_VAZIO.getString(),
				ControlKey.NENHUMA_VENDA_REGISTRADA.getString(), AlertType.WARNING);
	}

	private boolean seNaoExisteVenda() {
		return vendas == null || vendas.size() == 0;
	}

	private void imprimeRegistroDeVendaNoArquivo() throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(ControlKey.FILE_REGISTROS.getString()));
		for (Venda reg : vendas)
			buffWrite.append(reg + ControlKey.PULA_LINHA.getString());
		buffWrite.append(String.format(ControlKey.MSG_TOTAL_DE_VENDAS.getString(), precoTotal));
		buffWrite.close();
	}

	private void imprimeRegistroDeVendaNoVisor() {
		StringBuilder sb = new StringBuilder();
		for (Venda reg : vendas)
			sb.append(reg + ControlKey.PULA_LINHA.getString());
		sb.append(String.format(ControlKey.MSG_TOTAL_DE_VENDAS.getString(), precoTotal));
		Alerts.showAlert(ControlKey.REGISTRO_DE_VENDA.getString(), ControlKey.MSG_REGISTRO_SALVO_ARQUIVO.getString(),
				sb.toString(), AlertType.INFORMATION);
	}

	private void calculaPrecoTotal() {
		Double soma = 0.0;
		for (Venda reg : vendas)
			soma += reg.getPreco();
		precoTotal = soma;
	}

}
