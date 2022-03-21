/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.seniorspring.bl.transformers;

import net.seniorsteps.senior.common.bean.OrderBean;
import net.seniorsteps.senior.common.constant.SeniorConstant;
import net.seniorsteps.senior.spring.dal.entity.Order;

/**
 *
 * @author helali
 */
public class OrderTransformer implements SeniorConstant, CommonTransformer<Order, OrderBean> {

    @Override
    public OrderBean fromEntityToBean(Order entity, String lang) {
        OrderBean orderBean = new OrderBean();
        orderBean.setId(entity.getId());
        orderBean.setConsumerId(entity.getConsumerId());
        orderBean.setBranchId(entity.getBranchId());
        orderBean.setDeliveryFees(String.valueOf(entity.getDeliveryFees()));
        orderBean.setStatus(entity.getStatus());

        return orderBean;
    }

    @Override
    public Order fromBeanToEntity(OrderBean orderBean) {

        Order order = new Order();
        order.setId(orderBean.getId());
        order.setConsumerId(orderBean.getConsumerId());
        order.setBranchId(orderBean.getBranchId());
        order.setDeliveryFees(String.valueOf(orderBean.getDeliveryFees()));
        order.setStatus(orderBean.getStatus());
        
        return order;

    }

}
