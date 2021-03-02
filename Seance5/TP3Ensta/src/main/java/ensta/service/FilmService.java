package ensta.service;

import java.util.List;

import ensta.dao.FilmDao;
import ensta.model.Film;

public class FilmService {

    FilmDao filmDao = new FilmDao();

    public List<Film> findAll(){
        return filmDao.findAll();
    }

}