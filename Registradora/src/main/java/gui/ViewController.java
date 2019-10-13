package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.utils.Mascara;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.RelacionaBotaoAoEvento;
import model.entidades.Venda;
import model.reflexao.Reflexao;

public class ViewController implements Initializable {

	@FXML
	private AnchorPane anchorPane;
	@FXML
	private TextField visor;
	private Venda venda = new Venda();
	private Button botao;
	
	@FXML
	public void onClick(Event event) {
		Locale.setDefault(Locale.US);
		botao = new RelacionaBotaoAoEvento(this, event).getBotao();
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

	public void setBotao(Button botao) {
		this.botao = botao;
	}
}
