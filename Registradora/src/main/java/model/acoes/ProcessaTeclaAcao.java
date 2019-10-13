package model.acoes;

import gui.ViewController;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.interfaces.Acao;
import model.reflexao.Reflexao;

public class ProcessaTeclaAcao implements Acao {
	
	private ViewController _viewController;
	private AnchorPane anchorPane;
	private String tecla;
	private KeyCode codigoTecla;

	public ProcessaTeclaAcao(ViewController viewController, KeyEvent event) {
		this._viewController = viewController;
		tecla = event.getText();
		codigoTecla = event.getCode();
		this.anchorPane = viewController.getAnchorPane();
	}

	@Override
	public void executa() {
		_viewController.setBotao(getButton());
		new Reflexao(_viewController).invocaAcao();
	}
	
	public Button getButton() {
		Button retorno = null;
		if(tecla != null && tecla.matches("[0-9.]"))
			retorno = (Button) anchorPane.lookup("#CaractereAcao"+getComplementoCaractereAcao());
		else if(codigoTecla == KeyCode.DELETE)
			retorno = (Button) anchorPane.lookup("#CancelaVendaAcao");
		else if(codigoTecla == KeyCode.BACK_SPACE)
			retorno = (Button) anchorPane.lookup("#LimpaVisorAcao");
		else if(codigoTecla == KeyCode.ENTER)
			retorno = _viewController.getBotaoRegistra();
		else if(codigoTecla == KeyCode.EQUALS)
			retorno = (Button) anchorPane.lookup("#GeraRegistroDeVendaAcao");
		return retorno;
	}

	private String getComplementoCaractereAcao() {
		return ".".equals(tecla) ? "Dot" : tecla;
	}
	
}
