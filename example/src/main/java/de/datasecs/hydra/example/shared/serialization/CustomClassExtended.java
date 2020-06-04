package de.datasecs.hydra.example.shared.serialization;

import java.util.UUID;

/**
 * Created with love by DataSecs on 12.02.18
 */
public class CustomClassExtended {

    private String testStringExtended;

    private UUID testUUID;

    private CustomClassExtended customClassExtended;

    private long testLong;

    private Class<?> testClass;

    public CustomClassExtended() {
        // Obligatory construcotr
    }

    // Optional constructor
    public CustomClassExtended(String testStringExtended, UUID testUUID, CustomClassExtended customClassExtended, long testLong, Class<?> testClass) {
        this.testStringExtended = testStringExtended;
        this.testUUID = testUUID;
        this.customClassExtended = customClassExtended;
        this.testLong = testLong;
        this.testClass = testClass;
    }

    // Auto-generated toString method by IntelliJ for example purposes
    @Override
    public String toString() {
        return "CustomClassExtended {" + "\n" +
                "testStringExtended='" + testStringExtended + '\'' + ",\n" +
                "testUUID=" + testUUID + ",\n" +
                "customClassExtended=" + customClassExtended + ",\n" +
                "testLong=" + testLong + ",\n" +
                "testClass=" + testClass + "\n" +
                "}";
    }
}