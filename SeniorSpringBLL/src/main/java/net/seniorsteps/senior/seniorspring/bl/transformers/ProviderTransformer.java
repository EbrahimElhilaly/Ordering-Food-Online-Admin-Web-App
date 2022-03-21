/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.seniorspring.bl.transformers;

import net.seniorsteps.senior.common.bean.ProviderBean;
import net.seniorsteps.senior.common.constant.SeniorConstant;
import net.seniorsteps.senior.spring.dal.entity.Provider;

/**
 *
 * @author helali
 */
public class ProviderTransformer implements SeniorConstant, CommonTransformer<Provider, ProviderBean> {

    @Override
    public ProviderBean fromEntityToBean(Provider entity, String lang) {
        ProviderBean providerBean = new ProviderBean();
        providerBean.setId(entity.getId());
        providerBean.setHotline(entity.getHotline());
        providerBean.setNameAr(entity.getNameAr());
        providerBean.setNameEn(entity.getNameEn());

        return providerBean;
    }

    @Override
    public Provider fromBeanToEntity(ProviderBean providerBean) {

        Provider provider = new Provider();
        provider.setId(providerBean.getId());
        provider.setNameAr(providerBean.getNameAr());
        provider.setNameEn(providerBean.getNameEn());
        provider.setHotline(providerBean.getHotline());
        return provider;

    }

   

}
