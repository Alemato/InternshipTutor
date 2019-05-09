package dao.interfaces;

import dao.exception.DaoException;
import model.Tirocinante;

import java.util.List;

public interface TirocinanteDaoInterface {
    List<Tirocinante> getAllTirociante() throws DaoException;

    void delete(Tirocinante tr) throws DaoException;

    void setTirocinante(Tirocinante tr) throws DaoException;

    void setUpdate(Tirocinante tr) throws DaoException;

    Tirocinante getTirocianteByID(int id) throws DaoException;

    Tirocinante getTirocianteByIDuser(int id) throws DaoException;
}
