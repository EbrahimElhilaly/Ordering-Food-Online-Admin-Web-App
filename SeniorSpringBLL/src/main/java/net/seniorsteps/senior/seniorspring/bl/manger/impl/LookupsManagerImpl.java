/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.seniorspring.bl.manger.impl;

import java.util.ArrayList;
import java.util.List;
import net.seniorsteps.senior.seniorspring.bl.managers.LookupsManager;
import net.seniorsteps.senior.seniorspring.bl.transformers.AreaTransformer;
import net.seniorsteps.senior.seniorspring.bl.transformers.CityTransformer;
import net.seniorsteps.senior.common.bean.AreaBean;
import net.seniorsteps.senior.common.bean.CityBean;
import net.seniorsteps.senior.common.constant.SeniorConstant;
import static net.seniorsteps.senior.common.constant.SeniorConstant.LANG_AR;
import static net.seniorsteps.senior.common.constant.SeniorConstant.LANG_EN;
import net.seniorsteps.senior.seniorspring.bl.managers.LookupsManager;

import net.seniorsteps.senior.spring.dal.entity.Area;
import net.seniorsteps.senior.spring.dal.entity.City;
import net.seniorsteps.senior.spring.dal.repo.AreaRepo;
import net.seniorsteps.senior.spring.dal.repo.CityRepoImpl;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Senior Steps
 */
@Service
public class LookupsManagerImpl implements LookupsManager, SeniorConstant {

    @Autowired
    private CityTransformer cityTransformer;
    @Autowired
    private CityRepoImpl cityRepo;
    @Autowired
    private AreaTransformer areaTransformer;
    @Autowired
    private AreaRepo areaRepo;

    @Override
    @Transactional
    public CityBean addCity(CityBean cityBean) {

        City cityEntity = cityTransformer.fromBeanToEntity(cityBean);

        cityEntity = cityRepo.add(cityEntity);
        CityBean resultCityBean = cityTransformer.fromEntityToBean(cityEntity, LANG_AR);

        return resultCityBean;
    }

    @Override
    @Transactional
    public List<CityBean> findCities() {

        List<City> citiesList = cityRepo.findList();
        List<CityBean> cityBeansList = new ArrayList<>();
        for (City iCity : citiesList) {
            CityBean iCityBean = cityTransformer.fromEntityToBean(iCity, LANG_AR);
            cityBeansList.add(iCityBean);
        }

        return cityBeansList;
    }

    @Override
    @Transactional
    public CityBean getCity(Integer id) {

        City foundCity = cityRepo.findById(id);
        CityBean cityBean = cityTransformer.fromEntityToBeanWithAreas(foundCity, LANG_EN);

        return cityBean;
    }

    @Override
    @Transactional
    public void deleteCity(Integer id) {
        City foundCity = cityRepo.findById(id);
        cityRepo.remove(id);
        CityBean cityBean = cityTransformer.fromEntityToBeanWithAreas(foundCity, LANG_EN);

    }

    @Override
    @Transactional
    public AreaBean addArea(AreaBean areaBean) {

        Area areaEntity = areaTransformer.fromBeanToEntity(areaBean);

        areaEntity = areaRepo.add(areaEntity);
        AreaBean resultAreaBean = areaTransformer.fromEntityToBean(areaEntity, LANG_AR);

        return resultAreaBean;

    }

    @Override
    @Transactional
    public List<AreaBean> findAreas() {

        List<Area> areasList = areaRepo.findList();
        List<AreaBean> areaBeansList = new ArrayList<>();
        for (Area iarea : areasList) {
            AreaBean iCityBean = areaTransformer.fromEntityToBean(iarea, LANG_AR);
            areaBeansList.add(iCityBean);
        }

        return areaBeansList;
    }

    @Override
    @Transactional
    public AreaBean getArea(Integer id) {

        Area foundArea = areaRepo.findById(id);
        AreaBean areaBean = areaTransformer.fromEntityToBean(foundArea, LANG_EN);

        return areaBean;

    }

    @Override
    @Transactional
    public void deleteArea(Integer id) {
        Session session = null;

        session.delete(getArea(id));

        session.getTransaction().commit();

    }

    public CityTransformer getCityTransformer() {
        return cityTransformer;
    }

    public void setCityTransformer(CityTransformer cityTransformer) {
        this.cityTransformer = cityTransformer;
    }

    public CityRepoImpl getCityRepo() {
        return cityRepo;
    }

    public void setCityRepo(CityRepoImpl cityRepo) {
        this.cityRepo = cityRepo;
    }

    public AreaTransformer getAreaTransformer() {
        return areaTransformer;
    }

    public void setAreaTransformer(AreaTransformer areaTransformer) {
        this.areaTransformer = areaTransformer;
    }

    public AreaRepo getAreaRepo() {
        return areaRepo;
    }

    public void setAreaRepo(AreaRepo areaRepo) {
        this.areaRepo = areaRepo;
    }

}
