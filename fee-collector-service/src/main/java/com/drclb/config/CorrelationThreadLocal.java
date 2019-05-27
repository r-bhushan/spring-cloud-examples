package com.drclb.config;

public class CorrelationThreadLocal {
    private static final ThreadLocal<String> CORRELATION_ID = new ThreadLocal<>();

    public static String getCorrelationId() {
        return CORRELATION_ID.get();
    }

    public static void setCorrelationID(String cId) {
        CORRELATION_ID.set(cId);
    }
}
