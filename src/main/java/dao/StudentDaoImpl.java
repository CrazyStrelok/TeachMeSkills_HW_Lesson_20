package dao;

import model.Student;
import java.sql.*;

public class StudentDaoImpl implements StudentDao {

    private static final int FIRST_STATEMENT_PARAM = 1;
    private static final int SECOND_STATEMENT_PARAM =2 ;
    private static final int THIRD_STATEMENT_PARAM = 3;
    private static final int FORTH_STATEMENT_PARAM = 4;
    private final Statement statement;
    private java.sql.Connection connection;
    private final PreparedStatement preparedStatement;



    public StudentDaoImpl(Statement statement, Connection connection, PreparedStatement preparedStatement) {
        this.statement = statement;
        this.connection = connection;
        this.preparedStatement = preparedStatement;
    }

    @Override
    public void addStudent(int id , String name,String lastName,int age) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO students (idstudents,name, last_name,age) values (?, ?, ?, ?)");
            statement.setInt(FIRST_STATEMENT_PARAM, id);
            statement.setString(SECOND_STATEMENT_PARAM, name);
            statement.setString(THIRD_STATEMENT_PARAM,lastName);
            statement.setInt(FORTH_STATEMENT_PARAM,age);
            statement.executeUpdate();
            System.out.println("Student was added");
            ResultSet resultSet =  statement.executeQuery("select * from students");
            while (resultSet.next()) {
                System.out.printf("%s - %s - %d\n",
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean deleteStudent(int id) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM students WHERE idstudents = ?");
            statement.setInt(FIRST_STATEMENT_PARAM, id);
            statement.executeUpdate();
            System.out.println("Student was deleted");
            ResultSet resultSet =  statement.executeQuery("select * from students");
            while (resultSet.next()) {
                System.out.printf("%s - %s - %d\n",
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age"));
            }

            return true;
           // int resultSet = preparedStatement.executeUpdate("DELETE FROM students WHERE idstudents = ? ");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    @Override
    public void getInfoStudents() throws SQLException {
        try {
            ResultSet resultSet =  statement.executeQuery("select * from students");
            while (resultSet.next()){
                System.out.printf("%s - %s - %d - %d\n",
                resultSet.getString("name"),
                resultSet.getString("last_name"),
                resultSet.getInt("age"),
                        resultSet.getInt("idcities"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }
}

