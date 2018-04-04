package database;

import java.sql.*;

public class Adapter {
//    private static Adapter ourInstance = new Adapter();
//
//    public static Adapter getInstance() {
//        return ourInstance;
//    }
//
//    private Adapter() {
//
//    }

    public static void main (String[] args) {
//        testConnect();
        Adapter sqlQuery = new Adapter();

        String queryTest = "Select * From customers Where CustomerId < 15";

        sqlQuery.createStatement(queryTest, "CustomerId");



    }

    public void exeQuery1 () {
        String query = "SELECT FirstName,LastName FROM employees";

        try (Connection conn = this.connect();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(query) ) {

            while (rs.next()) {

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void createStatement(String query, String columnName) {

        try {
            Connection conn = this.connect();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next() ) {
                System.out.println(rs.getString(columnName));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }



    private Connection connect() {
        String url = "jdbc:sqlite:C:/Users/Bao Thien/Dropbox/IdeaProjects/src/database/chinook.db"; // hjemme pc
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }


    public static void testConnect () {
        Connection conn = null;

        try {
//            String url = "jdbc:sqlite:C:/Users/BaoThien/Dropbox/IdeaProjects/src/database/chinook.db"; // skole pc
            String url = "jdbc:sqlite:C:/Users/Bao Thien/Dropbox/IdeaProjects/src/database/chinook.db"; // hjemme pc

            // create connection to database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite database has been established");

//            createStatement(conn);
            Statement statement = conn.createStatement();
            String query = "Select * From customers Where CustomerId < 15";
            ResultSet result = statement.executeQuery(query);

            while (result.next() ) {
                System.out.println("CustomerId: "+ result.getInt("CustomerId") +"  FirstName = " + result.getString("FirstName") + "    Address = " + result.getString("Address") );


            }


        } catch (SQLException e) {
            e.printStackTrace();
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.out.println(e.getMessage());

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        } // end finally


    }



}

