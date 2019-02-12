package collections.speedtest;

import java.util.function.Function;

public class RunSpeedTestParamsBuilder {

    private int testCases;
    private int numberOfElements;
    private Object datastructure;
    private String addMethodName;
    private String containsMethodName;
    private Class[] paramTypes;
    private Object[] params;
    private Function<Object, Object> randomCreator;

    private RunSpeedTestParamsBuilder() {

    }

    public static RunSpeedTestParamsBuilder getBuilder() {
        return new RunSpeedTestParamsBuilder();
    }

    public RunSpeedTestParams build() {
        return new RunSpeedTestParams(
                testCases,
                numberOfElements,
                datastructure,
                addMethodName,
                containsMethodName,
                paramTypes,
                params,
                randomCreator);
    }

    public RunSpeedTestParamsBuilder testCases(int testCases) {
        this.testCases = testCases;
        return this;
    }

    public RunSpeedTestParamsBuilder numberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
        return this;
    }

    public RunSpeedTestParamsBuilder datastructure(Object datastructure) {
        this.datastructure = datastructure;
        return this;
    }

    public RunSpeedTestParamsBuilder addMethodName(String addMethodName) {
        this.addMethodName = addMethodName;
        return this;
    }

    public RunSpeedTestParamsBuilder containsMethodName(String containsMethodName) {
        this.containsMethodName = containsMethodName;
        return this;
    }

    public RunSpeedTestParamsBuilder paramTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
        return this;
    }

    public RunSpeedTestParamsBuilder params(Object[] params) {
        this.params = params;
        return this;
    }

    public RunSpeedTestParamsBuilder randomCreator(Function<Object, Object> randomCreator) {
        this.randomCreator = randomCreator;
        return this;
    }

}
