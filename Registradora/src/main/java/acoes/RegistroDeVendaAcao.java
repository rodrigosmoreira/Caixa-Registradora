package acoes;

import java.io.IOException;

import dao.DaoFactory;
import estrutura.enums.PATH;
import estrutura.enums.TEXTO;
import exceptions.NenhumaVendaRegistradaException;
import gui.ViewController;
import helper.RegistroDeVendaBuilder;

public class RegistroDeVendaAcao implements Acao {

	private ViewController _viewController;

	public RegistroDeVendaAcao(ViewController viewController) {
		_viewController = viewController;
	}

	@Override
	public void executa() {
		try {
			new	RegistroDeVendaBuilder().geraMensagem(DaoFactory.getInstanceVendaDao().recuperaVendas())
								   		.imprimeNoArquivo(PATH.FILE_REGISTROS.getPath())
								   		.imprimeNoVisor(_viewController);
		} catch (NenhumaVendaRegistradaException e) {
			_viewController.displayWarningMessage(TEXTO.NENHUMA_VENDA_REGISTRADA);
		} catch (IOException e) {
			_viewController.displayErrorMessage(TEXTO.ERRO_REGISTRO_VENDA);
			e.printStackTrace();
		}
	}

}
