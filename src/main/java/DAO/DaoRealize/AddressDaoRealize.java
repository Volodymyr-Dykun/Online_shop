package DAO.DaoRealize;

import DAO.DaoInterface.AddressDAO;
import Entity.Address;
import Util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;

public class AddressDaoRealize implements AddressDAO{

    public static EntityManagerFactory entityManagerFactory= null;
    public static EntityManager entityManager = null;

    static {
        entityManagerFactory = HibernateUtil.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }
    public void addAddress(Address address) throws SQLException {

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        closeConnection();
    }

    public void updateAddress(int id, Address address) throws SQLException {

        entityManager.getTransaction().begin();
        address.setId(id);
        entityManager.merge(address);
        entityManager.getTransaction().commit();

        closeConnection();
    }

    public Address getAddress(int id) {
        Address address;

        entityManager.getTransaction().begin();
        address = entityManager.find(Address.class, id);
        return address;
    }

    public void deleteAddress(int id) {

        entityManager.getTransaction().begin();
        Address address = entityManager.getReference(Address.class,id);

        entityManager.remove(address);

        entityManager.getTransaction().commit();

        entityManager.clear();
        closeConnection();
    }
}
