package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entidades.Venda;
import estrutura.ControlKey;
import gui.utils.Alerts;
import javafx.scene.control.Alert.AlertType;

public class VendaDaoFile implements VendaDao {

	@Override
	public void salvaVenda(Venda venda) {
		BufferedWriter buffWrite;
		try {
			buffWrite = new BufferedWriter(new FileWriter(ControlKey.FILE_DATABASE.getString(), true));
			buffWrite.append(String.format(ControlKey.MSG_VENDA_ARQUIVO.getString(), venda.getPeso(), venda.getValorUnitario(), venda.getPreco()));
			buffWrite.close();
		} catch (IOException e) {
			mostraErroNaoSalvouVenda();
			e.printStackTrace();
		}
	}

	private void mostraErroNaoSalvouVenda() {
		Alerts.showAlert(ControlKey.ERRO.getString(), ControlKey.TEXTO_VAZIO.getString(), ControlKey.MSG_NAO_SALVOU_VENDA.getString(), AlertType.ERROR);
	}

	@Override
	public List<Venda> recuperaVendas() {
		try {
			BufferedReader buffRead = new BufferedReader(new FileReader(ControlKey.FILE_DATABASE.getString()));
			List<Venda> registros = new ArrayList<Venda>();
			String linha = ControlKey.TEXTO_VAZIO.getString();
			do {
				linha = buffRead.readLine();
				if (linha != null)
					registros.add(new Venda(linha));
			} while (linha != null);
			buffRead.close();
			return registros;
		}
		catch(IOException e) {
			mostraErroRecuperacaVendas();
			e.printStackTrace();
		}
		return null;
	}

	private void mostraErroRecuperacaVendas() {
		Alerts.showAlert(ControlKey.ERRO.getString(), ControlKey.TEXTO_VAZIO.getString(), ControlKey.ERRO_RECUPERACA_VENDAS.getString(), AlertType.ERROR);
	}

}
