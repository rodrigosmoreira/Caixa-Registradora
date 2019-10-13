package model.acoes;

import gui.ViewController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.interfaces.Acao;

public class CaractereAcao implements Acao {
	
	private Button botao;
	private TextField visor;

	public CaractereAcao(ViewController viewController) {
		this.botao = viewController.getBotao();
		this.visor = viewController.getVisor();
	}

	@Override
	public void executa() {
		visor.appendText(botao.getText());
	}
	
	
}
