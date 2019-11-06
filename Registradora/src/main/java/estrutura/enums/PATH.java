package estrutura.enums;

public enum PATH {
	ACAO("acoes."),
	FXML("/gui/View.fxml"),
	APLICATION_CSS("application.css"),
	FILE_DATABASE("database.txt"),
	FILE_REGISTROS("registros.txt");
	
	private final String path;
	
	private PATH(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
}
