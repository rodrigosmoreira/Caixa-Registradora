package acoes;

import gui.ViewController;
import javafx.scene.control.TextField;

public class CaractereAcao implements Acao {
	
	private TextField visor;
	private String caractere;

	public CaractereAcao(ViewController viewController) {
		this.caractere = viewController.getAcao().replace("CaractereAcao", "");
		this.visor = viewController.getVisor();
	}

	@Override
	public void executa() {
		visor.appendText(caractere);
	}
	
	
}
