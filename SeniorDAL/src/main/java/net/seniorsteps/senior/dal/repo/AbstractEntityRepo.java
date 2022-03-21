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
import org.hibernate.query.Query;

/**
 *
 * @author helali
 */
public abstract class AbstractEntityRepo <E> implements commonRepo<E>{
    
      private  Class<E> entityType; //City.class
      private String defaultOrder;

    public AbstractEntityRepo(Class <E> entityType) {
        this.entityType = entityType;
    }
    
    
    

    @Override
    public E add(E entity) {
      getCurrentSession().persist(entity);

        return entity;    }

    @Override
    public E update(E entity) {
        
    return (E)getCurrentSession().merge(entity);    }

    @Override
    public void remove(Integer id) {
    E foundEntity = getCurrentSession().load(entityType, id);
        getCurrentSession().delete(foundEntity);    }

    @Override
    public E findById(Integer id) {
  return getCurrentSession().get(entityType,id);    }

    @Override
    public List<E> findList() {
   
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<E> entityCriteriaQuery = criteriaBuilder.createQuery(entityType);
        Root<E> from = (entityCriteriaQuery.from(entityType));
        entityCriteriaQuery.select(from);
       
        if(null != defaultOrder){
        
         entityCriteriaQuery.orderBy(criteriaBuilder.asc(from.get(defaultOrder)));
        }

        Query<E> entityQuery = getCurrentSession().createQuery(entityCriteriaQuery);

        List<E> entityResultList = entityQuery.getResultList();

        return entityResultList;    }
    
    public void setDefaultOrder(String defaultOrder){
    
    this.defaultOrder =defaultOrder;
    
    }
}
