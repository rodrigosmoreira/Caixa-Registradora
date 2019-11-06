package dao;

public class DaoFactory {
	
	private static VendaDao vendaDao = null;
	
	public static VendaDao getInstanceVendaDao() {
		if(vendaDao == null)
			vendaDao = new VendaDaoFile();
		return vendaDao;
	}
	
}
