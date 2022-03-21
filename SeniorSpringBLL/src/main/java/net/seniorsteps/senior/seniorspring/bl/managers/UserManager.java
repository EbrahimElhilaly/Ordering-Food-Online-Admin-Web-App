/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.seniorspring.bl.managers;

import java.util.List;
import net.seniorsteps.senior.common.bean.ConsumerBean;
import net.seniorsteps.senior.common.bean.ProviderBean;

/**
 *
 * @author helali
 */
public interface UserManager {

    public ProviderBean addProvider(ProviderBean providerBean);

    public ProviderBean getProvider(Integer id);

    public void deleteProvider(Integer id);
    
    
    
    public ConsumerBean addConsumer(ConsumerBean consumerBean);

    public ConsumerBean getConsumer(Integer id);

    public void deleteConsumer(Integer id);

}
