package com.edutech.progressive.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
public class DatabaseConnectionManager {

    private static final Properties properties = new Properties();
    @Autowired
    private static Environment env;

    private static void loadProperties() throws IOException {
        // String url = env.getProperty("spring.datasource.url");
        // String username = env.getProperty("spring.datasource.username");
        // String password = env.getProperty("spring.datasource.password");
        // properties.put("url", url);
        // properties.put("username", username);
        // properties.put("password", password);

        properties.load(new FileInputStream("/home/coder/app/server/src/main/resources/application.properties"));

    }

    public static Connection getConnection() throws SQLException {
        try {
            loadProperties();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return DriverManager.getConnection(properties.getProperty("spring.datasource.url"), properties.getProperty("spring.datasource.username"),
                 properties.getProperty("spring.datasource.password"));
    }

}
