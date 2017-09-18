package finder;

import model.User;

import database.DbUtil;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFinder {
    private static final Logger LOGGER = LogManager.getLogger(UserFinder.class);
    private static final String SELECT_USER = "SELECT name FROM user WHERE id = ?";

    public User getUser(int id){
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_USER)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User();
                    user.setId(id);
                    user.setName(resultSet.getString("name"));
                    return user;
                }
            }
        }catch (SQLException e){
            LOGGER.info("Fail to Fetch data", e);
        }
        return null;
    }
}
