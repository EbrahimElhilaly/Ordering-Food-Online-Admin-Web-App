/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.seniorspring.bl.manger.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static jdk.nashorn.internal.runtime.Debug.id;
import net.seniorsteps.senior.common.bean.AreaBean;
import net.seniorsteps.senior.seniorspring.bl.managers.MenuManager;
import net.seniorsteps.senior.common.bean.ProductBean;
import net.seniorsteps.senior.common.constant.SeniorConstant;
import static net.seniorsteps.senior.common.constant.SeniorConstant.LANG_EN;
import net.seniorsteps.senior.seniorspring.bl.transformers.ProductTransformers;
import net.seniorsteps.senior.spring.dal.entity.Area;

import net.seniorsteps.senior.spring.dal.entity.OrderItem;
import net.seniorsteps.senior.spring.dal.entity.Product;
import net.seniorsteps.senior.spring.dal.repo.ProductRepo;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Senior Steps
 */
@Service
@Transactional
public class MenuManagerImpl implements MenuManager , SeniorConstant {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    ProductTransformers productTransformers;

    @Override
    public ProductBean addProduct(ProductBean product) {

        Set<OrderItem> orderItems = new HashSet<OrderItem>(0);

        for (OrderItem item : orderItems) {

        }

        return product;

    }

    public Integer findProduct(Integer id) {

        Product founfProduct = productRepo.findById(id);
        ProductBean areaBean = productTransformers.fromEntityToBean(founfProduct, LANG_EN);

        return id;

    }

    public void deleteProduct(Integer productId) {

        if (findProduct(productId) != null) {
            Integer product = findProduct(productId);

            Set<OrderItem> orderItems = new HashSet<OrderItem>(0);

            for (OrderItem software : orderItems) {

            }

        } else {
            System.out.println("This id is not found");
        }

    }

    public List<Product> getAllProducts() {

        List<Product> productList = productRepo.findList();

        List<ProductBean> BeansList = new ArrayList<>();
        for (Product iproduct : productList) {
            ProductBean iBean = productTransformers.fromEntityToBean(iproduct, LANG_EN);
            BeansList.add(iBean);
        }

        return productList;
    }

   

   

}


