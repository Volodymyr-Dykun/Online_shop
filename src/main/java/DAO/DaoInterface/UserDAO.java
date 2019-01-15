package DAO.DaoInterface;

import Entity.User;

import java.sql.SQLException;

public interface UserDAO {

    void addUser(User user) throws SQLException;
    void updateUser(int id, User user) throws SQLException;
    User getUser(int id);
    void deleteUser(int id) throws SQLException;
    void closeConnection();

}
