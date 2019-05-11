package dao.implementation;


import dao.data.DaoDataMySQLImpl;
import dao.exception.DaoException;
import dao.interfaces.TirocinanteDaoInterface;
import model.Tirocinante;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TirocinanteDaoImp extends DaoDataMySQLImpl implements TirocinanteDaoInterface {

    private PreparedStatement selectTirocinanteById;
    private PreparedStatement selectAllTirocinante;
    private PreparedStatement insertTirocinante;
    private PreparedStatement selectTirocinanteByIDuser;
    private PreparedStatement updateTirocinante;
    private PreparedStatement delete;

    @Override
    public void init() throws DaoException {
        try {

            super.init();


            this.selectTirocinanteById = connection.prepareStatement("SELECT * FROM tirocinante WHERE IDTirocinante = ?");
            this.selectTirocinanteByIDuser = connection.prepareStatement("SELECT * FROM tirocinante WHERE tirocinante.User = ?");

            this.insertTirocinante = connection.prepareStatement("INSERT INTO tirocinante(Nome, Cognome, " +
                    "LuogoDiNascita, DataDiNascita, LuogoDiResidenza,ProvinciaDiResidenza,ProvinciaDiNascita," +
                    "CodiceFiscale, Telefono, CorsoDiLaurea, DiplomaUniversitario, Laureato, " +
                    "DottoratoDiRicerca, ScuolaAltro, Handicap, User) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            this.updateTirocinante = connection.prepareStatement("UPDATE tirocinante SET  Nome = ?, Cognome= ?," +
                    " LuogoDiNascita= ?, DataDiNascita= ?, LuogoDiResidenza= ?, ProvinciaDiResidenza= ?," +
                    " ProvinciaDiNascita= ?, CodiceFiscale = ?,Telefono =? , CorsoDiLaurea = ?, DiplomaUniversitario = ?," +
                    " Laureato = ?, DottoratoDiRicerca = ?, ScuolaAltro = ?, Handicap = ?, User = ? WHERE IDTirocinante = ?");

            this.selectAllTirocinante = connection.prepareStatement("SELECT * FROM tirocinante ORDER BY UpdateDate ASC");

            this.delete = connection.prepareStatement("DELETE FROM tirocinante WHERE IDTirocinante=?");
        } catch (SQLException ex) {
            throw new DaoException("Error:PrepareStatement error", ex);

        }

    }

    private void setTirocinanteObject(Tirocinante tirocinante, ResultSet resultSet) throws DaoException {
        try {
            tirocinante.setIDTirocinante(resultSet.getInt("IDTirocinante"));
            tirocinante.setNome(resultSet.getString("Nome"));
            tirocinante.setCognome(resultSet.getString("Cognome"));
            tirocinante.setLuogoDiNascita(resultSet.getString("LuogoDiNascita"));
            tirocinante.setDataDiNascita(resultSet.getDate("DataDiNascita"));
            tirocinante.setLuogoDiResidenza(resultSet.getString("LuogoDiResidenza"));
            tirocinante.setProvinciaDiResidenza(resultSet.getString("ProvinciaDiResidenza"));
            tirocinante.setProvinciaDiNascita(resultSet.getString("ProvinciaDiNascita"));
            tirocinante.setCodiceFiscale(resultSet.getString("CodiceFiscale"));
            tirocinante.setTelefono(resultSet.getString("Telefono"));
            tirocinante.setCorsoDiLaurea(resultSet.getString("CorsoDiLaurea"));
            tirocinante.setDiplomaUniversitario(resultSet.getString("DiplomaUniversitario"));
            tirocinante.setLaureato(resultSet.getString("Laureato"));
            tirocinante.setDottoratoDiRicerca(resultSet.getString("DottoratoDiRicerca"));
            tirocinante.setScuolaAltro(resultSet.getString("ScuolaAltro"));
            tirocinante.setHandicap(resultSet.getBoolean("Handicap"));
            tirocinante.setCreateDate(resultSet.getTimestamp("CreateDate"));
            tirocinante.setUpdateDate(resultSet.getTimestamp("UpdateDate"));
            tirocinante.setUser(resultSet.getInt("User"));
        } catch (SQLException e) {
            throw new DaoException("Errore nel creare oggetto Tirocinante", e);
        }
    }

    private void setListTirocinante(List<Tirocinante> tirocinantes, ResultSet resultSet) throws DaoException {
        try {
            while (resultSet.next()) {
                Tirocinante tirocinante = new Tirocinante();
                setTirocinanteObject(tirocinante, resultSet);
                tirocinantes.add(tirocinante);
            }
        } catch (SQLException e) {
            throw new DaoException("Errore nel creare Lista oggetti Tirocinante", e);
        }
    }

    @Override
    public List<Tirocinante> getAllTirociante() throws DaoException {
        List<Tirocinante> tr = new ArrayList<Tirocinante>();
        try {
            this.init();
            ResultSet resultSet = selectAllTirocinante.executeQuery();
            setListTirocinante(tr, resultSet);

        } catch (SQLException e) {
            throw new DaoException("Errore inserimento", e);
        }
        return tr;
    }

    @Override
    public void delete(Tirocinante tr) throws DaoException {
        try{
            this.init();
            this.delete.setInt(1,tr.getIDTirocinante());
        } catch (SQLException e) {
            throw new DaoException("Errore distruzione", e);
        }
    }

    @Override
    public void setTirocinante(Tirocinante tr) throws DaoException {
        try {
            this.init();
            insertTirocinante.setString(1, tr.getNome());
            insertTirocinante.setString(2, tr.getCognome());
            insertTirocinante.setString(3, tr.getLuogoDiNascita());
            insertTirocinante.setDate(4, tr.getDataDiNascita());
            insertTirocinante.setString(5, tr.getLuogoDiResidenza());
            insertTirocinante.setString(6, tr.getProvinciaDiResidenza());
            insertTirocinante.setString(7, tr.getProvinciaDiNascita());
            insertTirocinante.setString(8, tr.getCodiceFiscale());
            insertTirocinante.setString(9, tr.getTelefono());
            insertTirocinante.setString(10, tr.getCorsoDiLaurea());
            insertTirocinante.setString(11, tr.getDiplomaUniversitario());
            insertTirocinante.setString(12, tr.getLaureato());
            insertTirocinante.setString(13, tr.getDottoratoDiRicerca());
            insertTirocinante.setString(14, tr.getScuolaAltro());
            insertTirocinante.setBoolean(15, tr.getHandicap());
            insertTirocinante.setInt(16, tr.getUser());
            insertTirocinante.executeUpdate();


        } catch (SQLException e) {
            throw new DaoException("Errore inserimento", e);
        }
    }

    @Override
    public void setUpdate(Tirocinante tr) throws DaoException {
        try {
            this.init();
            updateTirocinante.setString(1, tr.getNome());
            updateTirocinante.setString(2, tr.getCognome());
            updateTirocinante.setString(3, tr.getLuogoDiNascita());
            updateTirocinante.setDate(4, tr.getDataDiNascita());
            updateTirocinante.setString(5, tr.getLuogoDiResidenza());
            updateTirocinante.setString(6, tr.getProvinciaDiResidenza());
            updateTirocinante.setString(7, tr.getProvinciaDiNascita());
            updateTirocinante.setString(8, tr.getCodiceFiscale());
            updateTirocinante.setString(9, tr.getTelefono());
            updateTirocinante.setString(10, tr.getCorsoDiLaurea());
            updateTirocinante.setString(11, tr.getDiplomaUniversitario());
            updateTirocinante.setString(12, tr.getLaureato());
            updateTirocinante.setString(13, tr.getDottoratoDiRicerca());
            updateTirocinante.setString(14, tr.getScuolaAltro());
            updateTirocinante.setBoolean(15, tr.getHandicap());
            updateTirocinante.setInt(16, tr.getUser());
            updateTirocinante.setInt(17, tr.getIDTirocinante());
            updateTirocinante.executeUpdate();


        } catch (SQLException e) {
            throw new DaoException("Errore Tirocinante Update", e);
        }
    }

    @Override
    public Tirocinante getTirocianteByID(int id) throws DaoException {
        Tirocinante tirocinante = new Tirocinante();
        try {
            this.init();
            selectTirocinanteById.setInt(1, id);
            ResultSet resultSet = selectTirocinanteById.executeQuery();

            if (resultSet.next()) {
                setTirocinanteObject(tirocinante, resultSet);
            } else {
                throw new DaoException("Query selectTirocinanteByID con risultato vuoto");
            }
        } catch (SQLException e) {
            throw new DaoException("Problema inserimento", e);
        }
        return tirocinante;
    }

    @Override
    public Tirocinante getTirocianteByIDuser(int id) throws DaoException {
        Tirocinante tirocinante = new Tirocinante();
        try {
            this.init();
            selectTirocinanteByIDuser.setInt(1, id);
            ResultSet resultSet = selectTirocinanteByIDuser.executeQuery();
            if (resultSet.next()) {
                setTirocinanteObject(tirocinante, resultSet);
            } else {
                throw new DaoException("Query selectTirocninanteByIDUser con risultato vuoto");
            }
        } catch (SQLException e) {
            throw new DaoException("Problema query", e);
        }
        return tirocinante;

    }

    public void destroy() throws DaoException {
        try {
            this.selectTirocinanteByIDuser.close();
            this.selectTirocinanteById.close();
            this.insertTirocinante.close();
            this.selectAllTirocinante.close();
            this.updateTirocinante.close();
            super.destroy();
        } catch (SQLException ex) {
            ex.printStackTrace();

            throw new DaoException("Error destroy ", ex);


        }
    }

}


