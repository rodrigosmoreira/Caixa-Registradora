package model.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import gui.ViewController;
import gui.utils.Alerts;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import model.ControlKey;

public class Reflexao {

	private Button botao;
	private ViewController _viewController;

	public Reflexao(ViewController viewController) {
		this._viewController = viewController;
		this.botao = viewController.getBotao();
	}

	public void invocaAcao() {
		Class<?> classe;
		try {
			classe = Class.forName(ControlKey.PATH_ACAO.getString() + getAcaoBotao());
			Constructor<?> construtor = classe.getDeclaredConstructor(ViewController.class);
			Object acao = construtor.newInstance(_viewController);
			Method executa = classe.getDeclaredMethod(ControlKey.EXECUTA.getString());
			executa.invoke(acao);
		} catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | SecurityException | InstantiationException exception) {
			Alerts.showAlert(ControlKey.ERRO.getString(), ControlKey.TEXTO_VAZIO.getString(),
					ControlKey.ERRO_AO_CLICAR_NO_BOTAO.getString(), AlertType.ERROR);
		}
	}

	public String getAcaoBotao() {
		return botao.getId().contains("CaractereAcao") ? "CaractereAcao" : botao.getId();
	}

}
