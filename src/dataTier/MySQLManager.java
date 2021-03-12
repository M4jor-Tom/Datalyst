package dataTier;

import java.sql.*;

public class MySQLManager implements DataInterface
{
	private Connection _connection;
	
	public MySQLManager()
	{
		connect();
	}
	
	public void connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			setConnection(
				DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/datalyst",
					"root",
					""
				)
			);
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public ResultSet query(String stringQuery)
	{
		try
		{
			Statement statement = getConnection().createStatement();
			return statement.executeQuery(stringQuery);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public Connection getConnection()
	{
		return _connection;
	}

	public void setConnection(Connection connection)
	{
		_connection = connection;
	}
}