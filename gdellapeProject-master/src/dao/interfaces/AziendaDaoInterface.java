package dao.interfaces;

import dao.exception.DaoException;
import model.Azienda;
import model.User;

import java.util.List;

public interface AziendaDaoInterface {
    void deleteAzienda(Azienda azienda) throws DaoException;

    void updateAzienda(Azienda azienda) throws DaoException;

    void setAzienda(Azienda azienda) throws DaoException;

    void setRegisterazienda(Azienda azienda, User user) throws DaoException;

    Azienda getAziendaByRS(String RS) throws DaoException;

    List<Azienda> getAllAzienda() throws DaoException;

    List<Azienda> getAllAziendaAttive() throws DaoException;

    List<Azienda> getLastFiveConvenzioni() throws DaoException;

    Azienda getAziendaByID(int ID) throws DaoException;

    Azienda getAziendaByIDuser(int ID) throws DaoException;

    List<Azienda> getAllAziendaPendenti() throws DaoException;

    boolean ifAziendaMakeModulo(Azienda azienda) throws DaoException;
}
