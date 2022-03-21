/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.spring.dal.test;

import net.seniorsteps.senior.spring.dal.entity.City;
import net.seniorsteps.senior.spring.dal.repo.CityRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author helali
 */
@Component
public class TestDAL {
    
    public void testAdd(ApplicationContext appCon){
      try {
            CityRepo cityRepo = appCon.getBean("cityRepoImpl", CityRepo.class);
            System.out.println("Interface correct");
            City city = new City("Spring 1 Ar", "Spring 1En");
            City returnedCity = cityRepo.add(city);
            System.out.println("ADDED | " + returnedCity.getId());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("END");

    
    
    }
    
}
