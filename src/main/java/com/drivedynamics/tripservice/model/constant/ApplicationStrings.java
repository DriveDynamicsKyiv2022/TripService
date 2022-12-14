package com.drivedynamics.tripservice.model.constant;

public enum ApplicationStrings {
    PACKAGE_REPOSITORY(Constants.PACKAGE_REPOSITORY_VALUE),
    PROPERTY_NAME_SPRING_DATA_MONGODB_URI(Constants.PROPERTY_NAME_SPRING_DATA_MONGODB_URI_VALUE),
    PROPERTY_NAME_SPRING_DATA_MONGODB_DATABASE(Constants.PROPERTY_NAME_SPRING_DATA_MONGODB_DATABASE_VALUE);

    private final String value;

    ApplicationStrings(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }

    public static class Constants {
        public static final String PACKAGE_REPOSITORY_VALUE = "com.drivedynamics.tripservice.repository";
        public static final String PROPERTY_NAME_SPRING_DATA_MONGODB_URI_VALUE = "spring.data.mongodb.uri";
        public static final String PROPERTY_NAME_SPRING_DATA_MONGODB_DATABASE_VALUE = "spring.data.mongodb.database";
    }
}
