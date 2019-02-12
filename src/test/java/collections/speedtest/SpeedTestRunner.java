package collections.speedtest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertTrue;

public class SpeedTestRunner implements Function<RunSpeedTestParams, Double> {

    @Override
    public Double apply(RunSpeedTestParams testParams) {

        final Method addMethod;
        try {
            addMethod = testParams.getDatastructure().getClass().getMethod(testParams.getAddMethodName(), testParams.getParamTypes());
        } catch (NoSuchMethodException e) {
            return null;
        }

        long[] speeds = new long[testParams.getTestCases()];

        for (int i = 0; i < testParams.getTestCases(); i++) {
            IntStream.range(0, testParams.getNumberOfElements())
                    .forEach(_i -> {
                        try {
                            addMethod.invoke(testParams.getDatastructure(),
                                    Arrays.stream(testParams.getParams()).map(testParams.getRandomCreator()).toArray());
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    });

            try {
                addMethod.invoke(testParams.getDatastructure(), testParams.getParams());
            } catch (InvocationTargetException | IllegalAccessException e) {
                return null;
            }

            IntStream.range(0, testParams.getNumberOfElements())
                    .forEach(_i -> {
                        try {
                            addMethod.invoke(testParams.getDatastructure(),
                                    Arrays.stream(testParams.getParams()).map(testParams.getRandomCreator()).toArray());
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    });

            long start = System.nanoTime();
            try {
                assertTrue((Boolean) testParams.getDatastructure().getClass()
                        .getMethod(testParams.getContainsMethodName(), testParams.getParamTypes()[0])
                        .invoke(testParams.getDatastructure(), testParams.getParams()[0]));
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                return null;
            }

            speeds[i] = System.nanoTime() - start;
        }

        return Arrays.stream(speeds).average().orElse(0.0);

    }
}
