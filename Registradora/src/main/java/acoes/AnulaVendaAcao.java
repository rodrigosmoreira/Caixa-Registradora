package acoes;

import entidades.Venda;
import gui.ViewController;

public class AnulaVendaAcao implements Acao {

	private Venda venda;
	private ViewController _viewController;

	public AnulaVendaAcao(ViewController viewController) {
		this.venda = viewController.getVenda();
		_viewController = viewController;
	}

	@Override
	public void executa() {
		venda.anula();
		_viewController.informePeso();
	}

}
