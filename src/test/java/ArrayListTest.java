import org.example.ArrayListAbstract;
import org.example.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class ArrayListTest {
    @Before
    public void setupData() {
        testArray = new ArrayList<>();

        testArray.pushback(1);
        testArray.pushback(7);
        testArray.pushback(2);
        testArray.pushback(9);
        testArray.pushback(0);
        testArray.pushback(12);
        testArray.pushback(4);
        testArray.pushback(9);
        testArray.pushback(34);
        testArray.pushback(6);
    }

    @Test
    public void get() {
        Assert.assertEquals(testArray.get(6), Integer.valueOf(4));
    }

    @Test
    public void add() {
        testArray.pushback(10);
        testArray.add(20, 1);
        Assert.assertArrayEquals(testArray.toArray(), new Integer[]{1,20,7, 2, 9, 0, 12, 4, 9, 34, 6, 10});
    }

    @Test
    public void set() {
        testArray.set(0, 0);
        testArray.set(6,9);
        Assert.assertArrayEquals(testArray.toArray(), new Integer[]{0,7, 2, 9, 0, 12, 9, 9, 34, 6});
    }

    @Test
    public void remove() {
        testArray.remove(6);
        testArray.remove(0);
        testArray.remove(12);
        testArray.remove(9);
        Assert.assertArrayEquals(testArray.toArray(), new Integer[]{1,7, 2, 4, 9, 34});

    }

    @Test
    public void removeFromIndex() {
        testArray.removeFromIndex(0);
        testArray.removeFromIndex(testArray.size() - 2);
        testArray.removeFromIndex(4);
        Assert.assertArrayEquals(testArray.toArray(), new Integer[]{7, 2, 9, 0, 4, 9, 6});
    }

    @Test
    public void size() {
        Assert.assertEquals(testArray.size(), 10);
        testArray.clear();
        Assert.assertEquals(testArray.size(), 0);
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(testArray.isEmpty());
        testArray.clear();
        Assert.assertTrue(testArray.isEmpty());
    }

    @Test
    public void contains() {
        Assert.assertFalse(testArray.contains(100));
        Assert.assertTrue(testArray.contains(1));
    }

    @Test
    public void getIndex() {
        Assert.assertEquals(testArray.getIndex(8), -1);
        Assert.assertEquals(testArray.getIndex(0), 1);
    }

    private ArrayListAbstract<Integer> testArray;
}
