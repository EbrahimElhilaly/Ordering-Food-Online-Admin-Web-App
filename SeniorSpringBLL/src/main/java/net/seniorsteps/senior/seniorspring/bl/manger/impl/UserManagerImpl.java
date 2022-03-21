/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.seniorspring.bl.manger.impl;

import net.seniorsteps.senior.common.bean.ConsumerBean;
import net.seniorsteps.senior.common.bean.ProviderBean;
import net.seniorsteps.senior.common.constant.SeniorConstant;
import net.seniorsteps.senior.seniorspring.bl.managers.UserManager;
import net.seniorsteps.senior.seniorspring.bl.transformers.ConsumerTransformer;
import net.seniorsteps.senior.seniorspring.bl.transformers.ProviderTransformer;
import net.seniorsteps.senior.spring.dal.entity.Consumer;
import net.seniorsteps.senior.spring.dal.entity.Provider;
import net.seniorsteps.senior.spring.dal.repo.ConsumerRepo;
import net.seniorsteps.senior.spring.dal.repo.ProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author helali
 */
public class UserManagerImpl implements UserManager, SeniorConstant {

    @Autowired
    ProviderTransformer providerTransformer;
    @Autowired
    ConsumerTransformer consumerTransformer;
    @Autowired
    private ProviderRepo providerRepo;
    @Autowired
    private ConsumerRepo consumerRepo;

    @Override
    public ProviderBean addProvider(ProviderBean providerBean) {

        Provider providerEntity = providerTransformer.fromBeanToEntity(providerBean);
        providerEntity = providerRepo.add(providerEntity);

        providerEntity = providerRepo.add(providerEntity);
        ProviderBean resultProviderBean = providerTransformer.fromEntityToBean(providerEntity, LANG_AR);

        return resultProviderBean;

    }

    @Override
    public ProviderBean getProvider(Integer id) {
        Provider foundOne = providerRepo.findById(id);
        ProviderBean providerBean = providerTransformer.fromEntityToBean(foundOne, LANG_EN);

        return providerBean;

    }

    @Override
    public void deleteProvider(Integer id) {
        Provider foundProvider = providerRepo.findById(id);
        providerRepo.remove(id);
        ProviderBean providerBean = providerTransformer.fromEntityToBean(foundProvider, LANG_EN);

    }
    ///Consumer

    @Override
    public ConsumerBean addConsumer(ConsumerBean consumerBean) {

        Consumer consumerEntity = consumerTransformer.fromBeanToEntity(consumerBean);
        consumerEntity = consumerRepo.add(consumerEntity);

        consumerEntity = consumerRepo.add(consumerEntity);
        ConsumerBean resultBean = consumerTransformer.fromEntityToBean(consumerEntity, LANG_AR);

        return resultBean;

    }

    @Override
    public ConsumerBean getConsumer(Integer id) {

        Consumer foundOne = consumerRepo.findById(id);
        ConsumerBean consumerBean = consumerTransformer.fromEntityToBean(foundOne, LANG_EN);

        return consumerBean;

    }

    @Override
    public void deleteConsumer(Integer id) {

        Consumer foundConsumer = consumerRepo.findById(id);
        providerRepo.remove(id);
        ConsumerBean consumerBean = consumerTransformer.fromEntityToBean(foundConsumer, LANG_EN);

    }

}
