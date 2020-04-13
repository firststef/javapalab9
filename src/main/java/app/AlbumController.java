package app;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumController {
    public static boolean create(String name, int artistId, int releaseYear) throws SQLException {
        String statement = "INSERT INTO `albums` (`id`, `name`, `artist_id`, `release_year`) VALUES (NULL, ? , ? , ? ); ";
        PreparedStatement pstmt = Database.getInstance().getConn().prepareStatement(statement);
        pstmt.setString(1, name);
        pstmt.setInt(2, artistId);
        pstmt.setInt(3, releaseYear);
        return pstmt.execute();
    }

    public static Album findByArtist(int artistId) throws SQLException {
        String statement = "SELECT * FROM albums WHERE `artist_id`= ? ;";
        PreparedStatement pstmt = Database.getInstance().getConn().prepareStatement(statement);
        pstmt.setInt(1, artistId);
        ResultSet set = pstmt.executeQuery();
        set.next();
        return new Album(set.getInt("id"), set.getString("name"), set.getInt("artist_id"), set.getInt("release_year"));
    }
}
