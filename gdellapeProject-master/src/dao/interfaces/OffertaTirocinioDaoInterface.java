package dao.interfaces;

import dao.exception.DaoException;
import model.Azienda;
import model.OffertaTirocinio;

import java.util.List;

public interface OffertaTirocinioDaoInterface {
    OffertaTirocinio getOffertatrByID(int ID) throws DaoException;

    List<OffertaTirocinio> getOffertatrBYAzienda(Azienda az) throws DaoException;

    List<OffertaTirocinio> getAllOffertatr() throws DaoException;

    List<OffertaTirocinio> getLastFiveOfferte() throws DaoException;

    void setOffertatr(OffertaTirocinio tr) throws DaoException;

    void updateOffertatr(OffertaTirocinio tr) throws DaoException;
}
