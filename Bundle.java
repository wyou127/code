import java.util.ArrayList;
import java.util.List;

/**
 * Created: 4/30/14 4:43 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class Bundle {
    private List<String> componentList;

    private String bundleId;

    public Bundle(String bundleId) {
        this.bundleId = bundleId;
        componentList = new ArrayList<String>();

    }


    public void addComponents(String component) {
        this.componentList.add(component);
    }

    public List<String> getComponentList() {
        return this.componentList;
    }

    public String getId(){
        return this.bundleId;
    }

    public String componentToString()  {
        String result = "";
        for (String component : this.componentList) {
            result += component + "|";

        }
        return result;
    }
}
