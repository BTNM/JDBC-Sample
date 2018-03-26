package database;

import java.sql.*;

public class Adapter {
    private static Adapter ourInstance = new Adapter();

    public static void main (String[] args) {
        connect();
    }



    public static Adapter getInstance() {
        return ourInstance;
    }

    private Adapter() {

    }

    public static void connect () {
        Connection conn = null;

        try {
            String url = "jdbc:sqlite:chinook.db"; // "jdbc:sqlite:C:\Users\Bao Thien\Dropbox\IdeaProjects\src\database\chinook.db"

            // create connection to database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite database has been established");





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

