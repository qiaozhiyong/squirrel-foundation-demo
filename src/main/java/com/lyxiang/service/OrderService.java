package com.lyxiang.service;

import com.lyxiang.common.OrderContext;
import com.lyxiang.common.OrderEvent;
import com.lyxiang.common.OrderState;
import com.lyxiang.pojo.OrderDTO;
import com.lyxiang.spring.OrderStateMachineEngineFactory;
import com.lyxiang.squirrelfoundation.MyEvent;
import com.lyxiang.squirrelfoundation.MyState;
import com.lyxiang.squirrelfoundation.declarative.DeclarativeStateMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;

/**
 * @author: liyuxiang
 * @create: 2019-01-29
 */
@Service
public class OrderService {

    @Autowired
    OrderStateMachineEngineFactory orderStateMachineEngineFactory;

    /*public int submitOrder() {
        OrderDTO orderDTO = new OrderDTO(OrderState.INIT.name());
        OrderContext orderContext = new OrderContext(orderDTO);
        orderStateMachineEngineFactory.fire(orderContext, OrderEvent.SUBMIT_ORDER);
       *//* OrderDTO orderDTO2 = new OrderDTO(OrderState.WAIT_PAY.name());
        OrderContext orderContext2 = new OrderContext(orderDTO2);
        orderStateMachineEngineFactory.fire(orderContext2, OrderEvent.PAY);*//*
        return 1;
        //return orderContext.orderDTO.getId();
    }*/

    public int submitOrder() {
        UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(DeclarativeStateMachine.class);

        // ConverterProvider.INSTANCE.register(MyEvent.class, new MyEventConverter());
        //ConverterProvider.INSTANCE.register(MyState.class, new MyStateConverter());

        UntypedStateMachine fsm = builder.newStateMachine(MyState.A);

        fsm.start();

        fsm.fire(MyEvent.ToB);

        fsm.fire(MyEvent.ToC);

        fsm.terminate();

        return 1;
    }

}
