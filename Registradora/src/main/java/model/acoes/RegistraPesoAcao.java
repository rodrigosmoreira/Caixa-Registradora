package model.acoes;

import gui.ViewController;
import gui.utils.Alerts;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.entidades.Venda;
import model.interfaces.Acao;

public class RegistraPesoAcao implements Acao{

	private TextField visor;
	private Venda venda;
	private Button botao;

	public RegistraPesoAcao(ViewController viewController) {
		this.visor = viewController.getVisor();
		this.venda = viewController.getVenda();
		this.botao = viewController.getBotao();
	}

	@Override
	public void executa() {
		try {
			venda.setPeso(visor.getText());
			visor.setText("");
			visor.setPromptText("Informe o valor unitario");
			botao.setId("RegistraPrecoAcao");
		}
		catch(Exception e) {
			Alerts.showAlert("Aviso", "", "Informe o peso", AlertType.WARNING);
		}
	}

}
