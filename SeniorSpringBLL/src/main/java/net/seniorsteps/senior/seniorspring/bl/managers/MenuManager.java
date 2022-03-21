/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.seniorspring.bl.managers;

import java.util.List;
import net.seniorsteps.senior.common.bean.ProductBean;

/**
 *
 * @author Senior Steps
 */
public interface MenuManager {

    public ProductBean addProduct(ProductBean product);

    public Integer findProduct(Integer id);

    public void deleteProduct(Integer id);
}
