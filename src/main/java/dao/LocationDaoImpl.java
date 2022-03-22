package dao;

import model.Location;

import java.sql.*;

public class LocationDaoImpl implements LocationDao {
    private Statement statement;
    private static final int FIRST_STATEMENT_PARAM = 1;
    private static final int SECOND_STATEMENT_PARAM =2 ;
    private static final int THIRD_STATEMENT_PARAM = 3;
    private java.sql.Connection connection;
    private final PreparedStatement preparedStatement;

    public LocationDaoImpl(Statement statement, Connection connection, PreparedStatement preparedStatement) {
        this.statement = statement;
        this.connection = connection;
        this.preparedStatement = preparedStatement;
    }

    @Override
    public void addLocation(int id, String name ,String info) throws SQLException {
        try {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO cities (idcities,name, info) values (?, ?, ?)");
                statement.setInt(FIRST_STATEMENT_PARAM, id);
                statement.setString(SECOND_STATEMENT_PARAM, name);
                statement.setString(THIRD_STATEMENT_PARAM, info);
                statement.executeUpdate();
                System.out.println("Location was added");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    @Override
    public boolean deleteLocation(int id) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM cities WHERE idcities = ?");
            statement.setInt(FIRST_STATEMENT_PARAM, id);
            statement.executeUpdate();
            System.out.println("City was deleted");
            ResultSet resultSet =  statement.executeQuery("select * from cities");
            while (resultSet.next()) {
                System.out.printf("%s - %s\n",
                        resultSet.getString("name"),
                        resultSet.getString("info"));
            }

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    @Override
    public void getInfoLocations() throws SQLException {
        try {
            ResultSet resultSet =  statement.executeQuery("select * from cities");
            while (resultSet.next()){
                System.out.printf("%s - %s \n",
                        resultSet.getString("name"),
                        resultSet.getString("info"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        }


    @Override
    public Location getLocationById(int id) {

        return null ;
    }
}
