/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.dal;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import static net.seniorsteps.senior.dal.DBConnectionManager.closeSession;
import static net.seniorsteps.senior.dal.DBConnectionManager.openSession;
import static net.seniorsteps.senior.dal.DBConnectionManager.*;
import net.seniorsteps.senior.dal.entity.City;
import org.hibernate.Session;
import org.hibernate.query.Query;
import static net.seniorsteps.senior.dal.DBConnectionManager.*;
import net.seniorsteps.senior.dal.repo.CityRepo;
import net.seniorsteps.senior.dal.entity.Area;

/**
 *
 * @author helali
 */
public class SeniorDALMain {

    /**
     * @param args the command line arguments
     */
    private static int getFirstResultRelativeToPageNumber(int pageNumber, int pageSize) {

        return (pageNumber - 1 * pageSize);

    }

    public static void main(String[] args) {
        Session session = openSession();
        beginTransaction();
        System.out.println("Start");

        CityRepo cityDao = new CityRepo();
//        cityDao.add(new City("test 01", "test A"));
//        cityDao.add(new City("test B", "test 02"));
//        cityDao.add(new City("test 03", "test 03"));



        City city = new City("HQL City Ar", "HQL City En");
        city.setId(45);
//        City returnedCity = cityDao.updateHQL(city);

        
        
        commitTransaction();

//        List<City> cityResultList = cityDao.findList();
//        List<City> cityResultList = cityDao.findLike("0");
//        List<City> cityResultList = cityDao.findListByHQL();
//        System.err.println("AFTER LIST");
//
//        for (City icity : cityResultList) {
//
//            System.err.println(icity.getNameAr() + "|" + icity.getNameEn());
//            
//            System.out.println("--AREAS--");
//            for (Area iArea : icity.getAreas()) {
//
//                System.out.println("  --- |" + iArea.getNameAr());
//            }
//            System.out.println("------");
//
//        }
//        Long count = cityDao.countLike("ca");
//        System.err.println("COUNT OF CITIES:" + count);
//         City citySingleResult = cityQuery.getSingleResult();
        getCurrentSession();

        closeSession();
    }

}
