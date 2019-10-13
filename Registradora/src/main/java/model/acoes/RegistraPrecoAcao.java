package model.acoes;

import gui.ViewController;
import gui.utils.Alerts;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.entidades.Venda;
import model.interfaces.Acao;

public class RegistraPrecoAcao implements Acao {

	private TextField visor;
	private Venda venda;
	private Button botao;

	public RegistraPrecoAcao(ViewController viewController) {
		this.visor = viewController.getVisor();
		this.venda = viewController.getVenda();
		this.botao = viewController.getBotao();
	}

	@Override
	public void executa() {
		try {
			venda.setValorUnitario(visor.getText());
			venda.calculaPreco();
			venda.salva();
			visor.setText("");
			visor.setPromptText("Informe o peso");
			Alerts.showAlert("Resultado", "", "Valor a ser pago R$ " + venda.getPreco(), AlertType.INFORMATION);
			botao.setId("RegistraPesoAcao");
		} catch (Exception e) {
			Alerts.showAlert("Aviso", "", "Informe o valor unitario", AlertType.WARNING);
		}
	}

}
