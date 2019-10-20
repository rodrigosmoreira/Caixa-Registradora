package estrutura;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import gui.ViewController;
import gui.utils.Alerts;
import javafx.scene.control.Alert.AlertType;

public class Reflexao {

	private ViewController _viewController;
	private String acao;

	public Reflexao(ViewController viewController) {
		this._viewController = viewController;
		this.acao = viewController.getAcao();
	}

	public void invocaAcao() {
		Class<?> classe;
		try {
			classe = Class.forName(ControlKey.PATH_ACAO.getString() + getAcao());
			Constructor<?> construtor = classe.getDeclaredConstructor(ViewController.class);
			Object acao = construtor.newInstance(_viewController);
			Method executa = classe.getDeclaredMethod(ControlKey.EXECUTA.getString());
			executa.invoke(acao);
		} catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | SecurityException | InstantiationException exception) {
			mostraErroExecutaAcao();
			exception.printStackTrace();
		}
	}

	private void mostraErroExecutaAcao() {
		Alerts.showAlert(ControlKey.ERRO.getString(), ControlKey.TEXTO_VAZIO.getString(),
				ControlKey.ERRO_EXECUTA_ACAO.getString(), AlertType.ERROR);
	}

	public String getAcao() {
		return acao.contains("CaractereAcao") ? "CaractereAcao" : acao;
	}

}
