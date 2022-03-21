/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.seniorspring.bl.transformers;

import net.seniorsteps.senior.common.bean.BranchBean;
import net.seniorsteps.senior.common.constant.SeniorConstant;
import net.seniorsteps.senior.spring.dal.entity.Branch;

/**
 *
 * @author helali
 */
public class BranchTransformer implements SeniorConstant, CommonTransformer<Branch, BranchBean> {
    
     @Override
    public BranchBean fromEntityToBean(Branch entity, String lang) {
        BranchBean branchBean = new BranchBean();
        branchBean.setId(entity.getId());
        branchBean.setNameAr(entity.getNameAr());
        branchBean.setNameEn(entity.getNameEn());
//		if (LANG_AR.equals(lang)) {
//			areaBean.setName(entity.getNameAr());
//		} else {
//			areaBean.setName(entity.getNameEn());
//		}
        return branchBean;
    }

    @Override
    public Branch fromBeanToEntity(BranchBean branchBean) {
        Branch branch = new Branch();
        branch.setId(branchBean.getId());
        branch.setNameAr(branchBean.getNameAr());
        branch.setNameEn(branchBean.getNameEn());
        return branch;
    }

    
    
}
