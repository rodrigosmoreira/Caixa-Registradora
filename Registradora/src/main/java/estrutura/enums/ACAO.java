package estrutura.enums;

public enum ACAO {
	VAZIA(""),
	CARACTERE_ACAO("CaractereAcao");
	
	private final String acao;
	
	private ACAO(String acao) {
		this.acao = acao;
	}
	
	public String getAcao() {
		return acao;
	}
}
