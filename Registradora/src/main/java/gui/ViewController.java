package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import entidades.Venda;
import estrutura.Reflexao;
import estrutura.RelacionaEventoXAcao;
import gui.utils.Mascara;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
		if(!acao.isBlank())
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

	public String getAcao() {
		return acao;
	}
}
