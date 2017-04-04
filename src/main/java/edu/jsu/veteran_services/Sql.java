package edu.jsu.veteran_services;


import java.sql.*;


public class Sql {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/";

    private Connection connection;


    public Sql(String database, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database");
            connection = DriverManager.getConnection(DB_URL + database, username, password);
        } catch(Exception se) {
            se.printStackTrace();
        }
    }

    public boolean isConnected() {
        return connection != null;
    }

    public Sql disconnect() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return this;
    }

    public Sql.Result query(String sql) {
        try {
            Statement statement = connection.createStatement();
            return new Sql.Result(statement, statement.executeQuery(sql));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public static class Result {
        public Statement statement;
        public ResultSet set;

        private Result(Statement statement, ResultSet set) {
            this.statement = statement;
            this.set = set;
        }

        public void close() {
            try {
                statement.close();
                set.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
