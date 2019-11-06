package estrutura;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import acoes.Acao;
import estrutura.enums.ACAO;
import estrutura.enums.PATH;
import estrutura.enums.TEXTO;
import gui.ViewController;

public class Reflexao {

	private ViewController _viewController;
	private String acao;

	public Reflexao(ViewController viewController) {
		this._viewController = viewController;
		this.acao = viewController.getAcao();
	}

	public void invocaAcao() {
		if(!ACAO.VAZIA.getAcao().equals(acao)) {
			Class<?> classe;
			try {
				classe = Class.forName(PATH.ACAO.getPath() + getAcao());
				Constructor<?> construtor = classe.getDeclaredConstructor(ViewController.class);
				Acao acao = (Acao) construtor.newInstance(_viewController);
				acao.executa();
				
			} catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | SecurityException | InstantiationException exception) {
				_viewController.displayErrorMessage(TEXTO.ERRO_INVOCA_ACAO);
				exception.printStackTrace();
			}
		}
	}

	public String getAcao() {
		return acao.contains(ACAO.CARACTERE_ACAO.getAcao()) ? ACAO.CARACTERE_ACAO.getAcao() : acao;
	}

}
