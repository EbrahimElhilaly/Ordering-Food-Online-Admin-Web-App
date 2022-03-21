/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.seniorspring.bl.managers;

import net.seniorsteps.senior.common.bean.OrderBean;

/**
 *
 * @author helali
 */
public interface OrderManager {

    public OrderBean addOrder(OrderBean orderBean);

    public OrderBean updateOrder(Integer id);

    public OrderBean getorder(Integer id);

    public void deleteOrder(Integer id);

}
