/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.seniorspring.bl.transformers;

import net.seniorsteps.senior.common.bean.ConsumerBean;
import net.seniorsteps.senior.common.constant.SeniorConstant;
import net.seniorsteps.senior.spring.dal.entity.Consumer;

/**
 *
 * @author helali
 */
public class ConsumerTransformer implements SeniorConstant, CommonTransformer<Consumer, ConsumerBean> {

    @Override
    public ConsumerBean fromEntityToBean(Consumer entity, String lang) {
        ConsumerBean consumerBean = new ConsumerBean();
        consumerBean.setId(entity.getId());
        consumerBean.setPhone(entity.getPhone());
        consumerBean.setEmail(entity.getEmail());
        consumerBean.setPassword(entity.getPassword());
        consumerBean.setGender(entity.getGender());

        return consumerBean;
    }
        @Override
        public Consumer fromBeanToEntity(ConsumerBean consumerBean){
        
        Consumer consumer = new Consumer();
        consumer.setId(consumerBean.getId());
        consumer.setPhone(consumerBean.getPhone());
        consumer.setEmail(consumerBean.getEmail());
        consumer.setPassword(consumerBean.getPassword());
        consumer.setGender(consumerBean.getGender());
        return consumer;
        }
    

}
