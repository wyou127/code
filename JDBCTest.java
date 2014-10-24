import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created: 6/10/14 3:29 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class JDBCTest {
    private static final List<String> requiredList = new ArrayList<String>(Arrays.asList("ITEM_ID", "ITEM_TYPE", "ITEM_NAME",
            "SHORT_DESCRIPTION", "LONG_DESCRIPTION", "SHELF_DESCRIPTION", "FINER_CATEGORIZATIONS", "PCH_ID",
            "PRIMARY_SHELF_ID",
            "RH_PATH", "IMAGE_URL", "DISPLAY_STATUS", "BUNDLE_SUBTYPE_ID"));
    private Connection connection;
    private String output;

    public JDBCTest(Connection connection, String output) {
        this.connection = connection;
        this.output = output;
    }

    public static void main(String[] args) {

        System.out.println("-------- Oracle JDBC Connection Testing ------");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;
        }

        System.out.println("Oracle JDBC Driver Registered!");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@ndc-vwmpprod.walmart.com:1521:wmpprod", "catalog",
                    "jamcat7p");
            System.out.println("Connection Succeeded!");


        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }
}
