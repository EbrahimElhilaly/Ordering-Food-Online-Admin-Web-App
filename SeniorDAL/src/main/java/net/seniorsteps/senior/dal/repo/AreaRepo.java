/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.dal.repo;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import static net.seniorsteps.senior.dal.DBConnectionManager.getCurrentSession;
import net.seniorsteps.senior.dal.entity.Area;
import net.seniorsteps.senior.dal.entity.City;
import org.hibernate.query.Query;

/**
 *
 * @author helali
 */
public class AreaRepo extends AbstractEntityRepo<Area>{

    public AreaRepo() {
        super(Area.class);
    }


    
    
}
