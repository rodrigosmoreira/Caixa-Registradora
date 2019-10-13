package model;

import gui.ViewController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class RelacionaBotaoAoEvento {

	private Event evento;
	private Button botao;
	private AnchorPane anchorPane;
	
	public RelacionaBotaoAoEvento(ViewController viewController, Event event) {
		this.anchorPane = viewController.getAnchorPane();
		this.evento = event;
	}

	public Button getBotao() {
		if(evento instanceof ActionEvent)
			getBotaoPressionado();
		else if(evento instanceof KeyEvent)
			getBotaoAtravesDaTeclaPressionada();
		return botao;
	}

	private void getBotaoPressionado() {
		botao = (Button) ((ActionEvent) evento).getSource();
	}

	public void getBotaoAtravesDaTeclaPressionada() {
		KeyCode codigoTecla = ((KeyEvent) evento).getCode();
		String tecla = ((KeyEvent) evento).getText();
		
		if(tecla != null && tecla.matches("[0-9.]"))
			botao = (Button) anchorPane.lookup("#CaractereAcao"+getComplementoCaractereAcao(tecla));
		else if(codigoTecla == KeyCode.DELETE)
			botao = (Button) anchorPane.lookup("#CancelaVendaAcao");
		else if(codigoTecla == KeyCode.BACK_SPACE)
			botao = (Button) anchorPane.lookup("#LimpaVisorAcao");
		else if(codigoTecla == KeyCode.ENTER)
			botao = (Button) anchorPane.lookup("#RegistraAcao");
		else if(codigoTecla == KeyCode.EQUALS)
			botao = (Button) anchorPane.lookup("#GeraRegistroDeVendaAcao");
	}

	private String getComplementoCaractereAcao(String tecla) {
		return ".".equals(tecla) ? "Dot" : tecla;
	}
	
}
