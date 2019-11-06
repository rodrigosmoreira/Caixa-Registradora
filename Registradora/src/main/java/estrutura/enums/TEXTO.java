package estrutura.enums;

public enum TEXTO {
	TITULO_ERRO("ERRO"),
	ERRO_REGISTRO_VENDA("Ocorreu um problema ao gerar o registro de vendas"),
	ERRO_INVOCA_ACAO("Ocorreu um problema ao executar o comando desejado"),
	VAZIO(""),
	TITULO_AVISO("Aviso"),
	NENHUMA_VENDA_REGISTRADA("Nenhuma venda foi registrada"),
	INFORME_PESO("Informe o peso"),
	VALOR_A_SER_PAGO("Valor a ser pago R$ %.02f\n"),
	INFORME_VALOR_UNITARIO("Informe o valor unitario"),
	TITULO_INFORMACAO("Informacao"),
	REGISTRO_VENDAS_SALVO("Salvo no arquivo 'registros.txt' no projeto"),
	TOTAL_VENDAS("Total = R$ %.02f\n"),
	PULA_LINHA("\n"),
	TITULO_MANUAL("Manual - Descricao das funcionalidades"),
	TITULO_PROGRAMA("Caixa Registradora"),
	FORMATO_VENDA_ARQUIVO("%.2f %.2f %.2f\n"),
	TO_STRING_VENDA("%.02f Kg x R$ %.02f // Kg = %.02f");
	
	private final String texto;
	
	private TEXTO(String texto) {
		this.texto = texto;
	}
	
	public String getTexto() {
		return texto;
	}
}
