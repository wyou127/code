import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created: 8/7/14 3:57 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class GenerateIngestionReport {


    private static final String TOTAL_BUNDLE = "select count(*) as count from wca_png_bundle_shell";
    private static final String TOTAL_FAILURE = "select count (*) as count  from ggo_errors where changelog_table = 'GROUP_CB_CHANGELOG'";
    private static final String PPO_ERROR = "select count(*) as count  from ggo_errors where error_msg like '%PPO%'";
    private static final String EMPTY_PRODUCT_ID = "select count(*) as count  from ggo_errors where error_msg like '%productId can%'";
    private static final String IRO_ERROR = "select count(*) as count  from ggo_errors where error_msg like '%IRO Response Error: IRO Response return fail or partial%' or error_msg like '%IRO bundle component request failed with Error%'" ;
    private static final String UNSUPPORTED_BUNDLE = "select count(*) as count  from ggo_errors where error_msg like '%Unsupported Bundle%'";
    private static final String BUNDLE_WITH_NO_ITEM = "select count(*) as count  from ggo_errors where error_msg like '%Data Error: No bundle Item%'";
    //private static final String NO_WALMART_SELLER_ID = "select count(*) as count from ggo_errors where error_msg like '%no offer with Walmart Seller Id%'";
    private static final String NO_ONLINE_STORE_OR_OFFER_OR_PRICING = "select count(*) as count from ggo_errors where error_msg like '%IRO Data Error:%' or error_msg like '%NoSuchElement%'";

    //private static final String NO_SUCH_ELEMENT = "select count(*) as count from ggo_errors where error_msg like '%NoSuchElement%'";


    private Connection connection;

    public GenerateIngestionReport(Connection connection) {
        this.connection = connection;
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

        Map<String, String> queryMap = new LinkedHashMap<String, String>();
        //queryMap.put("TOTAL_BUNDLE", TOTAL_BUNDLE);
        queryMap.put("TOTAL_FAILURE", TOTAL_FAILURE);
        queryMap.put("PPO_ERROR", PPO_ERROR);
        queryMap.put("EMPTY_PRODUCT_ID", EMPTY_PRODUCT_ID);
        queryMap.put("IRO_ERROR", IRO_ERROR);
        queryMap.put("UNSUPPORTED_BUNDLE", UNSUPPORTED_BUNDLE);
        queryMap.put("BUNDLE_WITH_NO_ITEM", BUNDLE_WITH_NO_ITEM);
        //queryMap.put("NO_PRICE", NO_SUCH_ELEMENT);
        //queryMap.put("NO_WALMART_SELLER_ID", NO_WALMART_SELLER_ID);
        queryMap.put("NO_ONLINE_STORE_OR_OFFER_OR_PRICING", NO_ONLINE_STORE_OR_OFFER_OR_PRICING);


        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@dfw-us-scan-pr3.prod.walmart.com:61290/gg_grouping.gecwalmart.com", "GG_GROUPING",
                    "GG_GROUPING");
            GenerateIngestionReport report = new GenerateIngestionReport(connection);
            report.generateReport(queryMap);

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }
    }

    public Map<String, String> generateReport(Map<String, String> queryMap) {
        Map<String, String> result = new LinkedHashMap<String, String>();
        System.out.println("TOTAL_BUNDLE: 5264");
        try {
            for (Map.Entry<String, String> entry : queryMap.entrySet()) {
                PreparedStatement ps = connection.prepareStatement(entry.getValue());
                ResultSet rs = ps.executeQuery();
                rs.next();
                String val = rs.getString("count");
                System.out.println(entry.getKey() + ": " + val);
                result.put(entry.getKey(), val);
            }
            //int total =  Integer.parseInt(result.get("TOTAL_BUNDLE"));
            int total = 5264;
            int fail = Integer.parseInt(result.get("TOTAL_FAILURE"));
            result.put("TOTAL_SUCCESS", Integer.toString(total-fail));
            System.out.println("TOTAL_SUCCESS: " + result.get("TOTAL_SUCCESS"));
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
        return result;
    }


}
