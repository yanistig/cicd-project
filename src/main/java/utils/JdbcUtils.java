package utils;

import entities.Client;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.postgresql.util.PSQLException;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JdbcUtils {

    private static Logger logger = Logger.getLogger(JdbcUtils.class);

    private static final String url = "jdbc:postgresql://localhost/";
    private static final String user = "testcicd";

    static public Connection connect(String dbName) {
        // To singleton, use the static variable already created
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url + dbName, user, "helloWorld");
            logger.info("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    static public void insertData(Connection conn, Class<? extends Client> table, JSONObject data) {
        Statement stmt = null;

        try {
            logger.info("inserting Record...");
            stmt = conn.createStatement();
            StringBuilder str = new StringBuilder();

            int i = 0;
            str.append("INSERT INTO " + table.getSimpleName() + " (");
            str.append(Arrays.stream(table.getDeclaredFields())
                    .map(field -> field.getName())
                    .collect(Collectors.joining(", ")));

            str.append(')');

            /*
            for (Field x : table.getDeclaredFields()) {
                if (i++ == table.getDeclaredFields().length - 1) {
                    str.append(x.getName() + ")");
                } else {
                    str.append(x.getName() + ",");
                }
            }
            */
            str.append(" VALUES(");
            str.append(Arrays.stream(table.getDeclaredFields())
                    .map(field -> data.get(field.getName()).toString())
                    .map(field -> field.replace("'", "_"))
                    .map(field -> "'" + field + "'")
                    .collect(Collectors.joining(", ")));

            str.append(");");
/*
            int j = 0;
            for (Field x : table.getDeclaredFields()) {
                String currentField = data.get(x.getName()).toString();
                String generatedData = null;

                if (currentField.contains("'")) {
                    generatedData = currentField.replace("'", "_");
                    System.out.println(generatedData);
                } else
                    generatedData = currentField;

                if (j++ == table.getDeclaredFields().length - 1) {
                    str.append("\'" + generatedData + "\'" + ");");   // " VALUE( \'toto', 'tata', 'O\'ckel'
                } else {
                    str.append("\'" + generatedData + "\'" + ",");
                }
            }*/
            stmt.executeUpdate(str.toString());
            logger.info("Records inserted successfully...");
        } catch (PSQLException se) {
            System.out.println(se.getMessage());
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
        } // end try
    }
}
