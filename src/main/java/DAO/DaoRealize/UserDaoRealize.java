package DAO.DaoRealize;

import DAO.DaoInterface.UserDAO;
import Entity.User;
import Util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;

public class UserDaoRealize implements UserDAO {

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

    public void addUser(User user) throws SQLException {

            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();

            closeConnection();

    }

    public void updateUser(int id, User user) throws SQLException {

            entityManager.getTransaction().begin();
            user.setId(id);
            entityManager.merge(user);
            entityManager.getTransaction().commit();

            closeConnection();
    }

    public User getUser(int id) {

        User user;

                entityManager.getTransaction().begin();
                user = entityManager.find(User.class, id);
                return user;
    }


    public void deleteUser(int id) throws SQLException {

        entityManager.getTransaction().begin();

        User user = entityManager.getReference(User.class,id);

        AddressDaoRealize addressDaoRealize = new AddressDaoRealize();
        addressDaoRealize.deleteAddress(user.getAddress().getId());

        user.setAddress(null);

        updateUser(id,user);

        entityManager.remove(user);

        entityManager.getTransaction().commit();


        closeConnection();

    }
}
