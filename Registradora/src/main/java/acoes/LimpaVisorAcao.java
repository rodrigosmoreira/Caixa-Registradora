package acoes;

import estrutura.ControlKey;
import gui.ViewController;
import javafx.scene.control.TextField;

public class LimpaVisorAcao implements Acao {
	
	private TextField visor;

	public LimpaVisorAcao(ViewController viewController) {
		this.visor = viewController.getVisor();
	}

	@Override
	public void executa() {
		visor.setText(ControlKey.TEXTO_VAZIO.getString());
	}
}
