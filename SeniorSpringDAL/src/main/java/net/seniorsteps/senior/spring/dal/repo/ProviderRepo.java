/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.spring.dal.repo;

import net.seniorsteps.senior.spring.dal.entity.Provider;
import org.springframework.stereotype.Repository;

/**
 *
 * @author helali
 */
@Repository
public class ProviderRepo extends AbstractEntityRepo<Provider>{
    
    public ProviderRepo() {
        super(Provider.class);
    }
    
}
