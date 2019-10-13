package model.acoes;

import gui.ViewController;
import javafx.scene.control.TextField;
import model.interfaces.Acao;

public class LimpaVisorAcao implements Acao {
	
	private TextField visor;

	public LimpaVisorAcao(ViewController viewController) {
		this.visor = viewController.getVisor();
	}

	@Override
	public void executa() {
		visor.setText("");
	}
	
}
