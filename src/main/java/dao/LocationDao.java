package dao;

import model.Location;

import java.sql.SQLException;

public interface LocationDao {
    public void addLocation(int id, String name ,String info) throws SQLException;

    public boolean deleteLocation(int id) throws SQLException;

    public void  getInfoLocations() throws SQLException;

    public Location getLocationById(int id);
}
