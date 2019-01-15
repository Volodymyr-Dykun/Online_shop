import DAO.DaoRealize.AddressDaoRealize;
import DAO.DaoRealize.UserDaoRealize;
import Entity.Address;
import Entity.Name;
import Entity.Phone;
import Entity.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        AddressDaoRealize addressDaoRealize = new AddressDaoRealize();
//        UserDaoRealize userDaoRealize = new UserDaoRealize();
//        merge();
int s = 0;

do {
  s+=2;
} while (s !=100);
        System.out.println(s);

    }

    public static void add() throws SQLException {
        Name name = new Name("Vova", "Tsvyk");
        Address address = new Address("Ukraine","Kiev","Naukova","43","116");
        Phone phone = new Phone("032333-66-17","096-555-69-96");

        User user = new User();
        user.setName(name);

        user.setPhone(phone);
        user.setEmail("vova@mail.com");
        user.setDateOfBirth("17.03.1996");

        UserDaoRealize userDaoRealize =  new UserDaoRealize();
        userDaoRealize.addUser(user);

        userDaoRealize.closeConnection();
    }

    public static void merge() throws SQLException {
        UserDaoRealize userDaoRealize =  new UserDaoRealize();

//        AddressDaoRealize addressDaoRealize = new AddressDaoRealize();
//        Address address = addressDaoRealize.getAddress(2);
//
//        System.out.println(address.toString());

        User user = userDaoRealize.getUser(2);
        userDaoRealize.closeConnection();
//        System.out.println(1);
//        user.setAddress(address);
//        System.out.println(2);
        user.setEmail("ia@ia.ua");

        userDaoRealize.updateUser(2, user);
        System.out.println(3);



        userDaoRealize.closeConnection();

    }

    public static void delete(int id) throws SQLException {
        UserDaoRealize userDaoRealize =  new UserDaoRealize();
        userDaoRealize.deleteUser(id);
    }
}
