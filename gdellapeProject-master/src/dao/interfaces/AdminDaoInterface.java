package dao.interfaces;

import dao.exception.DaoException;
import model.Admin;
import model.User;

import java.util.List;

public interface AdminDaoInterface {
    void setAdmin(Admin admin, User user) throws DaoException;

    void updateAdmin(Admin admin) throws DaoException;

    Admin getAdminByID(int ID) throws DaoException;

    Admin getAdminByIDuser(int user) throws DaoException;

    List<Admin> getAllAdmin() throws DaoException;
}
