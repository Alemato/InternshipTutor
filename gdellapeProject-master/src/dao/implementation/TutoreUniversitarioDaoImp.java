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

public class TutoreUniversitarioDaoImp extends DaoDataMySQLImpl {
    private PreparedStatement selectTutUniByID;
    private PreparedStatement selectAllTutUni;
    private PreparedStatement insertTutUni;
    private PreparedStatement selectTutoreByMail;
    @Override
    public void init() throws DaoException {
        try {

            super.init();

            this.selectTutUniByID = connection.prepareStatement("SELECT * FROM tutoreuniversitario WHERE IDTutoreUni = ?");

            this.selectAllTutUni = connection.prepareStatement("SELECT * FROM tutoreuniversitario ");

            this.insertTutUni = connection.prepareStatement("INSERT INTO tutoreuniversitario(Nome,Cognome,Telefono,Email) VALUES (?,?,?,?)");

            this.selectTutoreByMail=connection.prepareStatement("SELECT * FROM tutoreuniversitario WHERE Email = ?");

        } catch (SQLException ex) {
            throw new DaoException("Error:PrepareStatement error", ex);

        }
    }

    public TutoreUniversitario getTutoreUniByID(int ID) throws DaoException {
        TutoreUniversitario tutUni = new TutoreUniversitario();
        try {
            this.init();
            this.selectTutUniByID.setInt(1, ID);
            ResultSet resultSet = selectTutUniByID.executeQuery();
            if (resultSet.next()) {
                tutUni.setIDTutoreUni(resultSet.getInt("IDTutoreUni"));
                tutUni.setNome(resultSet.getString("Nome"));
                tutUni.setCognome(resultSet.getString("Cognome"));
                tutUni.setTelefono(resultSet.getString("Telefono"));
                tutUni.setEmail(resultSet.getString("Email"));
            }
            return tutUni;
        } catch (SQLException e) {
            throw new DaoException("Errore query select id ", e);
        }

    }
    public List<TutoreUniversitario> getAllTutUni() throws DaoException {

        try {
            List<TutoreUniversitario> tutori = new ArrayList<>();
            this.init();
            ResultSet resultSet = selectAllTutUni.executeQuery();
            while (resultSet.next()) {
                TutoreUniversitario tutore = new TutoreUniversitario();
                tutore.setIDTutoreUni(resultSet.getInt("IDTutoreUni"));
                tutore.setNome(resultSet.getString("Nome"));
                tutore.setCognome(resultSet.getString("Cognome"));
                tutore.setTelefono(resultSet.getString("Telefono"));
                tutore.setEmail(resultSet.getString("Email"));

                tutori.add(tutore);
            }
            return tutori;
        } catch (SQLException e) {
            throw new DaoException("Errore query select ALL ", e);
        }

    }
    public TutoreUniversitario getTutoreByEmail(String email)throws DaoException
    {
        TutoreUniversitario tutUni = new TutoreUniversitario();
        try {
            this.init();
            this.selectTutoreByMail.setString(1, email);
            ResultSet resultSet =selectTutoreByMail.executeQuery();
            if (resultSet.next()) {
                tutUni.setIDTutoreUni(resultSet.getInt("IDTutoreUni"));
                tutUni.setNome(resultSet.getString("Nome"));
                tutUni.setCognome(resultSet.getString("Cognome"));
                tutUni.setTelefono(resultSet.getString("Telefono"));
                tutUni.setEmail(resultSet.getString("Email"));
            }
            return tutUni;
        } catch (SQLException e) {
            throw new DaoException("Errore query select email ", e);
        }


    }

    public void setTutoreUni(TutoreUniversitario tutUni) throws DaoException {
        try {
            this.init();
            insertTutUni.setString(1, tutUni.getNome());
            insertTutUni.setString(2, tutUni.getCognome());
            insertTutUni.setString(3, tutUni.getTelefono());
            insertTutUni.setString(4, tutUni.getEmail());
            insertTutUni.executeUpdate();


        } catch (SQLException e) {
            throw new DaoException("Errore inserimento tut uni ", e);
        }

    }

    public void destroy() throws DaoException {

        try {
            super.destroy();

            this.insertTutUni.close();
            this.selectTutUniByID.close();
            this.selectAllTutUni.close();


        } catch (SQLException ex) {
            ex.printStackTrace();

            throw new DaoException("Error destroy in Offerta tr", ex);


        }

    }

}
