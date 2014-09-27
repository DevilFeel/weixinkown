package hyit.app.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/attendanceparent";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "nicai";
	/*
	 * private static final String DBDRIVER = "com.mysql.jdbc.Driver"; //for SAE
	 * private static final String DBURL =
	 * "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_akinoneko"; //for SAE
	 * private static final String DBUSER = "0lyx1jw04o"; //for SAE private
	 * static final String DBPASSWORD =
	 * "hjjh3m1lx3j5wmxm1lk0zml0wy04ii525lh4wkzw"; //for SAE
	 */private Connection conn = null;

	public DatabaseConnection() throws Exception {
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch (Exception e) {
			throw e;
		}
	}

	public Connection getConnection() {
		return this.conn;
	}

	public void close() throws Exception {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
