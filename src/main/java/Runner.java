import connection.DBConnection;
import dao.StudentDaoImpl;
import join.JoinTablesImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner {
    public static void main(String[] args) {
        try {
            DBConnection connector = new DBConnection();
            Connection connection = connector.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = null;
//            StudentDaoImpl studentDao = new StudentDaoImpl(connection.createStatement(), connection, preparedStatement);
//            studentDao.getInfoStudents();
           // preparedStatement = connection.prepareStatement("students");
           // sudentDao.deleteStudent(7);
           // sudentDao.addStudent(2,"Igor","Karkarov",23);
            //LocationDaoImpl locationDao = new LocationDaoImpl(connection.createStatement(), connection,preparedStatement);
           // locationDao.getInfoLocations();
            //locationDao.deleteLocation(12);
            //locationDao.addLocation(17,"Soligorsk","Belarus");
              JoinTablesImpl joinTables = new JoinTablesImpl(connection.createStatement());
              joinTables.joinTables();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
