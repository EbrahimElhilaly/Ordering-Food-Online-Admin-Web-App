/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.common.bean;

import java.util.List;

/**
 *
 * @author helali
 */
public class CityBean {
    private Integer id;
    private String nameAr;
    private String nameEn;
    private String name;
    private List <AreaBean> areasList;


    public List<AreaBean> getAreasList() {
        return areasList;
    }

    public void setAreasList(List<AreaBean> areasList) {
        this.areasList = areasList;
    }

    public CityBean(Integer id, String nameAr, String nameEn, String name) {
        this.id = id;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.name = name;
    }
    public CityBean(String nameAr, String nameEn) {
       
        this.nameAr = nameAr;
        this.nameEn = nameEn;

    }

    public CityBean() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
