package application;

import java.io.IOException;

import estrutura.enums.PATH;
import estrutura.enums.TEXTO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(PATH.FXML.getPath()));
			Scene scene = new Scene(parent);
			scene.getStylesheets().add(getClass().getResource(PATH.APLICATION_CSS.getPath()).toExternalForm());
			stage.setScene(scene);
			stage.setTitle(TEXTO.TITULO_PROGRAMA.getTexto());
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
