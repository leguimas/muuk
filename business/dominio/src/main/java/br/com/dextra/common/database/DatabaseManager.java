package br.com.dextra.common.database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.JFrame;

import org.hsqldb.util.DatabaseManagerSwing;

public class DatabaseManager {

	public static void runManager(String ds) {
		String title = "Database Manager";
		if (ds != null) {
			title += " " + ds;
		}

		DatabaseManagerSwing manager = new DatabaseManagerSwing(new JFrame(title));
		manager.main();

		if (ds != null) {
			try {
				InitialContext ic = new InitialContext();
				DataSource dataSource = (DataSource) ic.lookup(ds);
				Connection conn = dataSource.getConnection();
				manager.connect(conn);
			} catch (NamingException e) {
				throw new RuntimeException(e);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			manager.start();
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String ds = (args.length > 0 ? args[0] : null);
		runManager(ds);
	}

	public static void start(final String ds) {
		Runnable runnable = new Runnable() {

			public void run() {
				runManager(ds);
			}

		};
		Thread thread = new Thread(runnable, "DatabaseManager");
		thread.start();
	}

}