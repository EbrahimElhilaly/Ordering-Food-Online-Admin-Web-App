/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.spring.dal.repo;

import java.util.List;
import net.seniorsteps.senior.spring.dal.entity.City;
import org.springframework.stereotype.Repository;

/**
 *
 * @author helali
 */
public interface CityRepo extends CommonRepo<City> {

    public City updateHQL(City city);

    public List<City> findLike(String keyword);

    public List<City> findListByHQL();

    public List<City> findLikeByHQL(String keyword);

    public Long countLike(String keyword);
}
