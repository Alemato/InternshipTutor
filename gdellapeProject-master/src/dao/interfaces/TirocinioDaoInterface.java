package dao.interfaces;

import dao.exception.DaoException;
import model.OffertaTirocinio;
import model.Tirocinante;
import model.Tirocinio;
import model.TutoreUniversitario;

import java.util.List;

public interface TirocinioDaoInterface {
    Tirocinio getRichiestatrByID(int ID) throws DaoException;

    List<Tirocinio> gettrbyStatoandOfferta(OffertaTirocinio offerta, int stato) throws DaoException;

    List<Tirocinio> getTirociniByStato(Integer stato) throws DaoException;

    List<Tirocinio> getAllTirocinioByTutore(TutoreUniversitario tutore) throws DaoException;

    List<Tirocinio> getAllTirocinio() throws DaoException;

    List<Tirocinio> getTrByOfferta(OffertaTirocinio offertaTirocinio) throws DaoException;

    boolean ifTirocinanteSendRichiesta(Tirocinante tr) throws DaoException;

    List<Tirocinio> getOffertaTirByIDTirocinante(int IDTr) throws DaoException;

    void setRichiestatr(Tirocinio tirocinio) throws DaoException;

    void firstRichiestatr(Tirocinio tr) throws DaoException;

    void updateTirocinio(Tirocinio tirocinio) throws DaoException;
}
