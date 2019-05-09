package dao.interfaces;

import dao.exception.DaoException;
import model.User;

import java.util.List;

public interface UserDaoInterface {
    void delete(User user) throws DaoException;

    User getUserByToken(String token) throws DaoException;

    //    @Override
    User getUserByMail(String mail) throws DaoException;

    List<User> getAllUser() throws DaoException;

    User getUserByid(int id) throws DaoException;

    void setUser(User user) throws DaoException;

    void setToken(User user) throws DaoException;

    void update(User user) throws DaoException;

    Boolean existIsMail(String mail) throws DaoException;
}
