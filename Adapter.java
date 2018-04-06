package database;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.List;

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

//        sqlQuery.testQuery1();

//        String queryTest = "Select * From customers Where CustomerId < 15";
//        sqlQuery.createStatement(queryTest, "CustomerId","FirstName", "Address");

//        String query1 = "SELECT FirstName,LastName FROM employees";
//        sqlQuery.createStatement(query1, "EmployeeId", "FirstName", "LastName");

//        String query2 = "SELECT * FROM tracks where Milliseconds > 300000";
//        sqlQuery.createStatement(query2, "TrackId","Milliseconds","Name");

//        String query3 =
//                "SELECT A.Title\n" +
//                "FROM albums AS A JOIN tracks AS T ON A.AlbumId = t.AlbumId\n" +
//                "where Milliseconds > 300000";
//        sqlQuery.createStatement(query3, "Title");

//        String query4 = "SELECT Country, count() AS NumberByCountry From customers GROUP BY Country";
//        sqlQuery.createStatement(query4, "Country","NumberByCountry");

//        String query5 =
//                "SELECT FirstName,LastName, max(Total) AS HighestTotal \n" +
//                "FROM customers AS C join invoices AS I ON C.CustomerId = I.CustomerId";
//        sqlQuery.createStatement(query5, "FirstName","LastName","HighestTotal");

//        String query6 = "";
//        sqlQuery.getArtist("Accept");
//        sqlQuery.getArtist("Billy Cobham");

//        String query7 = "";
//        sqlQuery.getAlbums();
//
//        String query8 = "";
//        sqlQuery.renameArtist()

    }

//    public boolean renameArtist (Artist artist, String newName) {
//        String query =
//                "UPDATE artists\n" +
//                "SET Name = ?\n" +
//                "where artists.ArtistId = ?";
//
//        boolean found = false;
//
//        try {
//            Connection conn = this.connect();
//            Statement statement = conn.createStatement();
//
//            PreparedStatement preStatement = conn.prepareStatement(query);
//            preStatement.setString(1,newName);
//            preStatement.setString(artist);
//
//            found = preStatement.execute();
//
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return found;
//    }


//    // oppg 7
//    public List<Album> getAlbums (Artist artist) {
//        String query = "SELECT AlbumId, Title FROM albums AS AL JOIN artists AS A ON AL.ArtistId = A.ArtistId WHERE A.Name = ?";
//        List<Album> albumList = new List<Album>();
//        try {
//            Connection conn = this.connect();
//            Statement statement = conn.createStatement();
//
//            PreparedStatement preStatement = conn.prepareStatement(query);
//            preStatement.setString(1,artist);
//
//            ResultSet rs = preStatement.executeQuery();
//
//
//
//            while (rs.next() ) {
////                System.out.println("artist name: " + rs.getString("Name")  );
////                System.out.println(String.format("ArtistId: %-5s Artist name: %-5s", rs.getString("ArtistId"), rs.getString("Name") ) );
//                albumList.add(rs.getString("AlbumId"))
//            }
//
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return albumList;
//    }

    public Artist getArtist(String name) {
        String query = "SELECT ArtistId, Name From artists where Name= ?";
        Artist artist = null;

        try {
            Connection conn = this.connect();
            Statement statement = conn.createStatement();
//            ResultSet rs = statement.executeQuery();

            PreparedStatement preStatement = conn.prepareStatement(query);
            preStatement.setString(1,name);

            ResultSet rs = preStatement.executeQuery();

            while (rs.next() ) {
//                System.out.println("artist name: " + rs.getString("Name")  );
                System.out.println(String.format("ArtistId: %-5s Artist name: %-5s", rs.getString("ArtistId"), rs.getString("Name") ) );

                artist = new Artist(rs.getInt("artistId"), rs.getString("name"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return artist;
    }

    public void testQuery1 () {
        String query = "SELECT FirstName,LastName FROM employees";

        try (Connection conn = this.connect();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(query) ) {

            while (rs.next()) {
                System.out.println(String.format("%s: %d", "EmployeeId", rs.getInt("EmployeeId") ));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void createStatement(String query, String columnName1) {

        try {
            Connection conn = this.connect();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next() ) {

                System.out.println(String.format("%s: %-10s ", columnName1, rs.getString(columnName1) ) );

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void createStatement(String query, String columnName1, String columnName2) {

        try {
            Connection conn = this.connect();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next() ) {


                System.out.println(String.format("%s: %-10s %s: %-10s", columnName1, rs.getString(columnName1), columnName2, rs.getString(columnName2) ) );

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void createStatement(String query, String columnName1, String columnName2, String columnName3) {

        try {
            Connection conn = this.connect();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next() ) {
//                System.out.println(
//                        columnName1 + ": " + rs.getString(columnName1) + "\t"
//                        + columnName2 + ": " + rs.getString(columnName2) + "\t\t"
//                        + columnName3 + ": " + rs.getString(columnName3) );

                System.out.println(String.format("%s: %-10s %s: %-10s %s: %-10s", columnName1, rs.getString(columnName1), columnName2, rs.getString(columnName2), columnName3, rs.getString(columnName3) ) );

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

