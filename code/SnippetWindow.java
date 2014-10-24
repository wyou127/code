package code;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created: 9/30/14 5:05 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 * <p/>
 * S=AABEACHBEHGCHBA
 * T= {A,B,C}
 */
public class SnippetWindow {

    public int findShortest(String s, Set<Character> set) {
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        int shortest = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                if (map.containsKey(s.charAt(i))) {
                    map.remove(s.charAt(i));
                }
                map.put(s.charAt(i), i);
                if (map.size() == set.size()) {
                    Map.Entry<Character, Integer> entry = map.entrySet().iterator().next();
                    int first = entry.getValue();
                    shortest = Math.min(shortest, i - first+1);
                }
            }

        }
        return shortest;
    }

    public static void main(String[] args) {
        SnippetWindow snippetWindow = new SnippetWindow();
        Set<Character> set = new HashSet<Character>();
        set.add('A');
        set.add('B');
        set.add('C');

        System.out.println(snippetWindow.findShortest("AABEACBEHGCHBA",set))  ;
    }
}
