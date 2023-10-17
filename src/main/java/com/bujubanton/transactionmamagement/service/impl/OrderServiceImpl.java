package com.bujubanton.transactionmamagement.service.impl;

import com.bujubanton.transactionmamagement.payload.OrderRequest;
import com.bujubanton.transactionmamagement.payload.OrderResponse;
import com.bujubanton.transactionmamagement.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        return null;
    }
}
