package dao.interfaces;

import dao.exception.DaoException;
import model.TutoreUniversitario;

import java.util.List;

public interface TutoreUniversitarioDaoInterface {
    TutoreUniversitario getTutoreUniByID(int ID) throws DaoException;

    List<TutoreUniversitario> getAllTutUni() throws DaoException;

    TutoreUniversitario getTutoreByEmail(String email) throws DaoException;

    void UpdateTutoreUni(TutoreUniversitario tutore) throws DaoException;

    void setTutoreUni(TutoreUniversitario tutUni) throws DaoException;
}
