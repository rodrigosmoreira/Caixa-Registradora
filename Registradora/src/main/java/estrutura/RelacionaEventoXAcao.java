package estrutura;

import javafx.css.Styleable;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class RelacionaEventoXAcao {

	private Event evento;
	private String acao;

	public RelacionaEventoXAcao(Event evento) {
		this.evento = evento;
		this.acao = "";
	}

	public String getAcao() {
		if(isActionEvent())
			getAcaoActionEvent();
		else if(isKeyEvent())
			getAcaoKeyEvent();
		return acao;
	}

	private void getAcaoActionEvent() {
		acao = ((Styleable) evento.getSource()).getId();
	}

	private boolean isKeyEvent() {
		return evento instanceof KeyEvent;
	}

	private boolean isActionEvent() {
		return evento instanceof ActionEvent;
	}

	private void getAcaoKeyEvent() {
		KeyCode tecla = ((KeyEvent) evento).getCode();

		if(tecla == KeyCode.PERIOD)
			acao = "CaractereAcao.";
		else if(tecla == KeyCode.DIGIT1)
			acao = "CaractereAcao1";
		else if(tecla == KeyCode.DIGIT2)
			acao = "CaractereAcao3";
		else if(tecla == KeyCode.DIGIT3)
			acao = "CaractereAcao3";
		else if(tecla == KeyCode.DIGIT4)
			acao = "CaractereAcao4";
		else if(tecla == KeyCode.DIGIT5)
			acao = "CaractereAcao5";
		else if(tecla == KeyCode.DIGIT6)
			acao = "CaractereAcao6";
		else if(tecla == KeyCode.DIGIT7)
			acao = "CaractereAcao7";
		else if(tecla == KeyCode.DIGIT8)
			acao = "CaractereAcao8";
		else if(tecla == KeyCode.DIGIT9)
			acao = "CaractereAcao9";
		else if(tecla == KeyCode.DELETE)
			acao = "AnulaVendaAcao";
		else if(tecla == KeyCode.BACK_SPACE)
			acao = "LimpaVisorAcao";
		else if(tecla == KeyCode.ENTER)
			acao = "ConfirmaAcao";
		else if(tecla == KeyCode.EQUALS)
			acao = "RegistroDeVendaAcao";
	}

}
