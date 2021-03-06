/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.bll.manager.impl;

import java.util.ArrayList;
import java.util.List;
import net.seniorsteps.bll.manager.LookupsManager;
import net.seniorsteps.bll.transformer.CityTransformer;
import net.seniorsteps.senior.common.bean.CityBean;
import net.seniorsteps.senior.common.constant.SeniorConstant;
import static net.seniorsteps.senior.dal.DBConnectionManager.*;
import net.seniorsteps.senior.dal.entity.City;
import net.seniorsteps.senior.dal.repo.CityRepo;

/**
 *
 * @author helali
 */
public class LookupsManagerImpl implements LookupsManager, SeniorConstant {

    private CityTransformer cityTransformer = new CityTransformer();
    private CityRepo cityRepo = new CityRepo();

    @Override
    public CityBean addCity(CityBean cityBean) {
        openSession();

        City cityEntity = cityTransformer.fromBeanToEntity(cityBean);

        beginTransaction();
        cityEntity = cityRepo.add(cityEntity);

        commitTransaction();
        CityBean resultCityBean = cityTransformer.fromEntityToBean(cityEntity, LANG_AR);

        return resultCityBean;
    }

    @Override
    public List<CityBean> findCities() {
        openSession();
        beginTransaction();
        List<City> citiesList = cityRepo.findList();
        List<CityBean> cityBeanList = new ArrayList<>();

        for (City iCity : citiesList) {

            CityBean iCityBean = cityTransformer.fromEntityToBean(iCity, LANG_AR);
            cityBeanList.add(iCityBean);
        }

        commitTransaction();
        closeSession();
        return cityBeanList;

    }

    @Override
    public CityBean getCity(Integer id) {
        openSession();
        beginTransaction();
        City foundCity = cityRepo.findById(id);
        CityBean cityBean = cityTransformer.fromEntityToBeanWithAreas(foundCity, LANG_AR);

        commitTransaction();

        return cityBean;
    }

   

    @Override
    public CityBean updateCity(CityBean cityBean) {
        openSession();
       

        City cityEntity = cityTransformer.fromBeanToEntity(cityBean);

         beginTransaction();
       
        cityEntity = cityRepo.update(cityEntity);
   
        CityBean updatedCityBean = cityTransformer.fromEntityToBean(cityEntity, LANG_AR);

           commitTransaction();
        return updatedCityBean;
        
    }
    
    

}
