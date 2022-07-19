package dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoFactory {

	public static WatchDao createWatchDao() {
		return new WatchDaoImpl(getDataSource());
	}

	public static LoginDao createLoginDao() {
		return new LoginDaoImpl(getDataSource());
	}

	public static JugeDao createJugeDao() {
		return new JugeDaoImpl(getDataSource());
	}

	private static DataSource getDataSource() {
		InitialContext ctx = null;
		DataSource ds = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/football");
		} catch (NamingException e) {
			if (ctx != null) {
				try {
					ctx.close();
				} catch (NamingException el) {
					throw new RuntimeException(el);
				}
			}
			throw new RuntimeException(e);
		}
		return ds;
	}

}
