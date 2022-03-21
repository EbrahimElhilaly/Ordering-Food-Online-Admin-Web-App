/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.seniorspring.bl;

import java.util.List;
import net.seniorsteps.senior.common.bean.AreaBean;
import net.seniorsteps.senior.common.bean.CityBean;
import net.seniorsteps.senior.common.bean.ProductBean;
import net.seniorsteps.senior.seniorspring.bl.managers.LookupsManager;
import net.seniorsteps.senior.seniorspring.bl.managers.MenuManager;
import net.seniorsteps.senior.seniorspring.bl.manger.impl.LookupsManagerImpl;
import net.seniorsteps.senior.seniorspring.bl.manger.impl.MenuManagerImpl;

/**
 *
 * @author Senior Steps
 */
public class SeniorBLGateway {

	private MenuManager menuManager = new MenuManagerImpl();
	private LookupsManager lookupsManager = new LookupsManagerImpl();

	public List<CityBean> findCities() {
		return lookupsManager.findCities();
	}

	public CityBean addCity(CityBean cityBean) {
		return lookupsManager.addCity(cityBean);
	}

	public ProductBean addProduct(ProductBean product) {
		return menuManager.addProduct(product);
	}

	public CityBean getCity(Integer id) {
		return lookupsManager.getCity(id);
	}
        public void deleteCity(Integer id) {
         
		
	}
        
        
        public List<AreaBean> findAreas() {
		return lookupsManager.findAreas();
	}

	public AreaBean addArea(AreaBean areaBean) {
		return lookupsManager.addArea(areaBean);
	}


	public AreaBean getArea(Integer id) {
		return lookupsManager.getArea(id);
	}
        public void deleteArea(Integer id) {
         
		
	}

}
