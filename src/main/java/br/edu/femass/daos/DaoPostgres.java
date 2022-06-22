package br.edu.femass.daos;

import java.sql.*;

public abstract class DaoPostgres {

    protected final static String HOST = "localhost";
    protected final static String DATABASE = "music_shop_db";
    protected final static String PORT = "5432";
    protected final static String USER = "postgres";
    protected final static String PASSWORD = "123456";

    protected Connection getConnection() throws SQLException {
        final String url = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE;
        Connection connection = DriverManager.getConnection(url, USER, PASSWORD);

        return connection;
    }

    protected PreparedStatement getPreparedStatement(String sql, Boolean insert) throws Exception {
        PreparedStatement preparedStatement = null;

        return insert ? getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
                : getConnection().prepareStatement(sql);
    }
}
