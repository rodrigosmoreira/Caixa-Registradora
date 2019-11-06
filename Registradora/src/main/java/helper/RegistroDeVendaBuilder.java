package helper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import entidades.Venda;
import estrutura.enums.TEXTO;
import gui.ViewController;

public class RegistroDeVendaBuilder {
	private String mensagem;

	public RegistroDeVendaBuilder() {
		super();
	}

	public RegistroDeVendaBuilder geraMensagem(List<Venda> vendas) {
		StringBuilder sb = new StringBuilder();
		for (Venda venda : vendas)
			sb.append(venda + TEXTO.PULA_LINHA.getTexto());
		sb.append(String.format(TEXTO.TOTAL_VENDAS.getTexto(), calculaPrecoTotal(vendas)));
		mensagem =  sb.toString();
		return this;
	}
	
	private Double calculaPrecoTotal(List<Venda> vendas) {
		Double soma = 0.0;
		for (Venda reg : vendas)
			soma += reg.getPreco();
		return soma;
	}

	public RegistroDeVendaBuilder imprimeNoArquivo(String path_file) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path_file));
		buffWrite.append(mensagem);
		buffWrite.close();
		return this;
	}

	public RegistroDeVendaBuilder imprimeNoVisor(ViewController _viewController) {
		_viewController.displayInformationMessage(mensagem, TEXTO.REGISTRO_VENDAS_SALVO);
		return this;
	}
	
}
