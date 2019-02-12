package collections;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.stream.IntStream;

import static junit.framework.TestCase.*;

public class MyListTest {

    @Test
    public void test_add() {
        var list = new MyList<String>();
        list.add("aa1");
        list.add("bb2");

        assertEquals(2, list.size());

    }

    @Test
    public void test_remove() {

        var list = new MyList<String>();
        list.add("aa1");
        list.add("bb2");

        assertEquals(2, list.size());

        list.remove("aa1");
        assertEquals(1, list.size());

    }

    @Test
    public void test_add_many_elements() {

        var list = new MyList<String>();

        IntStream.range(0, 100)
                .forEach(i -> list.add(RandomStringUtils.random(5)));

        assertEquals(100, list.size());


    }

    @Test
    public void test_contains() {

        var list = new MyList<String>();
        list.add("aa1");
        list.add("bb2");

        assertTrue(list.contains("aa1"));
        assertFalse(list.contains("cc3"));
    }

    @Test
    public void test_is_empty() {
        var list = new MyList<String>();
        assertTrue(list.isEmpty());

        list.add("aa1");
        assertFalse(list.isEmpty());

    }

}
