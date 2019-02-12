package collections;

import collections.speedtest.RunSpeedTestParams;
import collections.speedtest.RunSpeedTestParamsBuilder;
import collections.speedtest.SpeedTestRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.function.Function;

import static junit.framework.TestCase.assertTrue;

public class SpeedTest {

    private Function<RunSpeedTestParams, Double> runSpeedTest = new SpeedTestRunner();

    @Test
    public void test_contains_speed_my_list_and_map() {

        RunSpeedTestParamsBuilder builderMap = getMapSpeedParamBuilder();
        RunSpeedTestParamsBuilder builderList = getListSpeedParamBuilder();

        Double mapAvg = runSpeedTest.apply(builderMap.build());
        Double listAvg = runSpeedTest.apply(builderList.build());

        assertTrue(mapAvg < listAvg);

    }

    private RunSpeedTestParamsBuilder getListSpeedParamBuilder() {
        Class[] paramTypes = {Object.class};
        String[] params = {"aa"};
        return RunSpeedTestParamsBuilder.getBuilder()
                .testCases(5)
                .numberOfElements(200)
                .datastructure(new MyList<String>())
                .addMethodName("add")
                .containsMethodName("contains")
                .paramTypes(paramTypes)
                .params(params)
                .randomCreator(s -> RandomStringUtils.randomAlphanumeric(5));
    }

    private RunSpeedTestParamsBuilder getMapSpeedParamBuilder() {
        Class[] paramTypes = {Object.class, Object.class};
        String[] params = {"aa", "11"};
        return RunSpeedTestParamsBuilder.getBuilder()
                .testCases(5)
                .numberOfElements(200)
                .datastructure(new MyMap<String, String>())
                .addMethodName("put")
                .containsMethodName("containsKey")
                .paramTypes(paramTypes)
                .params(params)
                .randomCreator(s -> RandomStringUtils.randomAlphanumeric(5));
    }

    @Test
    public void test_contains_speed_my_map_and_hash_map() {

        Double myMapAvg = runSpeedTest.apply(getMapSpeedParamBuilder().build());
        Double hashMapAvg = runSpeedTest.apply(getMapSpeedParamBuilder()
                .datastructure(new HashMap<String, String>()).build());

        // :(
        assertTrue(hashMapAvg < myMapAvg);

    }

}
