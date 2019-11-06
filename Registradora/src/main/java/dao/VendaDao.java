package dao;

import java.io.IOException;
import java.util.List;

import entidades.Venda;

public interface VendaDao {
	void salvaVenda(Venda venda) throws IOException;
	List<Venda> recuperaVendas() throws IOException;
}
