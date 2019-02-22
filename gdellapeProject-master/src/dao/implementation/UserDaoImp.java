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
    private  PreparedStatement updateUser;
    private PreparedStatement selectUserByToken;
    private PreparedStatement setToken;
    private PreparedStatement existIsMail;


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

            this.existIsMail= connection.prepareStatement("SELECT * FROM user WHERE Email=?");

        } catch (SQLException ex) {
         throw new DaoException("Error:PrepareStatement error", ex);

        }
    }


    public  User getUserByToken(String token) throws DaoException{
        User user= new User();
        try {
            this.init();
            this.selectUserByToken.setString(1,token);
            ResultSet resultSet = this.selectUserByToken.executeQuery();
            if (resultSet.next()) {
                user.setIDUser(resultSet.getInt("IDuser"));
                user.setEmail(resultSet.getString("Email"));
                user.setPassword(resultSet.getString("Password"));
                user.setTipologiaAccount(resultSet.getInt("TipologiaAccount"));
                user.setToken(resultSet.getString("Token"));
                user.setCreateDate(resultSet.getTimestamp("CreateDate"));
                user.setUpdateDate(resultSet.getTimestamp("UpdateDate"));
            }else{
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

        try {
            this.init();
            this.selectUserByEmail.setString(1,mail);
            ResultSet resultSet = this.selectUserByEmail.executeQuery();
            if (resultSet.next()) {
                user.setIDUser(resultSet.getInt("IDuser"));
                user.setEmail(resultSet.getString("Email"));
                user.setPassword(resultSet.getString("Password"));
                user.setTipologiaAccount(resultSet.getInt("TipologiaAccount"));

            }else{
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

        try {
            this.init();

            ResultSet resultSet = this.selectAllUser.executeQuery();
            while(resultSet.next()) {
                User user = new User();
                user.setIDUser(resultSet.getInt("IDuser"));
                user.setEmail(resultSet.getString("Email"));
                user.setPassword(resultSet.getString("Password"));
                user.setTipologiaAccount(resultSet.getInt("TipologiaAccount"));
                users.add(user);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Errore esecuzione query", ex);

        }
        return users;

    }




    public User getUserByid(int id) throws DaoException {
        User user = new User();
        try {
            this.init();
            this.selectUserById.setInt(1,id);
            ResultSet resultSet = this.selectUserById.executeQuery();
           //dobbiamo vedere se è null
            if (resultSet.next()) {
                user.setIDUser(resultSet.getInt("IDuser"));
                user.setEmail(resultSet.getString("Email"));
                user.setPassword(resultSet.getString("Password"));
                user.setTipologiaAccount(resultSet.getInt("TipologiaAccount"));

            }else{
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

    public void setToken(User user) throws DaoException{
        try{
            this.init();
            this.setToken.setString(1, user.getToken());
            this.setToken.setInt(2,user.getIDUser());
            this.setToken.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(User user) throws DaoException{
        try{
            this.init();
            this.updateUser.setString(1,user.getEmail());
            this.updateUser.setString(2,user.getPassword());
            this.updateUser.setInt(3,user.getIDUser());
            this.updateUser.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();

        }
    }

    public boolean existIsMail(String mail) throws DaoException
    {
        try {
            this.init();
            this.existIsMail.setString(1,mail);
            ResultSet resultSet=this.existIsMail.executeQuery();
            return (resultSet.next());
        }catch (SQLException e)
        {
            throw  new DaoException("Errore Query",e);
        }
    }



    public void destroy() throws DaoException {

        try {

            this.selectUserByEmail.close();
            this.insertUser.close();
            this.selectUserById.close();
            this.updateUser.close();
            this.existIsMail.close();


            super.destroy();

        } catch (SQLException ex) {
            ex.printStackTrace();

            throw new DaoException("Error destroy in BookDao", ex);


        }

    }
}