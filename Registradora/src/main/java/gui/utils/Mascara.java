package gui.utils;

import estrutura.ControlKey;
import javafx.scene.control.TextField;

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
