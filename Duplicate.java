import java.util.HashSet;
import java.util.Set;

/**
 * Created: 7/10/14 4:09 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class Duplicate {
    private Set<String> itemIds;
    private Boolean duplicate;

    public Duplicate() {
       itemIds = new HashSet<String>();
       duplicate = false;
    }
    public Set<String> getItemIds() {
        return itemIds;
    }

    public void setItemIds(Set<String> itemIds) {
        this.itemIds = itemIds;
    }

    public void addItemIds(String itemIds)  {
        this.itemIds.add(itemIds);
    }

    public Boolean getDuplicate() {
        return duplicate;
    }

    public void setDuplicate(Boolean duplicate) {
        this.duplicate = duplicate;
    }
}
