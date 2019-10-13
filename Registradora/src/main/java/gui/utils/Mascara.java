package gui.utils;

import javafx.scene.control.TextField;
import model.ControlKey;

public class Mascara {

	public static void setTextFieldMaxLength(TextField txt, int max) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}

	public static void setTextFieldDouble(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches(ControlKey.REGEX_VALOR.getString())) {
				txt.setText(oldValue);
			}
		});
	}
}
