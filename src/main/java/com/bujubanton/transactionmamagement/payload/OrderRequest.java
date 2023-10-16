package com.bujubanton.transactionmamagement.payload;

import com.bujubanton.transactionmamagement.entity.Order;
import com.bujubanton.transactionmamagement.entity.Payment;
import lombok.Data;

@Data
public class OrderRequest {
    private Order order;
    private Payment payment;
}
