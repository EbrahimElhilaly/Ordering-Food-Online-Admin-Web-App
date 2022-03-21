/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.bll.manager;

import java.util.List;
import net.seniorsteps.senior.common.bean.CityBean;

/**
 *
 * @author helali
 */
public interface LookupsManager {
    
    public CityBean addCity(CityBean cityBean);
    
    public List<CityBean>findCities();
    
    public CityBean getCity(Integer id);
    
    public CityBean updateCity(CityBean cityBean);

    
}
