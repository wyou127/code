package code;

import oracle.sql.CHAR;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: 10/7/14 3:56 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class SerializeDeserializeBST {
    public String serializeBST(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return null;
        } else {
            serializeBSTHelper(root, result);
            return result.toString();
        }
    }
    public void serializeBSTHelper(TreeNode root, List<Integer> result) {
        if (root ==null) {
            return;
        } else {
            result.add(root.val);
            serializeBSTHelper(root.left, result);
            serializeBSTHelper(root.right, result);
        }
    }

    public static void main(String[] args) {
        SerializeDeserializeBST serializeDeserializeBST = new SerializeDeserializeBST();
        TreeNode root = new TreeNode(30);
        serializeDeserializeBST.addNode(root,20) ;
        serializeDeserializeBST.addNode(root,10) ;
        serializeDeserializeBST.addNode(root,40) ;
        serializeDeserializeBST.addNode(root,35) ;
        serializeDeserializeBST.addNode(root,50) ;

        System.out.println(serializeDeserializeBST.serializeBST(root));
    }

    public void addNode(TreeNode root, int val) {
        if (root.val > val) {
            if (root.left ==null) {
                TreeNode newNode = new TreeNode(val);
                root.left = newNode;
            } else {
                addNode(root.left, val);
            }
        }  else if (root.val < val) {
            if (root.right ==null) {
                TreeNode newNode = new TreeNode (val);
                root.right = newNode;
            } else {
                addNode(root.right,val);
            }
        }    else {
            //do nothing;
        }

    }

}
