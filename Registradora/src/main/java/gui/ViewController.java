package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.utils.Mascara;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.acoes.ProcessaTeclaAcao;
import model.entidades.Venda;
import model.reflexao.Reflexao;

public class ViewController implements Initializable {
	
	private Venda venda = new Venda();
	private Button botao;
	
	@FXML
	private AnchorPane anchorPane;
	
	@FXML
	private TextField visor;
	@FXML
	private Button registraBotao;
	
	@FXML
	public void onTeclaClick(KeyEvent event) {
		new ProcessaTeclaAcao(this, event).executa();
	}
	
	@FXML
	public void onBotaoClick(ActionEvent event) {
		Locale.setDefault(Locale.US);
		botao = ((Button) event.getSource());
		new Reflexao(this).invocaAcao();
	}

	public void initialize(URL url, ResourceBundle sb) {
		Mascara.setTextFieldDouble(visor);
	}

	public TextField getVisor() {
		return visor;
	}

	public Venda getVenda() {
		return venda;
	}

	public AnchorPane getAnchorPane() {
		return anchorPane;
	}

	public Button getBotao() {
		return botao;
	}

	public Button getBotaoRegistra() {
		return registraBotao;
	}

	public void setBotao(Button botao) {
		this.botao = botao;
	}
}
