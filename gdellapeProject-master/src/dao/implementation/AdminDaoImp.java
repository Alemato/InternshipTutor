package dao.implementation;

import dao.data.DaoDataMySQLImpl;
import dao.exception.DaoException;
import model.Admin;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImp extends DaoDataMySQLImpl implements dao.interfaces.AdminDaoInterface {

    private PreparedStatement selectAdminByID;
    private PreparedStatement selectAllAdmin;
    private PreparedStatement insertAdmin;
    private PreparedStatement selectAdminByIDuser;
    private PreparedStatement updateAdmin;



    @Override
    public void init() throws DaoException {
        try {
            super.init();

            this.selectAdminByID = connection.prepareStatement("SELECT * FROM  admin WHERE IDAdmin = ?");

            this.selectAdminByIDuser = connection.prepareStatement("SELECT * FROM  admin WHERE User = ?");

            this.selectAllAdmin = connection.prepareStatement("SELECT * FROM admin");

            this.insertAdmin = connection.prepareStatement("INSERT INTO admin(Nome,Cognome,User) VALUES (?,?,?)");

            this.updateAdmin=connection.prepareStatement("UPDATE admin SET Nome=?,Cognome=? WHERE IDAdmin=?");

        } catch (SQLException ex) {
            throw new DaoException("Error:PrepareStatement error ADMIN", ex);
        }
    }

    private void setAdminObject(ResultSet resultSet, Admin admin)throws DaoException{
        try {
            admin.setIDadmin(resultSet.getInt("IDAdmin"));
            admin.setNome(resultSet.getString("Nome"));
            admin.setCognome(resultSet.getString("Cognome"));
            admin.setCreateDate(resultSet.getTimestamp("CreateDate"));
            admin.setUpdateDate(resultSet.getTimestamp("UpdateDate"));
            admin.setUser(resultSet.getInt("User"));
        } catch (SQLException e) {
            throw new DaoException("Errore inserimento dati nel oggetto Admin, possibile errore query", e);
        }


    }

    @Override
    public void setAdmin(Admin admin, User user) throws DaoException {
        try {
            this.init();
            this.insertAdmin.setString(1, admin.getNome());
            this.insertAdmin.setString(2, admin.getCognome());
            this.insertAdmin.setInt(3, user.getIDUser());
            insertAdmin.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Errore Set Admin", e);
        }
    }
    @Override
    public void updateAdmin(Admin admin) throws DaoException {
        try {
            this.init();
            this.updateAdmin.setString(1, admin.getNome());
            this.updateAdmin.setString(2, admin.getCognome());
            this.updateAdmin.setInt(3, admin.getIDadmin());
            updateAdmin.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Errore Update Admin", e);
        }
    }

    @Override
    public  Admin getAdminByID(int ID) throws DaoException {
        Admin admin = new Admin();
        this.init();
        try {
            this.selectAdminByID.setInt(1, ID);
            ResultSet resultSet = selectAdminByID.executeQuery();
            if (resultSet.next()) {
                setAdminObject(resultSet,admin);
            }else {
                throw new DaoException("Query Con Risultato Nullo");
            }
        } catch (SQLException e) {
            throw new DaoException("Errore query ", e);
        }
        return admin;
    }

    @Override
    public Admin getAdminByIDuser(int user) throws DaoException {
        Admin admin = new Admin();
        try {
            this.init();
            this.selectAdminByIDuser.setInt(1, user);
            ResultSet resultSet = selectAdminByIDuser.executeQuery();
            if (resultSet.next()) {
                setAdminObject(resultSet,admin);
            }else
            {
                throw new DaoException("Query Con Risultato Nullo");
            }
            return admin;

        } catch (SQLException e) {
            throw new DaoException("Errore query ", e);
        }
    }
    @Override
    public List<Admin> getAllAdmin() throws DaoException {
        List<Admin> listadmin = new ArrayList<>();
        try {
            this.init();
            ResultSet resultSet = selectAllAdmin.executeQuery();
            if (resultSet.next()) {
                Admin admin = new Admin();
                setAdminObject(resultSet, admin);
                listadmin.add(admin);
            }
            return listadmin;

        } catch (SQLException e) {
            throw new DaoException("Errore query ", e);
        }
    }


    public void destroy() throws DaoException {
        try {
            selectAdminByID.close();
            selectAllAdmin.close();
            insertAdmin.close();
            selectAdminByIDuser.close();
            updateAdmin.close();
            super.destroy();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Error close connection ", ex);
        }
    }
}
