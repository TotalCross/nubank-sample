package br.com.totalcross.sample.nubank.dao;

import java.sql.SQLException;

import br.com.totalcross.sample.nubank.util.DatabaseManager;
import totalcross.sql.Connection;
import totalcross.sql.Statement;

public class CPFDAO {

	public void insertCPF(String cpf) throws SQLException {

		Connection dbcon = DatabaseManager.getConnection();
		Statement st = dbcon.createStatement();
		st.executeUpdate("insert into person values('" + cpf + "')");
		st.close();
	}
}
