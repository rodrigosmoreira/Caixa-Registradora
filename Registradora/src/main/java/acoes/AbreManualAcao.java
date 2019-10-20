package acoes;

import gui.ViewController;
import gui.utils.Alerts;
import javafx.scene.control.Alert.AlertType;

public class AbreManualAcao implements Acao{
	
	public AbreManualAcao(ViewController viewController) {
	}

	@Override
	public void executa() {
		Alerts.showAlert("Manual", "Descricao das funcionalidades", textoManual(), AlertType.INFORMATION);
	}

	private String textoManual() {
		StringBuilder sb = new StringBuilder();
		sb.append("° Entrada de dados\n");
		sb.append("\t- Aperte os botoes de caractere na tela ou teclado\n");
		sb.append("\t- Observacao somente pode inserir numeros com duas casas decimais\n");
		sb.append("\n°Mostrar Registro De Vendas\n");
		sb.append("\t- Aperte o botao azul ou a tecla =\n");
		sb.append("\n° Limpar o visor\n");
		sb.append("\t- Aperte o botao laranja ou a tecla BACKSPACE\n");
		sb.append("\n° Cancelar a venda atual\n");
		sb.append("\t- Aperte o botao vermelho ou a tecla DELETE\n");
		sb.append("\n° Confirmar a acao atual da venda\n");
		sb.append("\t- Aperte o botao verde ou a tecla ENTER\n");
		return sb.toString();
	}
}
