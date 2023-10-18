package com.bujubanton.transactionmamagement.service.impl;

import com.bujubanton.transactionmamagement.entity.Order;
import com.bujubanton.transactionmamagement.entity.Payment;
import com.bujubanton.transactionmamagement.exception.PaymentException;
import com.bujubanton.transactionmamagement.payload.OrderRequest;
import com.bujubanton.transactionmamagement.payload.OrderResponse;
import com.bujubanton.transactionmamagement.repository.OrderRepository;
import com.bujubanton.transactionmamagement.repository.PaymentRepository;
import com.bujubanton.transactionmamagement.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        //get order
        Order order = orderRequest.getOrder();
        //set a random UUID as a tacking number
        order.setOrderTrackingNumber(UUID.randomUUID().toString());

        order.setStatus("INPROGRESS");
        orderRepository.save(order);

        //get payment
        Payment payment = orderRequest.getPayment();
        if (!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment does not support card");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        //return response
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("PAYMENT SUCCESSFUL");

        return orderResponse;
    }
}
