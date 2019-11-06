package estrutura.enums;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.input.KeyCode;

public enum RelacionaTeclaXAcao {
	PONTO(KeyCode.PERIOD, "CaractereAcao."),
	UM(KeyCode.DIGIT1, "CaractereAcao1"),
	DOIS(KeyCode.DIGIT2, "CaractereAcao2"),
	TRES(KeyCode.DIGIT3, "CaractereAcao3"),
	QUATRO(KeyCode.DIGIT4, "CaractereAcao4"),
	CINCO(KeyCode.DIGIT5, "CaractereAcao5"),
	SEIS(KeyCode.DIGIT6, "CaractereAcao6"),
	SETE(KeyCode.DIGIT7, "CaractereAcao7"),
	OITO(KeyCode.DIGIT8, "CaractereAcao8"),
	NOVE(KeyCode.DIGIT9, "CaractereAcao9"),
	ANULA(KeyCode.DELETE, "AnulaVendaAcao"),
	LIMPA(KeyCode.BACK_SPACE, "LimpaVisorAcao"),
	CONFIRMA(KeyCode.INSERT, "ConfirmaAcao"),
	REGISTRO_VENDAS(KeyCode.EQUALS, "RegistroDeVendaAcao");
	
	private final KeyCode tecla;
	private final String acao;
	private static Map<KeyCode, String> mapTeclaXAcao = new HashMap<KeyCode, String>(); 
	
	private RelacionaTeclaXAcao(KeyCode tecla, String acao) {
		this.tecla = tecla;
		this.acao = acao;
	}
	
	static {
		for(RelacionaTeclaXAcao relacionamento : RelacionaTeclaXAcao.values())
			mapTeclaXAcao.put(relacionamento.getTecla(), relacionamento.getAcao());
	}

	public static String getAcaoPelaTecla(KeyCode tecla) {
		String retorno = mapTeclaXAcao.get(tecla);
		return retorno == null ? "" : retorno;
	}
	
	public KeyCode getTecla() {
		return tecla;
	}

	public String getAcao() {
		return acao;
	}
	
	
}