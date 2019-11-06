package acoes;

import gui.ViewController;

public class LimpaVisorAcao implements Acao {
	
	private ViewController _viewController;

	public LimpaVisorAcao(ViewController viewController) {
		_viewController = viewController;
	}

	@Override
	public void executa() {
		_viewController.limpaVisor();
	}
}
