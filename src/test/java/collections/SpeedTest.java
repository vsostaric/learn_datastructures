package collections;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertTrue;

public class SpeedTest {

    @Test
    public void test_contains_speed_my_list_and_map() {

        var list = new MyList<String>();
        var map = new MyMap<String, String>();

        int numberOfElements = RandomUtils.nextInt(100, 200);

        int testCases = 5;

        long[] listSpeeds = new long[5];
        long[] mapSpeeds = new long[5];

        for (int i = 0; i < testCases; i++) {
            IntStream.range(0, numberOfElements)
                    .forEach(_i -> list.add(RandomStringUtils.random(5)));
            IntStream.range(0, numberOfElements)
                    .forEach(_i -> map.put(RandomStringUtils.randomAlphabetic(12), RandomStringUtils.randomAlphanumeric(5)));

            list.add("aa");
            map.put("aa", "11");

            IntStream.range(0, numberOfElements)
                    .forEach(_i -> list.add(RandomStringUtils.random(5)));
            IntStream.range(0, numberOfElements)
                    .forEach(_i -> map.put(RandomStringUtils.randomAlphabetic(12), RandomStringUtils.randomAlphanumeric(5)));

            long start = System.nanoTime();
            assertTrue(list.contains("aa"));
            listSpeeds[i] = System.nanoTime() - start;

            start = System.nanoTime();
            assertTrue(map.containsKey("aa"));
            mapSpeeds[i] = System.nanoTime() - start;

        }

        Double listAvg = Arrays.stream(listSpeeds).average().orElse(0.0);
        Double mapAvg = Arrays.stream(mapSpeeds).average().orElse(0.0);

        assertTrue(mapAvg < listAvg);

    }

}
