package ru.ibs.practice.tests.db.general;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.ibs.practice.config.DataSourceConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseTest {
    protected Connection connection;
    protected PreparedStatement statement;

    @BeforeEach
    public void setUp() {
        DataSource dataSource = new DataSourceConfig().getDataSource();

        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Не удалось установить соединение с базой данных");
        }
    }

    @AfterEach
    public void close() throws SQLException {
        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }
}