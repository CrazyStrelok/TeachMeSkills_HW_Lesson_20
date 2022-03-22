package join;
import java.sql.*;

public class JoinTablesImpl implements JoinTables {
    private java.sql.Connection connection;
    private Statement statement;
    private static  String JOIN_TABLES = "SELECT * FROM students , cities ";

    public JoinTablesImpl(Statement statement) {
        this.connection = connection;
        this.statement = statement;
    }

    @Override
    public void joinTables() throws SQLException {
        try {
            ResultSet resultSet = statement.executeQuery(JOIN_TABLES);
            while (resultSet.next()) {
//                System.out.printf("%s - %s - %d - %d - %s - %s\n",
//                        resultSet.getString("name"),
//                        resultSet.getString("last_name"),
//                        resultSet.getInt("age"),
//                        resultSet.getInt("idcities"),
//                        resultSet.getString("name"),
//                        resultSet.getString("info"));
                int id = resultSet.getInt("idstudents");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                int idcities = resultSet.getInt("idcities");
                String city = resultSet.getString("City");
                String info = resultSet.getString("info");

                System.out.print("idstudent " + id);
                System.out.print(" name " + name);
                System.out.print(" lastName " + lastName);
                System.out.print(" age " + age);
                System.out.print(" idcities " + idcities);
                System.out.print(" city " + city);
                System.out.println(" info " + info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
