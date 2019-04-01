package br.com.totalcross.sample.nubank.util;

import java.sql.SQLException;

import totalcross.db.sqlite.SQLiteUtil;
import totalcross.sql.Connection;
import totalcross.sql.Statement;
import totalcross.sys.Settings;

public class DatabaseManager {

	public static SQLiteUtil sqliteUtil;

	static {

		try {

			sqliteUtil = new SQLiteUtil(Settings.appPath, "test.db");

			Statement st = sqliteUtil.con().createStatement();
			st.execute("create table if not exists person (cpf varchar)");
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return sqliteUtil.con();
	}
}
