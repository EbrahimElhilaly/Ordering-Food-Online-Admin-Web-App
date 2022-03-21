/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.dal.repo;

import net.seniorsteps.senior.dal.entity.Category;

/**
 *
 * @author helali
 */
public class CategoryRepo extends AbstractEntityRepo<Category>{
    
    public CategoryRepo() {
        super(Category.class);
    }
    
}
