/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.spring.dal.repo;

import net.seniorsteps.senior.spring.dal.entity.Area;
import net.seniorsteps.senior.spring.dal.entity.Branch;
import org.springframework.stereotype.Repository;

/**
 *
 * @author helali
 */
@Repository
public class BranchRepo extends AbstractEntityRepo<Branch> {
    
    public BranchRepo() {
        super(Branch.class);
    }
    
}
