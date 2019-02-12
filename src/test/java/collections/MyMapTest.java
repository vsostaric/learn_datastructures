package collections;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.stream.IntStream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class MyMapTest {

    @Test
    public void test_put() {

        var map = new MyMap<String, String>();
        map.put("aa", "11");
        assertEquals(1, map.size());

    }

    @Test
    public void test_put_many_elements() {

        int testSize = 1000;

        var map = new MyMap<String, String>();
        IntStream.range(0, testSize)
                .forEach(i -> map.put(RandomStringUtils.randomAlphabetic(2), RandomStringUtils.randomAlphanumeric(5)));
        assertEquals(testSize, map.size());

    }

    @Test
    public void test_get() {
        var map = new MyMap<String, String>();
        map.put("aa", "11");

        assertEquals("11", map.get("aa"));
    }

    @Test
    public void test_get_many_elements() {

        var map = new MyMap<String, String>();
        IntStream.range(0, RandomUtils.nextInt(100, 200))
                .forEach(i -> map.put(RandomStringUtils.randomAlphabetic(2), RandomStringUtils.randomAlphanumeric(5)));

        map.put("aabbccdd", "11");

        IntStream.range(0, RandomUtils.nextInt(100, 200))
                .forEach(i -> map.put(RandomStringUtils.randomAlphabetic(2), RandomStringUtils.randomAlphanumeric(5)));

        assertEquals("11", map.get("aabbccdd"));

    }

    @Test
    public void test_contains() {
        var map = new MyMap<String, String>();
        map.put("aa", "11");

        assertTrue(map.containsKey("aa"));
        assertFalse(map.containsKey("bb"));
    }

}
