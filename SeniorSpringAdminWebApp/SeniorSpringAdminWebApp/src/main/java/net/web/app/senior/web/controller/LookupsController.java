package net.web.app.senior.web.controller;

import java.util.List;
import net.seniorsteps.senior.common.bean.AreaBean;
import net.seniorsteps.senior.common.bean.CityBean;
import net.seniorsteps.senior.seniorspring.bl.SeniorBLGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/Lookups/")
public class LookupsController {

    @Autowired
    private SeniorBLGateway service;

    @RequestMapping(value = "findCityList", method = RequestMethod.GET)
    public ModelAndView findCityList() {
        List<CityBean> cityList = service.findCities();
        ModelAndView model = new ModelAndView();
        model.setViewName("City");
        model.addObject("cityList", cityList);
        return model;
    }

    @RequestMapping(value = "addNewCity", method = RequestMethod.POST)
    public ModelAndView addNewCity(CityBean city) {
        service.addCity(city);
        List<CityBean> cityList = service.findCities();
        ModelAndView model = new ModelAndView();
        model.setViewName("City");
        model.addObject("cityList", cityList);
        return model;
    }

    @RequestMapping(value = "toUpdateCity", method = RequestMethod.GET)
    public ModelAndView updateCityPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("UpdateCity");
        return model;
    }

    @RequestMapping(value = "removeCity", method = RequestMethod.GET)
    public ModelAndView removeCity(@RequestParam Integer id) {
        service.deleteCity(id);
        List<CityBean> cityList = service.findCities();
        ModelAndView model = new ModelAndView();
        model.setViewName("City");
        model.addObject("cityList", cityList);
        return model;
    }

    @RequestMapping(value = "findCityArea", method = RequestMethod.GET)
    public ModelAndView ViewCity(@RequestParam Integer id) {
        System.out.println(id);
        CityBean city = service.getCity(id);
        System.out.println(city.getNameAr());
        for (AreaBean object : city.getAreasList()) {
            System.out.println(object.getNameAr());
        }
        ModelAndView model = new ModelAndView();
        List<AreaBean> areaSet = city.getAreasList();
        model.setViewName("ViewCity");
        model.addObject("areaSet", service.findAreas());
        return model;
    }

    // <editor-fold defaultstate="collapsed" desc="geters and setters">
    public void setGateWay(SeniorBLGateway service) {
        this.service = service;
    }
    // </editor-fold>
}
