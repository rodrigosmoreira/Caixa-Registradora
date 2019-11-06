package acoes;

import dao.DaoFactory;
import entidades.Venda;
import estrutura.enums.TEXTO;
import gui.ViewController;

public class ConfirmaAcao implements Acao {

	private Venda venda;
	private ViewController _viewController;

	public ConfirmaAcao(ViewController viewController) {
		this.venda = viewController.getVenda();
		_viewController = viewController;
	}

	@Override
	public void executa() {
		if (venda.getPeso() == null)
			registraPeso();
		else
			registraValorUnitario();
	}

	private void registraPeso() {
		try {
			venda.setPeso(_viewController.getEntrada());
			_viewController.informeValorUnitario();
		} catch (Exception e) {
			_viewController.displayWarningMessage(TEXTO.INFORME_PESO);
		}
	}

	private void registraValorUnitario() {
		try {
			venda.setValorUnitario(_viewController.getEntrada());
			venda.calculaPreco();
			DaoFactory.getInstanceVendaDao().salvaVenda(venda);
			_viewController.informePeso();
			_viewController.displayInformationMessage(mensagemValorASerPago(), TEXTO.VAZIO);
			venda.anula();
		} catch (Exception e) {
			_viewController.displayWarningMessage(TEXTO.INFORME_VALOR_UNITARIO);
		}
	}

	private String mensagemValorASerPago() {
		return String.format(TEXTO.VALOR_A_SER_PAGO.getTexto(), venda.getPreco());
	}
}
