package model.entidades;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import gui.utils.Alerts;
import javafx.scene.control.Alert.AlertType;

public class Venda {

	private Double peso; 
	private Double valorUnitario; 
	private Double preco; 
	
	public Venda() {
	}
	
	public Venda(String linha) {
		String[] atributos = linha.split(" "); 
		this.peso = Double.parseDouble(atributos[0]);
		this.valorUnitario = Double.parseDouble(atributos[1]);
		this.preco = Double.parseDouble(atributos[2]);
	}

	public void calculaPreco() {
		preco = peso * valorUnitario;
	}

	public void anula() {
		peso = null;
		valorUnitario = null;
		preco = null;
	}
	
	public void salva() {
		BufferedWriter buffWrite;
		try {
			buffWrite = new BufferedWriter(new FileWriter("database.txt", true));
			buffWrite.append(String.format("%.2f %.2f %.2f\n", peso, valorUnitario, preco));
			buffWrite.close();
		} catch (IOException e) {
			Alerts.showAlert("Erro", "", "Nao foi possivel salvar resultado", AlertType.ERROR);
			e.printStackTrace();
		}
	}
	
	public Double getPeso() {
		return peso;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void setValorUnitario(String text) {
		this.valorUnitario = Double.parseDouble(text);
	}

	public void setPeso(String text) {
		this.peso = Double.parseDouble(text);
	}

	public void setPreco(String string) {
		this.preco = Double.parseDouble(string);
	}

	@Override
	public String toString() {
		return String.format("%.02f Kg x R$ %.02f // Kg = %.02f", peso, valorUnitario, preco);
	}



}
