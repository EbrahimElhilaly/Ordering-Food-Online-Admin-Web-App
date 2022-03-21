/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.seniorspring.bl.managers;

import java.util.List;
import net.seniorsteps.senior.common.bean.AreaBean;
import net.seniorsteps.senior.common.bean.CityBean;


/**
 *
 * @author Senior Steps
 */
public interface LookupsManager {
        //City
	public CityBean addCity(CityBean cityBean);

	public List<CityBean> findCities();
	
	public CityBean getCity(Integer id);
        
        public void deleteCity(Integer id);
        
        //Area
        
        public AreaBean addArea(AreaBean areaBean);

	public List<AreaBean> findAreas();
	
	public AreaBean getArea(Integer id);
        
        public void deleteArea(Integer id);
        
       //product
        
        
//	public AreaBean addArea(AreaBean areaBean);
}
