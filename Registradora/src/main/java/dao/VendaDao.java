package dao;

import java.util.List;

import entidades.Venda;

public interface VendaDao {
	void salvaVenda(Venda venda);
	List<Venda> recuperaVendas();
}
