package com.elcproject.OrderService.constants;

public class OrderStatus {

    public static final String ORDER_REQUESTED = "ORDER_REQUESTED";
    public static final String ORDER_PROCESSING = "ORDER_PROCESSING";
    public static final String STOCK_CHECK = "STOCK_CHECK";
    public static final String STOCK_INSUFFICIENT = "STOCK_INSUFFICIENT";
    public static final String PAYMENT_SUCCESS = "PAYMENT_SUCCESS";
    public static final String PAYMENT_FAILED = "PAYMENT_FAILED";
    public static final String ORDER_CONFIRMED = "ORDER_CONFIRMED";
    public static final String ORDER_CANCELLED = "ORDER_CANCELLED";

    private OrderStatus() {
    }
}
