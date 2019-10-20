package dao;

public class DaoFactory {
	
	private static VendaDao vendaDao = null;
	
	public static VendaDao getInstanceVendaDao() {
		if(DaoFactory.vendaDao == null)
			return new VendaDaoFile();
		return vendaDao;
	}
	
}
