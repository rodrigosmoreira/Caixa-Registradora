package acoes;

import estrutura.enums.ACAO;
import gui.ViewController;

public class CaractereAcao implements Acao {
	
	private String caractere;
	private ViewController _viewController;

	public CaractereAcao(ViewController viewController) {
		this.caractere = viewController.getAcao().replace(ACAO.CARACTERE_ACAO.getAcao()
														, ACAO.VAZIA.getAcao());
		_viewController = viewController;
	}

	@Override
	public void executa() {
		_viewController.acrescentaCaractereOnVisor(caractere);
	}
	
	
}
