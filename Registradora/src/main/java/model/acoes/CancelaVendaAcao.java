package model.acoes;

import gui.ViewController;
import gui.utils.Alerts;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.ControlKey;
import model.entidades.Venda;
import model.interfaces.Acao;

public class CancelaVendaAcao implements Acao {

	private TextField visor;
	private Venda venda;

	public CancelaVendaAcao(ViewController viewController) {
		this.visor = viewController.getVisor();
		this.venda = viewController.getVenda();
	}

	@Override
	public void executa() {
		venda.anula();
		visor.setText(ControlKey.TEXTO_VAZIO.getString());
		visor.setPromptText(ControlKey.INFORME_PESO.getString());
		Alerts.showAlert(ControlKey.CONFIRMACAO.getString(), ControlKey.TEXTO_VAZIO.getString(),
				ControlKey.VENDA_CANCELADA.getString(), AlertType.INFORMATION);

	}

}
