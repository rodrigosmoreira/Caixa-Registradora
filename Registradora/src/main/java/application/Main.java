package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ControlKey;

public class Main extends Application {

	@Override
	public void start(Stage stage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(ControlKey.PATH_FXML.getString()));
			Scene scene = new Scene(parent);
			scene.getStylesheets().add(getClass().getResource(ControlKey.APLICATION_CSS.getString()).toExternalForm());
			stage.setScene(scene);
			stage.setTitle(ControlKey.TITULO_PROGRAMA.getString());
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
