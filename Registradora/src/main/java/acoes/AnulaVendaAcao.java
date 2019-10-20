package acoes;

import entidades.Venda;
import estrutura.ControlKey;
import gui.ViewController;
import javafx.scene.control.TextField;

public class AnulaVendaAcao implements Acao {

	private TextField visor;
	private Venda venda;

	public AnulaVendaAcao(ViewController viewController) {
		this.visor = viewController.getVisor();
		this.venda = viewController.getVenda();
	}

	@Override
	public void executa() {
		venda.anula();
		resetaTextoVisor();
	}

	private void resetaTextoVisor() {
		visor.setText(ControlKey.TEXTO_VAZIO.getString());
		visor.setPromptText(ControlKey.INFORME_PESO.getString());
	}

}
