package DAO.DaoInterface;


import Entity.Address;

import java.sql.SQLException;

public interface AddressDAO {

    void addAddress(Address address) throws SQLException;
    void updateAddress(int id, Address address) throws SQLException;
    Address getAddress(int id);
    void deleteAddress(int id);
    void closeConnection();
}
