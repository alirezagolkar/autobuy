package com.dealers.autobuy.uri;

/**
 * Enum for Application end points
 * @author Ali Golkar
 */
public enum ApiEnum {
    API     (EndPoints.API),
    CLIENT  (EndPoints.CLIENT),
    BID     (EndPoints.BID),
    DEALER  (EndPoints.DEALER),
    VEHICLE (EndPoints.VEHICLE);

    private final String endPoint;

    ApiEnum(final String endPoint) {
        this.endPoint = endPoint;
    }

    public String getEndPoint() {
        return this.endPoint;
    }

    public static class EndPoints {
        public static final String API      =   "/api/v1";
        public static final String BID      =   API + "/bid";
        public static final String CLIENT   =   API + "/client";
        public static final String DEALER   =   API + "/dealer";
        public static final String VEHICLE  =   API + "/vehicle";
    }
}
