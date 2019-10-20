package acoes;

import dao.DaoFactory;
import entidades.Venda;
import estrutura.ControlKey;
import gui.ViewController;
import gui.utils.Alerts;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class ConfirmaAcao implements Acao {

	private TextField visor;
	private Venda venda;

	public ConfirmaAcao(ViewController viewController) {
		this.visor = viewController.getVisor();
		this.venda = viewController.getVenda();
	}

	@Override
	public void executa() {
		if (venda.getPeso() == null)
			registraPeso();
		else
			registraValorUnitario();
	}

	private void registraPeso() {
		try {
			venda.setPeso(visor.getText());
			alteraVisorParaInformePeso();
		} catch (Exception e) {
			avisoInformePeso();
		}
	}

	private void avisoInformePeso() {
		Alerts.showAlert(ControlKey.AVISO.getString(), ControlKey.TEXTO_VAZIO.getString(),
				ControlKey.INFORME_PESO.getString(), AlertType.WARNING);
	}

	private void alteraVisorParaInformePeso() {
		visor.setText(ControlKey.TEXTO_VAZIO.getString());
		visor.setPromptText(ControlKey.INFORME_VALOR_UNITARIO.getString());
	}

	private void registraValorUnitario() {
		try {
			venda.setValorUnitario(visor.getText());
			venda.calculaPreco();
			DaoFactory.getInstanceVendaDao().salvaVenda(venda);
			alteraVisorParaInformeValorUnitario();
			venda.anula();
		} catch (Exception e) {
			avisoInformeValorUnitario();
		}
	}

	private void avisoInformeValorUnitario() {
		Alerts.showAlert(ControlKey.AVISO.getString(), ControlKey.TEXTO_VAZIO.getString(),
				ControlKey.INFORME_VALOR_UNITARIO.getString(), AlertType.WARNING);
	}

	private void alteraVisorParaInformeValorUnitario() {
		visor.setText(ControlKey.TEXTO_VAZIO.getString());
		visor.setPromptText(ControlKey.INFORME_PESO.getString());
		Alerts.showAlert(ControlKey.RESULTADO.getString(), ControlKey.TEXTO_VAZIO.getString(),
				String.format(ControlKey.VALOR_A_SER_PAGO.getString(), venda.getPreco()), AlertType.INFORMATION);
	}
}
