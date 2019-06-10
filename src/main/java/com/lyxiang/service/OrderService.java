package com.lyxiang.service;

import com.lyxiang.common.OrderContext;
import com.lyxiang.common.OrderEvent;
import com.lyxiang.common.OrderState;
import com.lyxiang.pojo.OrderDTO;
import com.lyxiang.spring.OrderStateMachineEngineFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: liyuxiang
 * @create: 2019-01-29
 */
@Service
public class OrderService {

    @Autowired
    OrderStateMachineEngineFactory orderStateMachineEngineFactory;

    public int submitOrder() {
        OrderDTO orderDTO = new OrderDTO(OrderState.INIT.name());
        OrderContext orderContext = new OrderContext(orderDTO);
        orderStateMachineEngineFactory.fire(orderContext, OrderEvent.SUBMIT_ORDER);
       /* OrderDTO orderDTO2 = new OrderDTO(OrderState.WAIT_PAY.name());
        OrderContext orderContext2 = new OrderContext(orderDTO2);
        orderStateMachineEngineFactory.fire(orderContext2, OrderEvent.PAY);*/
        return 1;
        //return orderContext.orderDTO.getId();
    }

}
