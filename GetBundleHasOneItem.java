import org.apache.commons.lang.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created: 6/25/14 10:29 AM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class GetBundleHasOneItem {

    private static final List<String> requiredList = new ArrayList<String>(Arrays.asList("ITEM_ID", "ITEM_TYPE", "ITEM_NAME",
            "SHORT_DESCRIPTION", "LONG_DESCRIPTION", "SHELF_DESCRIPTION", "FINER_CATEGORIZATIONS", "PCH_ID",
            "PRIMARY_SHELF_ID",
            "RH_PATH", "IMAGE_URL", "DISPLAY_STATUS", "BUNDLE_SUBTYPE_ID"));
    private Connection connection;
    private String output;

    public GetBundleHasOneItem(Connection connection, String output) {
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
                    "jdbc:oracle:thin:@dfw-us-scan-pr3.prod.walmart.com:61290/stg_grouping.gecwalmart.com", "STG_GROUPING",
                    "STG_GROUPING");
            String path = "/tmp/OneItemBundle";
            GetMissingFieldReport gfr = new GetMissingFieldReport(connection, path);
            gfr.writeReport();


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

    public void writeReport() {

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM WCA_PNG_BUNDLE_SHELL");

        Connection conn = null;

        try {
            FileWriter writer = new FileWriter(output);
            PreparedStatement ps = connection.prepareStatement(sb.toString());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                List<String> missingField = getMissingField(rs);
                if (missingField.size()>0) {
                    writer.append(rs.getString("ITEM_ID"));
                    writer.append(",");
                    writer.append(missingField.toString());
                    writer.append("\n");
                }
            }
            writer.flush();
            writer.close();

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        } catch (IOException ie) {
            System.out.println("IOException " + ie);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("SQL Exception: " + e);
                }
            }
        }
    }

    private List<String> getMissingField(ResultSet rs) throws SQLException {
        List<String> missingList = new ArrayList<String>();

        for (String field : requiredList) {
            if (StringUtils.isBlank(rs.getString(field))) {
                missingList.add(field);
            }
        }
        return missingList;
    }



}
