package Model;
import java.sql.*;
import java.util.List;
public class Countries {
    private int countryId;
    private String countrysName;

    public Countries() {
    }

    public Countries(String countrysName) {
        this.countrysName = countrysName;
    }
    
    public Countries(int countryId, String countrysName) {
        this.countryId = countryId;
        this.countrysName = countrysName;
    }
    public Countries(ResultSet rs) throws SQLException{
        this.countryId= rs.getInt("country_Id");
        this.countrysName= rs.getString("COUNTRY_NAME");
    }
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountrysName() {
        return countrysName;
    }

    public void setCountrysName(String countrysName) {
        this.countrysName = countrysName;
    }
    @Override
    public String toString() {
        return countrysName;  
    }
}
