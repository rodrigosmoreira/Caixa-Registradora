package acoes;

import estrutura.enums.TEXTO;
import gui.ViewController;

public class AbreManualAcao implements Acao{
	
	private ViewController _viewController;

	public AbreManualAcao(ViewController viewController) {
		_viewController = viewController;
	}

	@Override
	public void executa() {
		_viewController.displayInformationMessage(textoManual(), TEXTO.TITULO_MANUAL);
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
		sb.append("\t- Aperte o botao verde ou a tecla INSERT\n");
		return sb.toString();
	}
}
