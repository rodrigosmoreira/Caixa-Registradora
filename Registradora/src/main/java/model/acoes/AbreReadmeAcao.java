package model.acoes;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import gui.ViewController;
import gui.utils.Alerts;
import javafx.scene.control.Alert.AlertType;
import model.ControlKey;
import model.interfaces.Acao;

public class AbreReadmeAcao implements Acao{
	
	public AbreReadmeAcao(ViewController viewController) {
	}

	@Override
	public void executa() {
		try {
		    Desktop.getDesktop().browse(new URL(ControlKey.URL_README.getString()).toURI());
		} catch (IOException | URISyntaxException e) {
			Alerts.showAlert(ControlKey.ERRO.getString(), ControlKey.TEXTO_VAZIO.getString(), ControlKey.ERRO_ABRIR_README.getString(), AlertType.ERROR);
		}
	}
}