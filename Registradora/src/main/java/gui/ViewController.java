package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import entidades.Venda;
import estrutura.Reflexao;
import estrutura.RelacionaEventoXAcao;
import estrutura.enums.TEXTO;
import gui.utils.Alerts;
import gui.utils.Mascara;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {

	@FXML
	private TextField visor;
	
	private Venda venda = new Venda();
	private String acao;
	
	@FXML
	public void onClick(Event evento) {
		Locale.setDefault(Locale.US);
		acao = new RelacionaEventoXAcao(evento).getAcao();
		new Reflexao(this).invocaAcao();
	} 
	
	public void initialize(URL url, ResourceBundle sb) {
		Mascara.setTextFieldDouble(visor);

	}
	public void displayErrorMessage(TEXTO message) {
		Alerts.showAlert(TEXTO.TITULO_ERRO.getTexto(), TEXTO.VAZIO.getTexto(),
				message.getTexto(), AlertType.ERROR);
	}
	
	public void displayWarningMessage(TEXTO message) {
		Alerts.showAlert(TEXTO.TITULO_AVISO.getTexto(), TEXTO.VAZIO.getTexto(),
				message.getTexto(), AlertType.WARNING);
	}
	
	public void displayInformationMessage(String message, TEXTO title) {
		Alerts.showAlert(TEXTO.TITULO_INFORMACAO.getTexto(), title.getTexto(),
				message, AlertType.INFORMATION);
	}

	public void limpaVisor() {
		visor.setText(TEXTO.VAZIO.getTexto());
	}

	public void informeValorUnitario() {
		limpaVisor();
		visor.setPromptText(TEXTO.INFORME_VALOR_UNITARIO.getTexto());
	}

	public void informePeso() {
		limpaVisor();
		visor.setPromptText(TEXTO.INFORME_PESO.getTexto());
	}

	public void acrescentaCaractereOnVisor(String caractere) {
		visor.appendText(caractere);
	}

	public Venda getVenda() {
		return venda;
	}
	
	public String getAcao() {
		return acao;
	}

	public String getEntrada() {
		return visor.getText();
	}
}
