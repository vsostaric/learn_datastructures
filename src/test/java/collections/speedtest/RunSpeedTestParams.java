package collections.speedtest;

import java.util.function.Function;

public class RunSpeedTestParams {

    private int testCases;
    private int numberOfElements;
    private Object datastructure;
    private String addMethodName;
    private String containsMethodName;
    private Class[] paramTypes;
    private Object[] params;
    private Function<Object, Object> randomCreator;

    public RunSpeedTestParams(
            int testCases,
            int numberOfElements,
            Object datastructure,
            String addMethodName,
            String containsMethodName,
            Class[] paramTypes,
            Object[] params,
            Function<Object, Object> randomCreator) {
        this.testCases = testCases;
        this.numberOfElements = numberOfElements;
        this.datastructure = datastructure;
        this.addMethodName = addMethodName;
        this.containsMethodName = containsMethodName;
        this.paramTypes = paramTypes;
        this.params = params;
        this.randomCreator = randomCreator;
    }

    public int getTestCases() {
        return testCases;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public Object getDatastructure() {
        return datastructure;
    }

    public String getAddMethodName() {
        return addMethodName;
    }

    public String getContainsMethodName() {
        return containsMethodName;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public Function<Object, Object> getRandomCreator() {
        return randomCreator;
    }
}
