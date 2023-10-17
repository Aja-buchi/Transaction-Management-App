package com.bujubanton.transactionmamagement.service;

import com.bujubanton.transactionmamagement.payload.OrderRequest;
import com.bujubanton.transactionmamagement.payload.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
