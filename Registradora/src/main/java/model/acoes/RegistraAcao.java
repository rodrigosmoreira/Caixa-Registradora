package model.acoes;

import gui.ViewController;
import gui.utils.Alerts;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.ControlKey;
import model.entidades.Venda;
import model.interfaces.Acao;

public class RegistraAcao implements Acao {

	private TextField visor;
	private Venda venda;

	public RegistraAcao(ViewController viewController) {
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
			visor.setText(ControlKey.TEXTO_VAZIO.getString());
			visor.setPromptText(ControlKey.INFORME_VALOR_UNITARIO.getString());
		} catch (Exception e) {
			Alerts.showAlert(ControlKey.AVISO.getString(), ControlKey.TEXTO_VAZIO.getString(),
					ControlKey.INFORME_PESO.getString(), AlertType.WARNING);
		}
	}

	private void registraValorUnitario() {
		try {
			venda.setValorUnitario(visor.getText());
			venda.calculaPreco();
			venda.salva();
			venda.anula();
			visor.setText(ControlKey.TEXTO_VAZIO.getString());
			visor.setPromptText(ControlKey.INFORME_PESO.getString());
			Alerts.showAlert(ControlKey.RESULTADO.getString(), ControlKey.TEXTO_VAZIO.getString(),
					String.format(ControlKey.VALOR_A_SER_PAGO.getString(), venda.getPreco()), AlertType.INFORMATION);
		} catch (Exception e) {
			Alerts.showAlert(ControlKey.AVISO.getString(), ControlKey.TEXTO_VAZIO.getString(),
					ControlKey.INFORME_VALOR_UNITARIO.getString(), AlertType.WARNING);
		}
	}
}
