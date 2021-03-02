package ensta.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.tools.DeleteDbFiles;

public class FillDatabase {


    public static void main(String[] args) throws Exception {
        try {
            DeleteDbFiles.execute("~", "tp3Database", true);
            insertWithPreparedStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	private static void insertWithPreparedStatement() throws SQLException {
        Connection connection = EstablishConnection.getConnection();
        PreparedStatement createPreparedStatement = null;
        PreparedStatement insertPreparedStatement = null;
        PreparedStatement selectPreparedStatement = null;

        String CreateQuery = "CREATE TABLE IF NOT EXISTS film(id int primary key auto_increment, titre varchar(100), realisateur varchar(50))";
        String InsertQuery = "INSERT INTO film" + "(titre, realisateur) values" + "(?,?)";
        String SelectQuery = "SELECT * FROM film";
        try {
            connection.setAutoCommit(false);
           
            createPreparedStatement = connection.prepareStatement(CreateQuery);
            createPreparedStatement.executeUpdate();
            createPreparedStatement.close();

            
            // Ajout d'un enregistrement avec prepareStatement

            insertPreparedStatement = connection.prepareStatement(InsertQuery);
            insertPreparedStatement.setString(1, "Forrest Gump");
            insertPreparedStatement.setString(2, "Robert Zemeckis");
            insertPreparedStatement.executeUpdate();
            insertPreparedStatement.close();
            
            // Ajout de plusieurs enregistrement avec Statement
            
            Statement stmt = connection.createStatement();
            stmt.execute("INSERT INTO film(titre, realisateur) VALUES('La ligne verte', 'Frank Darabont')");
            stmt.execute("INSERT INTO film(titre, realisateur) VALUES('La liste de Schindler', 'Steven Spielberg')");
            stmt.execute("INSERT INTO film(titre, realisateur) VALUES('Pulp fiction', 'Quentin Tarantino')");
            stmt.execute("INSERT INTO film(titre, realisateur) VALUES('Les evades', 'Frank Darabont')");

            selectPreparedStatement = connection.prepareStatement(SelectQuery);
            ResultSet rs = selectPreparedStatement.executeQuery();
            System.out.println("H2 Database inserted through PreparedStatement");
            while (rs.next()) {
                System.out.println("Id : " + rs.getInt("id") + " Titre : " + rs.getString("titre") + " Name : " + rs.getString("realisateur"));
            }
            selectPreparedStatement.close();
           
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}