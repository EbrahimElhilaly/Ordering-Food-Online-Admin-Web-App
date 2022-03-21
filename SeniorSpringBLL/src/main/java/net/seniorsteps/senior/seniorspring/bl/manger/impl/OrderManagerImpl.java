/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.seniorspring.bl.manger.impl;

import net.seniorsteps.senior.common.bean.OrderBean;
import net.seniorsteps.senior.common.constant.SeniorConstant;
import net.seniorsteps.senior.seniorspring.bl.managers.OrderManager;
import net.seniorsteps.senior.seniorspring.bl.transformers.OrderTransformer;
import net.seniorsteps.senior.spring.dal.entity.Order;
import net.seniorsteps.senior.spring.dal.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author helali
 */
public class OrderManagerImpl implements OrderManager, SeniorConstant{

    
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    OrderTransformer orderTransformer;
    @Override
    public OrderBean addOrder(OrderBean orderBean) {
       
        Order orderEntity = orderTransformer.fromBeanToEntity(orderBean);

        orderEntity = orderRepo.add(orderEntity);
        OrderBean resultBean = orderTransformer.fromEntityToBean(orderEntity, LANG_AR);

        return resultBean;
    }

    @Override
    public OrderBean updateOrder(Integer id) {
        Order foundOrder = orderRepo.findById(id);
        orderRepo.update(foundOrder);
        OrderBean orderBean = orderTransformer.fromEntityToBean(foundOrder, LANG_EN);

        return orderBean;

    }

    @Override
    public OrderBean getorder(Integer id) {
     
         Order foundOrder = orderRepo.findById(id);
        OrderBean orderBean = orderTransformer.fromEntityToBean(foundOrder, LANG_EN);

        return orderBean;

    }

    @Override
    public void deleteOrder(Integer id) {
     
        Order foundOrder = orderRepo.findById(id);
        orderRepo.remove(id);
        OrderBean orderBean = orderTransformer.fromEntityToBean(foundOrder, LANG_EN);

    }
    
}
