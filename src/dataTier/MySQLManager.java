package dataTier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLManager implements DataInterface
{
	public MySQLManager()
	{
		
	}
	
	public Connection connect()
	{
		Connection connection = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/datalyst",
				"root",
				""
			);
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return connection;
	}
}