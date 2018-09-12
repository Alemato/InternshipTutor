package dao.implementation;

import dao.data.DaoDataMySQLImpl;
import dao.exception.DaoException;
import model.OffertaTirocinio;
import model.Tirocinio;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableDaoImp extends DaoDataMySQLImpl {

  private PreparedStatement selectOffertetrTirocinio;

    @Override
    public void init() throws DaoException {
        try {

            super.init();
            this.selectOffertetrTirocinio = connection.prepareStatement("select * from tirocinio where OffertaTirocinio = ? ");


        } catch (SQLException ex) {
            throw new DaoException("Error:PrepareStatement error", ex);

        }
    }
    public void ciao(){
        List<Object> lista = new ArrayList<>();
        Tirocinio tr = new Tirocinio();
        OffertaTirocinio of = new OffertaTirocinio();
        Tirocinio tro = new Tirocinio();
        lista.add(tr);
        lista.add(of);
        lista.add(tro);
        Tirocinio fi = (Tirocinio)lista.get(1);
        fi.getCFU();
        System.out.println();
    }



}
