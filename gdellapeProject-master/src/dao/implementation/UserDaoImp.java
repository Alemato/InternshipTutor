package dao.implementation;

import dao.data.DaoDataMySQLImpl;
import dao.exception.DaoException;
import dao.interfaces.UserDao;
import model.User;

import javax.jws.soap.SOAPBinding;
import java.lang.ref.PhantomReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp extends DaoDataMySQLImpl {

    private PreparedStatement selectUserByEmail;
    private PreparedStatement selectUserById;
    private PreparedStatement insertUser;
    private PreparedStatement selectAllUser;
    private PreparedStatement updateUser;
    private PreparedStatement selectUserByToken;
    private PreparedStatement setToken;
    private PreparedStatement existIsMail;
    private PreparedStatement delete;


    @Override
    public void init() throws DaoException {
        try {

            super.init();

            this.selectUserByEmail = connection.prepareStatement("SELECT * FROM user WHERE Email = ?");

            this.selectUserById = connection.prepareStatement("SELECT * FROM user WHERE IDuser = ?");

            this.insertUser = connection.prepareStatement("INSERT INTO user(Email,Password,TipologiaAccount,Token) VALUES (?,?,?,?)");

            this.selectAllUser = connection.prepareStatement("SELECT * FROM user");

            this.updateUser = connection.prepareStatement("UPDATE user SET Email = ?, Password = ?, Token = NULL WHERE IDuser = ?");

            this.selectUserByToken = connection.prepareStatement("SELECT * FROM user WHERE Token = ?");

            this.setToken = connection.prepareStatement("UPDATE user SET Token = ? WHERE IDuser = ?");

            this.existIsMail = connection.prepareStatement("SELECT * FROM user WHERE Email=?");

            this.delete = connection.prepareStatement("DELETE FROM user WHERE IDuser=?");

        } catch (SQLException ex) {
            throw new DaoException("Error:PrepareStatement error", ex);
        }
    }

    private void setUserObject(User user, ResultSet resultSet) throws DaoException {
        try {
            user.setIDUser(resultSet.getInt("IDUser"));
            user.setEmail(resultSet.getString("Email"));
            user.setPassword(resultSet.getString("Password"));
            user.setTipologiaAccount(resultSet.getInt("TipologiaAccount"));
            user.setToken(resultSet.getString("Token"));
            user.setCreateDate(resultSet.getTimestamp("CreateDate"));
            user.setUpdateDate(resultSet.getTimestamp("UpdateDate"));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("Errore nel creare oggetto User", e);
        }
    }
    
    private void setListOffertaTirocinio(List<User> users, ResultSet resultSet) throws DaoException {
        try {
            while (resultSet.next()) {
                User user = new User();
                setUserObject(user, resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("Errore nel creare Lista oggetti User", e);
        }
    }

    public void delete(User user) throws DaoException{
        try {
            this.init();
            this.delete.setInt(1, user.getIDUser());
            this.delete.executeUpdate();
        }catch (SQLException e) {
            throw new DaoException("Errore esecuzione delete " + user.getIDUser(), e);
        }
    }
    
    public User getUserByToken(String token) throws DaoException {
        User user = new User();
        this.init();
        try {
            this.selectUserByToken.setString(1, token);
            ResultSet resultSet = this.selectUserByToken.executeQuery();
            if (resultSet.next()) {
                setUserObject(user, resultSet);
            } else {
                throw new DaoException("Query con risultato vuoto");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("Errore esecuzione query", e);
        }
        return user;
    }

    //    @Override
    public User getUserByMail(String mail) throws DaoException {
        User user = new User();
        this.init();
        try {

            this.selectUserByEmail.setString(1, mail);
            ResultSet resultSet = this.selectUserByEmail.executeQuery();
            if (resultSet.next()) {
                setUserObject(user, resultSet);
            } else {
                throw new DaoException("Query con risultato vuoto");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Errore esecuzione query", ex);

        }
        return user;

    }

    public List<User> getAllUser() throws DaoException {
        List<User> users = new ArrayList<User>();
        this.init();
        try {
            ResultSet resultSet = this.selectAllUser.executeQuery();
            setListOffertaTirocinio(users, resultSet);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Errore esecuzione query", ex);

        }
        return users;

    }


    public User getUserByid(int id) throws DaoException {
        User user = new User();
        this.init();
        try {
            this.selectUserById.setInt(1, id);
            ResultSet resultSet = this.selectUserById.executeQuery();
            if (resultSet.next()) {
                setUserObject(user, resultSet);
            } else {
                throw new DaoException("Query con risultato vuoto");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Errore esecuzione query", ex);

        }
        return user;

    }

    public void setUser(User user) throws DaoException {

        try {
            this.init();
            this.insertUser.setString(1, user.getEmail());
            this.insertUser.setString(2, user.getPassword());
            this.insertUser.setInt(3, user.getTipologiaAccount());
            this.insertUser.setString(4, user.getToken());
            this.insertUser.executeUpdate();

        } catch (SQLException ex) {

            throw new DaoException("Errore esecuzione query", ex);

        }
    }

    public void setToken(User user) throws DaoException {
        try {
            this.init();
            this.setToken.setString(1, user.getToken());
            this.setToken.setInt(2, user.getIDUser());
            this.setToken.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(User user) throws DaoException {
        try {
            this.init();
            this.updateUser.setString(1, user.getEmail());
            this.updateUser.setString(2, user.getPassword());
            this.updateUser.setInt(3, user.getIDUser());
            this.updateUser.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public Boolean existIsMail(String mail) throws DaoException {
        boolean risultato = false;
        try {
            this.init();
            this.existIsMail.setString(1, mail);
            ResultSet resultSet = this.existIsMail.executeQuery();
            risultato = resultSet.next();
        } catch (SQLException e) {
            throw new DaoException("Errore Query", e);

        }
        return risultato;

    }


    public void destroy() throws DaoException {
        try {
            this.selectUserByEmail.close();
            this.selectUserById.close();
            this.insertUser.close();
            this.selectAllUser.close();
            this.updateUser.close();
            this.selectUserByToken.close();
            this.setToken.close();
            this.existIsMail.close();
            super.destroy();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Error destroy in BookDao", ex);
        }
    }
}