package estrutura;

import estrutura.enums.ACAO;
import estrutura.enums.RelacionaTeclaXAcao;
import javafx.css.Styleable;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.input.KeyEvent;

public class RelacionaEventoXAcao {

	private String acao = ACAO.VAZIA.getAcao();

	public RelacionaEventoXAcao(Event evento) {
		if(evento instanceof ActionEvent)
			acao = ((Styleable) evento.getSource()).getId();
		else if(evento instanceof KeyEvent)
			acao = RelacionaTeclaXAcao.getAcaoPelaTecla(((KeyEvent) evento).getCode());
	}

	public String getAcao() {
		return acao;
	}

}
