package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	//bloco inicializador estático
		static{
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection() throws SQLException{
			
			return DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=sistemadb;integratedSecurity=true;");
					
		
		}
}

