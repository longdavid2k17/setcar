package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector
{
    private static Connection connection = null;
    private static boolean connectionSetted = false;
    // TODO tymczasowo używamy tego do komunikacji z bazą danych, żeby niepotrzebnie nie zatrzymywać pracy przez budowanie DAO i bazy H2


    public static boolean isConnectionSetted()
    {
        return connectionSetted;
    }

    public static void setConnectionSetted(boolean connectionSetted)
    {
        DatabaseConnector.connectionSetted = connectionSetted;
    }

    public static boolean setConnection()
    {
        try
        {
            String url = "jdbc:mysql://localhost:3306/car_database";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
            setConnectionSetted(true);
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            setConnectionSetted(false);
            return false;
        }
    }

    public static Connection getConnection()
    {
        return connection;
    }
}
