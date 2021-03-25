package com.example.demo.service.open;

import com.example.demo.exception.BadDataException;
import com.example.demo.models.realmodel.Order;
import com.example.demo.models.requests.openRequests.SendOrder;
import com.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class OpenServiceImpl implements OpenService{
    private final OrderRepository orderRepository;

    public OpenServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public String registration(SendOrder sendOrder) {
        if(sendOrder.getEmail()==null || sendOrder.getCompany()==null || sendOrder.getFullName()==null ||sendOrder.getPhone()==null){
            throw new BadDataException("empty line is not correct");
        }
        if(orderRepository.findByEmail(sendOrder.getEmail())!=null){
            throw new BadDataException("this email used try enother email");
        }
        Order order=new Order();
        order.setCreated_at(new Date());
        order.setCompany(sendOrder.getCompany());
        order.setEmail(sendOrder.getEmail());
        order.setName(sendOrder.getFullName());
        order.setPhone(sendOrder.getPhone());
        orderRepository.save(order);
        return "registration succsesfull";
    }
}
