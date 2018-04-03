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
        connect();

    }


    public static void createStatement(Connection conn) {
        try {
            Statement statement = conn.createStatement();

            statement.setQueryTimeout(30); // set timeout to 30 sec



        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

//    // create a database connection
//    connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
//
//    Statement statement = connection.createStatement();
//    statement.setQueryTimeout(30);  // set timeout to 30 sec.
//    // delete old table:
//    statement.executeUpdate("drop table if exists Users");
//    // create table_
//    statement.executeUpdate("create table Users (id integer(5), name text)");
//    // add a user:
//    PreparedStatement insertUser = connection.prepareStatement("insert into Users (id,name) values (?,?)");
//    insertUser.setInt(1,1);
//    insertUser.setString(2,"bob");
//    // perform query:
//    insertUser.execute();
//    // get all users:
//    PreparedStatement getAll = connection.prepareStatement("select * from Users");
//    ResultSet rs = statement.executeQuery("select * from Users");
//            while(rs.next())
//    {
//        // read the result set
//        System.out.println("id: "+ rs.getInt("id")+"  name = " + rs.getString("name"));
//    }


    public static void connect () {
        Connection conn = null;

        try {
            String url = "jdbc:sqlite:C:/Users/BaoThien/Dropbox/IdeaProjects/src/database/chinook.db";
//            String url = "jdbc:sqlite:C://Users//Bao Thien//Dropbox//IdeaProjects//src//database//chinook.db";

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

