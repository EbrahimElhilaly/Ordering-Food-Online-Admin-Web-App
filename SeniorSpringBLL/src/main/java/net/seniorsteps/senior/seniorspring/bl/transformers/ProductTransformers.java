/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.seniorspring.bl.transformers;

import net.seniorsteps.senior.common.bean.ProductBean;
import net.seniorsteps.senior.common.constant.SeniorConstant;
import net.seniorsteps.senior.spring.dal.entity.Product;

/**
 *
 * @author helali
 */
public class ProductTransformers implements SeniorConstant, CommonTransformer<Product, ProductBean> {

    @Override
    public ProductBean fromEntityToBean(Product entity, String lang) {
         ProductBean productBean = new ProductBean();
        productBean.setId(entity.getId());
        productBean.setNameAr(entity.getNameAr());
        productBean.setNameEn(entity.getNameEn()); 
    
        return productBean ;
    }

    @Override
    public Product fromBeanToEntity(ProductBean productBean) {

       Product product = new Product();
        product.setId(productBean.getId());
        product.setNameAr(productBean.getNameAr());
        product.setNameEn(productBean.getNameEn());
        return product;

    }
    
}
