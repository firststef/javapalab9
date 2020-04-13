package app;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistController {
    public static boolean create(String name, String country) throws SQLException {
        String statement = "INSERT INTO `artists` (`id`, `name`, `country`) VALUES (NULL, ? , ? ); ";
        PreparedStatement pstmt = Database.getInstance().getConn().prepareStatement(statement);
        pstmt.setString(1, name);
        pstmt.setString(2, country);
        return pstmt.execute();
    }

    public static Artist findByName(String name) throws SQLException {
        String statement = "SELECT `id`, `name`, `country` FROM artists WHERE `name`= ? ;";
        PreparedStatement pstmt =  Database.getInstance().getConn().prepareStatement(statement);
        pstmt.setString(1, name);
        ResultSet set = pstmt.executeQuery();
        set.next();
        return new Artist(set.getInt("id"), set.getString("name"), set.getString("country"));
    }
}
