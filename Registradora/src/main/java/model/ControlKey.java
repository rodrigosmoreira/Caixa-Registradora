package model;

public enum ControlKey {
	MSG_VENDA_ARQUIVO("%.2f %.2f %.2f\n"),
	MSG_NAO_SALVOU_VENDA("Nao foi possivel salvar resultado"),
	REGISTRA_ACAO("RegistraAcao"),
	ERRO_ABRIR_README("Erro ao abrir o README"),
	EXECUTA("executa"),
	NENHUMA_VENDA_REGISTRADA("Nenhuma venda foi registrada"),
	AVISO("Aviso"),
	ERRO_NA_GERACAO_DO_TOTAL_DE_VENDAS("Erro na geracao do total de vendas"),
	FILE_DATABASE("database.txt"),
	FILE_REGISTROS("registros.txt"),
	REGEX_VALOR("\\d*([\\.]\\d{0,2})?"),
	REGISTROS("registros"),
	MSG_TOTAL_DE_VENDAS("Total = R$ %.02f\n"),
	PULA_LINHA("\n"),
	REGISTRO_DE_VENDA("Registro de Venda"),
	MSG_REGISTRO_SALVO_ARQUIVO("Salvo no arquivo 'registros.txt' no projeto"),
	INFORME_VALOR_UNITARIO("Informe o valor unitario"),
	RESULTADO("Resultado"),
	VALOR_A_SER_PAGO("Valor a ser pago R$ %.02f\n"),
	ERRO("Erro"),
	ERRO_AO_CLICAR_NO_BOTAO("Erro ao clicar no botao"),
	CARACTERE_ACAO("CaractereAcao"),
	URL_README("https://github.com/rodrigo-sm/Caixa-Registradora"),
	APLICATION_CSS("application.css"),
	PATH_FXML("/gui/View.fxml"),
	CONFIRMACAO("Confirmacao"),
	TEXTO_VAZIO(""),
	VENDA_CANCELADA("Venda Cancelada"),
    INFORME_PESO("Informe o peso"),
    REGISTRA_PRECO_ACAO("RegistraPrecoAcao"),
    REGISTRA_PESO_ACAO("RegistraPesoAcao"),
    TITULO_PROGRAMA("Registradora"),
    ERRO_REGISTRO_VENDA("Erro na geracao do registro de vendas"),
    PATH_ACAO("model.acoes."),
    TO_STRING_VENDA("%.02f Kg x R$ %.02f // Kg = %.02f");
	
    public String string;

    private ControlKey(String string)
    {
        this.string = string;
    }
    
    public String getString() {
        return string;
    }

}
