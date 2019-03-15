package dao.implementation;

import dao.data.DaoDataMySQLImpl;
import dao.exception.DaoException;
import model.Azienda;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AziendaDaoImp extends DaoDataMySQLImpl {

//    private PreparedStatement selectAziendaByNome;
//    secondo me ci andrebbe un nome
    private PreparedStatement selectAziendaByRS;
    private PreparedStatement insertAzienda;
    private PreparedStatement selectAllAzienda;
    private PreparedStatement selectAziendaByID;
    private PreparedStatement selectAllAziendaAttiva;
    private PreparedStatement selectLastFiveConvenzioni;
    private PreparedStatement selectAziendaByIDuser;
    private PreparedStatement regAzienda;
    private PreparedStatement updateAzienda;
    private PreparedStatement selectAllPendentAzieda;


    @Override
    public void init() throws DaoException {
        try {

            super.init();

            this.selectAziendaByRS = connection.prepareStatement
                    ("SELECT * FROM azienda WHERE RagioneSociale = ?");

            this.selectAziendaByID = connection.prepareStatement
                    ("SELECT * FROM azienda WHERE IDAzienda = ?");

            this.selectAziendaByIDuser = connection.prepareStatement
                    ("SELECT * FROM azienda WHERE User = ?");

            this.selectAllAzienda = connection.prepareStatement
                    ("SELECT * FROM azienda");

            this.selectAllPendentAzieda = connection.prepareStatement
                    ("SELECT * FROM azienda WHERE Attivo=0 ORDER BY UpdateDate ASC");

            this.selectAllAziendaAttiva = connection.prepareStatement
                    ("SELECT * FROM azienda WHERE Attivo=1 ORDER BY UpdateDate ASC");


            this.selectLastFiveConvenzioni = connection.prepareStatement
                    ("SELECT * FROM azienda ORDER BY UpdateDate DESC LIMIT 5");

            this.insertAzienda = connection.prepareStatement
                    ("INSERT INTO azienda(RagioneSociale,IndirizzoSedeLegale,CFiscalePIva,NomeLegaleRappresentante," +
                            "CognomeLegaleRappresentante,NomeResponsabileConvenzione,CognomeResponsabileConvenzione,TelefonoResponsabileConvenzione," +
                            "EmailResponsabileConvenzione, PathPDFConvenzione,DurataConvenzione,ForoControversia,DataConvenzione, Attivo, ModuloConvenzione, Descrizione, " +
                            "Link, User ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            this.updateAzienda = connection.prepareStatement
                    ("UPDATE azienda SET RagioneSociale = ? ,IndirizzoSedeLegale = ? ,CFiscalePIva = ?,NomeLegaleRappresentante = ?," +
                            "CognomeLegaleRappresentante = ? ,NomeResponsabileConvenzione = ?,CognomeResponsabileConvenzione = ? ,TelefonoResponsabileConvenzione = ?," +
                            "EmailResponsabileConvenzione = ?, PathPDFConvenzione=?,DurataConvenzione=?,ForoControversia = ?,DataConvenzione=?, Attivo=?, ModuloConvenzione=?, Descrizione=?, Link = ? WHERE IDAzienda = ? ");

            this.regAzienda = connection.prepareStatement
                    ("INSERT INTO azienda(RagioneSociale,IndirizzoSedeLegale,CFiscalePIva,NomeLegaleRappresentante," +
                            "CognomeLegaleRappresentante,NomeResponsabileConvenzione,CognomeResponsabileConvenzione,TelefonoResponsabileConvenzione," +
                            "EmailResponsabileConvenzione,ForoControversia, Descrizione, Link, User ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

        } catch (SQLException ex) {
            throw new DaoException("Error:PrepareStatement error", ex);

        }
    }


    private void setAziendaObject(Azienda azienda, ResultSet resultSet) throws DaoException {
        try {
            azienda.setIDAzienda(resultSet.getInt("IDAzienda"));
            azienda.setRagioneSociale(resultSet.getString("RagioneSociale"));
            azienda.setIndirizzoSedeLegale(resultSet.getString("IndirizzoSedeLegale"));
            azienda.setCFiscalePIva(resultSet.getString("CFiscalePIva"));
            azienda.setNomeLegaleRappresentante(resultSet.getString("NomeLegaleRappresentante"));
            azienda.setCognomeLegaleRappresentante(resultSet.getString("CognomeLegaleRappresentante"));
            azienda.setNomeResponsabileConvenzione(resultSet.getString("NomeResponsabileConvenzione"));
            azienda.setCognomeResponsabileConvenzione(resultSet.getString("CognomeResponsabileConvenzione"));
            azienda.setTelefonoResponsabileConvenzione(resultSet.getString("TelefonoResponsabileConvenzione"));
            azienda.setEmailResponsabileConvenzione(resultSet.getString("EmailResponsabileConvenzione"));
            azienda.setPathPDFConvenzione(resultSet.getString("PathPDFConvenzione"));
            azienda.setDurataConvenzione(resultSet.getInt("DurataConvenzione"));
            azienda.setForoControversia(resultSet.getString("ForoControversia"));
            azienda.setDataConvenzione(resultSet.getDate("DataConvenzione"));
            azienda.setAttivo(resultSet.getInt("Attivo"));
            azienda.setModuloConvenzione(resultSet.getBoolean("ModuloConvenzione"));
            azienda.setDescrizione(resultSet.getString("Descrizione"));
            azienda.setLink(resultSet.getString("Link"));
            azienda.setCreateDate(resultSet.getTimestamp("CreateDate"));
            azienda.setUpdateDate(resultSet.getTimestamp("UpdateDate"));
            azienda.setUser(resultSet.getInt("User"));
        } catch (SQLException e) {
            throw new DaoException("Errore nel creare oggetto Azienda", e);
        }
    }

    private void setListAzienda(List<Azienda> aziende, ResultSet resultSet) throws DaoException {
        try {
            while (resultSet.next()) {
                Azienda azienda = new Azienda();
                setAziendaObject(azienda, resultSet);
                aziende.add(azienda);
            }
        } catch (SQLException e) {
            throw new DaoException("Errore nel creare Lista oggetti Azienda", e);
        }
    }


    public void updateAzienda(Azienda azienda) throws DaoException {
        /*
        "UPDATE azienda SET RagioneSociale = ? ,IndirizzoSedeLegale = ? ,CFiscalePIva = ?,NomeLegaleRappresentante = ?," +
        "CognomeLegaleRappresentante = ? ,NomeResponsabileConvenzione = ?,CognomeResponsabileConvenzione = ? ,TelefonoResponsabileConvenzione = ?," +
        "EmailResponsabileConvenzione = ?, PathPDFConvenzione=?,DurataConvenzione=?,ForoControversia = ?,DataConvenzione=?, Attivo=?, ModuloConvenzione=?, Descrizione=?, Link = ? WHERE IDAzienda = ?
         */
        try {
            this.init();
            this.updateAzienda.setString(1, azienda.getRagioneSociale());
            this.updateAzienda.setString(2, azienda.getIndirizzoSedeLegale());
            this.updateAzienda.setString(3, azienda.getCFiscalePIva());
            this.updateAzienda.setString(4, azienda.getNomeLegaleRappresentante());
            this.updateAzienda.setString(5, azienda.getCognomeLegaleRappresentante());
            this.updateAzienda.setString(6, azienda.getNomeResponsabileConvenzione());
            this.updateAzienda.setString(7, azienda.getCognomeResponsabileConvenzione());
            this.updateAzienda.setString(8, azienda.getTelefonoResponsabileConvenzione());
            this.updateAzienda.setString(9, azienda.getEmailResponsabileConvenzione());
            this.updateAzienda.setString(10, azienda.getPathPDFConvenzione());
            this.updateAzienda.setInt(11, azienda.getDurataConvenzione());
            this.updateAzienda.setString(12, azienda.getForoControversia());
            this.updateAzienda.setDate(13, azienda.getDataConvenzione());
            this.updateAzienda.setInt(14, azienda.getAttivo());
            this.updateAzienda.setBoolean(15, azienda.getModuloConvenzione());
            this.updateAzienda.setString(16, azienda.getDescrizione());
            this.updateAzienda.setString(17, azienda.getLink());
            this.updateAzienda.setInt(18, azienda.getIDAzienda());
            this.updateAzienda.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Errore esecuzione update", e);
        }
    }

    public void setAzienda(Azienda azienda) throws DaoException {
    /*
    INSERT INTO azienda(RagioneSociale,IndirizzoSedeLegale,CFiscalePIva,NomeLegaleRappresentante," +
    "CognomeLegaleRappresentante,NomeResponsabileConvenzione,CognomeResponsabileConvenzione,TelefonoResponsabileConvenzione," +
    "EmailResponsabileConvenzione, PathPDFConvenzione,DurataConvenzione,ForoControversia,DataConvenzione, Attivo, ModuloConvenzione, Descrizione, " +
    "Link, User ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
     */
        try {
            this.init();
            this.insertAzienda.setString(1, azienda.getRagioneSociale());
            this.insertAzienda.setString(2, azienda.getIndirizzoSedeLegale());
            this.insertAzienda.setString(3, azienda.getCFiscalePIva());
            this.insertAzienda.setString(4, azienda.getNomeLegaleRappresentante());
            this.insertAzienda.setString(5, azienda.getCognomeLegaleRappresentante());
            this.insertAzienda.setString(6, azienda.getNomeResponsabileConvenzione());
            this.insertAzienda.setString(7, azienda.getCognomeResponsabileConvenzione());
            this.insertAzienda.setString(8, azienda.getTelefonoResponsabileConvenzione());
            this.insertAzienda.setString(9, azienda.getEmailResponsabileConvenzione());
            this.insertAzienda.setString(10, azienda.getPathPDFConvenzione());
            this.insertAzienda.setInt(11, azienda.getDurataConvenzione());
            this.insertAzienda.setString(12, azienda.getForoControversia());
            this.insertAzienda.setDate(13, azienda.getDataConvenzione());
            this.insertAzienda.setInt(14, azienda.getAttivo());
            this.insertAzienda.setBoolean(15, azienda.getModuloConvenzione());
            this.insertAzienda.setString(16, azienda.getDescrizione());
            this.insertAzienda.setString(17, azienda.getLink());
            this.insertAzienda.setInt(18,azienda.getUser());
            this.insertAzienda.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Errore esecuzione update", e);
        }
    }


    public void setRegisterazienda(Azienda azienda, User user) throws DaoException {
        /*
        INSERT INTO azienda(RagioneSociale,IndirizzoSedeLegale,CFiscalePIva,NomeLegaleRappresentante," +
        "CognomeLegaleRappresentante,NomeResponsabileConvenzione,CognomeResponsabileConvenzione,TelefonoResponsabileConvenzione," +
        "EmailResponsabileConvenzione,ForoControversia, Descrizione, Link, User ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)
         */
        try {
            this.init();
            this.regAzienda.setString(1, azienda.getRagioneSociale());
            this.regAzienda.setString(2, azienda.getIndirizzoSedeLegale());
            this.regAzienda.setString(3, azienda.getCFiscalePIva());
            this.regAzienda.setString(4, azienda.getNomeLegaleRappresentante());
            this.regAzienda.setString(5, azienda.getCognomeLegaleRappresentante());
            this.regAzienda.setString(6, azienda.getNomeResponsabileConvenzione());
            this.regAzienda.setString(7, azienda.getCognomeResponsabileConvenzione());
            this.regAzienda.setString(8, azienda.getTelefonoResponsabileConvenzione());
            this.regAzienda.setString(9, azienda.getEmailResponsabileConvenzione());
            this.regAzienda.setString(10, azienda.getForoControversia());
            this.regAzienda.setString(11, azienda.getDescrizione());
            this.regAzienda.setString(12, azienda.getLink());
            this.regAzienda.setInt(13, user.getIDUser());
            this.regAzienda.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Errore esecuzione update", e);
        }
    }


    public Azienda getAziendaByRS(String RS) throws DaoException {
        Azienda azienda = new Azienda();
        try {
            this.init();
            this.selectAziendaByRS.setString(1, RS);
            ResultSet resultSet = this.selectAziendaByRS.executeQuery();
            if (resultSet.next()) {
                setAziendaObject(azienda, resultSet);
            } else {
                throw new DaoException("Query selectAziendaByRS con risultato vuoto");
            }
        } catch (SQLException e) {
            throw new DaoException("Errore ", e);
        }
        return azienda;
    }


    public List<Azienda> getAllAzienda() throws DaoException {
        List<Azienda> aziende = new ArrayList<>();
        try {
            this.init();
            ResultSet resultSet = this.selectAllAzienda.executeQuery();
            setListAzienda(aziende, resultSet);
        } catch (SQLException e) {
            throw new DaoException("Errore query", e);
        }
        return aziende;
    }

    public List<Azienda> getAllAziendeAttive() throws DaoException {
        List<Azienda> convenzioni = new ArrayList<>();
        try {
            this.init();
            ResultSet resultSet = this.selectAllAziendaAttiva.executeQuery();
            setListAzienda(convenzioni, resultSet);
        } catch (SQLException e) {
            throw new DaoException("Errore query", e);
        }
        return convenzioni;
    }

    public List<Azienda> getLastFiveConvenzioni() throws DaoException {
        List<Azienda> lastfiveconvenzioni = new ArrayList<>();
        try {
            this.init();
            ResultSet resultSet = this.selectLastFiveConvenzioni.executeQuery();
            setListAzienda(lastfiveconvenzioni, resultSet);
        } catch (SQLException e) {
            throw new DaoException("Errore query", e);
        }
        return lastfiveconvenzioni;
    }

    public Azienda getAziendaByID(int ID) throws DaoException {
        Azienda azienda = new Azienda();
        try {
            this.init();
            this.selectAziendaByID.setInt(1, ID);
            ResultSet resultSet = selectAziendaByID.executeQuery();
            if (resultSet.next()) {
                setAziendaObject(azienda, resultSet);
            } else {
                throw new DaoException("Query selectAziendaByID con risultato vuoto");
            }
        } catch (SQLException e) {
            throw new DaoException("Errore query azienda", e);
        }
        return azienda;
    }


    public Azienda getAziendaByIDuser(int ID) throws DaoException {
        Azienda azienda = new Azienda();
        try {
            this.init();
            this.selectAziendaByIDuser.setInt(1, ID);
            ResultSet resultSet = selectAziendaByIDuser.executeQuery();
            if (resultSet.next()) {
                setAziendaObject(azienda, resultSet);
            } else {
                throw new DaoException("Query selectAziendaByIDuser con risultato vuoto");
            }
        } catch (SQLException e) {
            throw new DaoException("Errore query azienda", e);
        }
        return azienda;
    }


    public List<Azienda> getAllAziendaPendenti() throws DaoException {
        List<Azienda> aziende = new ArrayList<>();
        try {
            this.init();
            ResultSet resultSet = this.selectAllPendentAzieda.executeQuery();
            while (resultSet.next()) {
                Azienda azienda = new Azienda();
                setAziendaObject(azienda, resultSet);
                aziende.add(azienda);
            }
        } catch (SQLException e) {
            throw new DaoException("Errore query", e);
        }
        return aziende;
    }


    public boolean ifAziendaMakeModulo(Azienda azienda) throws DaoException {
        try {
            this.init();
            this.selectAziendaByID.setInt(1, azienda.getIDAzienda());
            ResultSet resultSet = this.selectAziendaByID.executeQuery();
            if (resultSet.next()) {
                return resultSet.getBoolean("ModuloConvenzione");
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new DaoException("Errore query", e);
        }
    }

    public void destroy() throws DaoException {
        try {
            this.selectAziendaByRS.close();
            this.insertAzienda.close();
            this.selectAllAzienda.close();
            this.selectAziendaByID.close();
            this.selectAllAziendaAttiva.close();
            this.selectLastFiveConvenzioni.close();
            this.selectAziendaByIDuser.close();
            this.regAzienda.close();
            this.updateAzienda.close();
            this.selectAllPendentAzieda.close();
            super.destroy();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Error destroy in azienda", ex);
        }
    }

}

