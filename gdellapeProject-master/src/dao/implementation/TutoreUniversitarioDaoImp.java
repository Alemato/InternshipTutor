package dao.implementation;

import dao.data.DaoDataMySQLImpl;
import dao.exception.DaoException;
import model.TutoreUniversitario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TutoreUniversitarioDaoImp extends DaoDataMySQLImpl implements dao.interfaces.TutoreUniversitarioDaoInterface {
    private PreparedStatement selectTutUniByID;
    private PreparedStatement selectAllTutUni;
    private PreparedStatement insertTutUni;
    private PreparedStatement selectTutoreByMail;
    private PreparedStatement updateTutoreUni;

    @Override
    public void init() throws DaoException {
        try {

            super.init();

            this.selectTutUniByID = connection.prepareStatement("SELECT * FROM tutoreuniversitario WHERE IDTutoreUni = ?");

            this.selectAllTutUni = connection.prepareStatement("SELECT * FROM tutoreuniversitario ");

            this.insertTutUni = connection.prepareStatement("INSERT INTO tutoreuniversitario(Nome,Cognome,Telefono,Email,Attivo) VALUES (?,?,?,?,?)");

            this.selectTutoreByMail = connection.prepareStatement("SELECT * FROM tutoreuniversitario WHERE Email = ?");

            this.updateTutoreUni = connection.prepareStatement("UPDATE tutoreuniversitario SET Nome=?,Cognome=?,Telefono=?,Email=?, Attivo = ? WHERE IDTutoreUni = ?");

        } catch (SQLException ex) {
            throw new DaoException("Error:PrepareStatement error", ex);

        }
    }

    private void setTutoreUniversitarioObject(TutoreUniversitario tutore, ResultSet resultSet) throws DaoException {
        try {
            tutore.setIDTutoreUni(resultSet.getInt("IDTutoreUni"));
            tutore.setNome(resultSet.getString("Nome"));
            tutore.setCognome(resultSet.getString("Cognome"));
            tutore.setTelefono(resultSet.getString("Telefono"));
            tutore.setEmail(resultSet.getString("Email"));
            tutore.setAttivo(resultSet.getBoolean("Attivo"));
            tutore.setCreateDate(resultSet.getTimestamp("CreateDate"));
            tutore.setUpdateDate(resultSet.getTimestamp("UpdateDate"));
        } catch (SQLException e) {
            throw new DaoException("Errore nel creare oggetto Tirocinate", e);
        }
    }

    private void setListTirocinante(List<TutoreUniversitario> tutoreUniversitarios, ResultSet resultSet) throws DaoException {
        try {
            while (resultSet.next()) {
                TutoreUniversitario tutoreUniversitario = new TutoreUniversitario();
                setTutoreUniversitarioObject(tutoreUniversitario, resultSet);
                tutoreUniversitarios.add(tutoreUniversitario);
            }
        } catch (SQLException e) {
            throw new DaoException("Errore nel creare Lista oggetti Tirocinate", e);
        }
    }

    @Override
    public TutoreUniversitario getTutoreUniByID(int ID) throws DaoException {
        TutoreUniversitario tutUni = new TutoreUniversitario();

        try {
            this.init();
            this.selectTutUniByID.setInt(1, ID);
            ResultSet resultSet = selectTutUniByID.executeQuery();
            if (resultSet.next()) {
                setTutoreUniversitarioObject(tutUni, resultSet);
            } else {
                throw new DaoException("Query getTutoreUniByID con risultato vuoto");
            }


        } catch (SQLException e) {
            throw new DaoException("Errore query select id ", e);
        }
        return tutUni;

    }

    @Override
    public List<TutoreUniversitario> getAllTutUni() throws DaoException {
        List<TutoreUniversitario> tutori = new ArrayList<>();
        this.init();
        try {
            ResultSet resultSet = selectAllTutUni.executeQuery();
            setListTirocinante(tutori, resultSet);
        } catch (SQLException e) {
            throw new DaoException("Errore query select ALL ", e);
        }
        return tutori;

    }

    @Override
    public TutoreUniversitario getTutoreByEmail(String email) throws DaoException {
        TutoreUniversitario tutUni = new TutoreUniversitario();
        try {
            this.init();
            this.selectTutoreByMail.setString(1, email);
            ResultSet resultSet = selectTutoreByMail.executeQuery();
            if (resultSet.next()) {
                setTutoreUniversitarioObject(tutUni, resultSet);
            } else {
                throw new DaoException("Query con risultato vuoto");
            }

        } catch (SQLException e) {
            throw new DaoException("Errore query select email ", e);
        }
        return tutUni;


    }

    @Override
    public void UpdateTutoreUni(TutoreUniversitario tutore) throws DaoException {
        this.init();
        try {
            this.updateTutoreUni.setString(1, tutore.getNome());
            this.updateTutoreUni.setString(2, tutore.getCognome());
            this.updateTutoreUni.setString(3, tutore.getTelefono());
            this.updateTutoreUni.setString(4, tutore.getEmail());
            this.updateTutoreUni.setBoolean(5, tutore.getAttivo());
            this.updateTutoreUni.setInt(6, tutore.getIDTutoreUni());
            this.updateTutoreUni.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("Errore Update Tirocinante", e);
        }
    }

    @Override
    public void setTutoreUni(TutoreUniversitario tutUni) throws DaoException {
        try {
            this.init();
            insertTutUni.setString(1, tutUni.getNome());
            insertTutUni.setString(2, tutUni.getCognome());
            insertTutUni.setString(3, tutUni.getTelefono());
            insertTutUni.setString(4, tutUni.getEmail());
            insertTutUni.setBoolean(5, tutUni.getAttivo());
            insertTutUni.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Errore inserimento tut uni ", e);
        }

    }

    public void destroy() throws DaoException {
        try {
            this.selectTutUniByID.close();
            this.selectAllTutUni.close();
            this.insertTutUni.close();
            this.selectTutoreByMail.close();
            this.updateTutoreUni.close();
            super.destroy();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Error destroy in Offerta tr", ex);
        }

    }

}
