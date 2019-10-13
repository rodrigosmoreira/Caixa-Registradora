package model.acoes;

import gui.ViewController;
import gui.utils.Alerts;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.entidades.Venda;
import model.interfaces.Acao;

public class CancelaVendaAcao implements Acao {
	
	private TextField visor;
	private Venda venda;
	private Button botaoRegistra;

	public CancelaVendaAcao(ViewController viewController) {
		this.visor = viewController.getVisor();
		this.venda = viewController.getVenda();
		this.botaoRegistra = viewController.getBotaoRegistra();
	}

	@Override
	public void executa() {
		venda.anula();
		visor.setText("");
		visor.setPromptText("Informe o peso");
		botaoRegistra.setId("RegistraPesoAcao");
		Alerts.showAlert("Confirmacao", "", "Venda Cancelada", AlertType.INFORMATION);
				
	}

}
