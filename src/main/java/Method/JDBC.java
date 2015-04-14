//package Method;
//
///**
// * Created by salahakanda on 4/14/15.
// */
//public class JDBC {
//    public static void main( String args[]) {
//
//        String connectionURL = "jdbc:postgresql://localhost:5432/movies;user=java;password=samples";
//// Change the connection string according to your db, ip, username and password
//
//        try {
//
//            // Load the Driver class.
//            Class.forName("org.postgresql.Driver");
//            // If you are using any other database then load the right driver here.
//
//            //Create the connection using the static getConnection method
//            Connection con = DriverManager.getConnection (connectionURL);
//
//            //Create a Statement class to execute the SQL statement
//            Statement stmt = con.createStatement();
//
//            //Execute the SQL statement and get the results in a Resultset
//            ResultSet rs = stmt.executeQuery("select moviename, releasedate from movies");
//
//            // Iterate through the ResultSet, displaying two values
//            // for each row using the getString method
//
//            while (rs.next())
//                System.out.println("Name= " + rs.getString("moviename") + " Date= " + rs.getString("releasedate"));
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally {
//            // Close the connection
//            con.close();
//        }
//    }
//}
