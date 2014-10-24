package code;

/**
 * Created: 10/14/14 4:06 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class LinearProbingHash {

    public String[] array;

    private int factor;

    public LinearProbingHash(int n) {
        array = new String[n];
        factor = n;
    }

    private int hashFunction(int input) {
        return input % factor;
    }

    public boolean put(int value) {
        int index = hashFunction(value);
        if (array[index] != null) {
            int newIndex = findNextEmptyIndex(index);
            if (newIndex == index) {
                return false;
            } else {
                array[newIndex] = Integer.toString(value);
                return true;
            }
        } else {
            array[index] = Integer.toString(value);
            return true;
        }
    }


    public int findNextEmptyIndex(int index) {
        int newIndex = index + 1;

        while (newIndex <= factor) {
            if (array[newIndex] == null) {
                return newIndex;
            } else {
                newIndex++;
            }
        }

        //reach the end; set to 0.
        newIndex = 0;
        while (newIndex <= index) {
            if (array[newIndex] == null) {
                return newIndex;
            } else {
                newIndex++;
            }
        }

        //this return will be same as index;
        return newIndex;
    }

    public Integer get(int key) {
        if (array[key] == null) {
            return null;
        }

        int val = Integer.parseInt(array[key]);
        if (hashFunction(val) == key) {
            return val;
        } else {
            return findNextVal(key);
        }
    }

    public Integer findNextVal(int key) {
        int index = key + 1;

        while (index <= factor) {
            if (array[index] == null) {
                return null;
            }
            int val = Integer.parseInt(array[index]);
            if (key == hashFunction(val)) {
                return val;
            }
            index++;
        }

        //index set to 0
        while (index <= key) {
            if (array[index] == null) {
                return null;
            }
            int val = Integer.parseInt(array[index]);
            if (key == hashFunction(val)) {
                return val;
            }
            index++;
        }

        // index ==key
        return null;

    }

    public static void main(String[] args) {
        LinearProbingHash linearProbingHash = new LinearProbingHash(5);
        for (String n : linearProbingHash.array) {
            System.out.println(n);
        }
    }


}
