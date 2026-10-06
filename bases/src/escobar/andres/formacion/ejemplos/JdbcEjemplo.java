package escobar.andres.formacion.ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEjemplo {
	public static void main(String[] args) throws SQLException {
//		String url = "jdbc:mysql://localhost:3306/tienda";
//		String driver = "com.mysql.cj.jdbc.Driver"; // Connector/J
//		String usuario = "root";
//		String password = "1234";
		
		String url = "jdbc:sqlite:bdd/tienda.db";
		
		Connection con = DriverManager.getConnection(url);
		Statement st = con.createStatement();
		
		st.execute("INSERT INTO personas (nombre) VALUES ('Juan')");
		
		ResultSet rs = st.executeQuery("SELECT * FROM personas");
		
		//rs.next();
		
		//System.out.println(rs.getString(2));
		
		while (rs.next()) {
			System.out.println(String.format("%5s %-20s %10s", rs.getString(1), rs.getString(2), rs.getString(3)));
		}

	}
}
