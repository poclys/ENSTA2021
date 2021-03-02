package ensta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ensta.model.Film;
import ensta.utils.EstablishConnection;

public class FilmDao {

    String SELECT_ALL =  "SELECT id, titre, realisateur FROM Film;";

    public List<Film> findAll(){
        List<Film> result = new ArrayList<>();
        try (Connection conn = EstablishConnection.getConnection();
               PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL)){
                   ResultSet rs = preparedStatement.executeQuery();
                   while (rs.next()){
                       Film film =  new Film();
                       film.setId(rs.getInt("id"));
                       film.setRealisateur(rs.getString("realisateur"));
                       film.setTitre(rs.getString("titre"));
                       result.add(film);
                   }
                return result;
        } catch (SQLException e){
            System.out.println(e);
        }
        return result;
    }

}