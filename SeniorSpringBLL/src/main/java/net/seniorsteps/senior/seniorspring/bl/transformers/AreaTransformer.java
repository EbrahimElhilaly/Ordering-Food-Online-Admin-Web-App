/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.seniorspring.bl.transformers;

import java.util.ArrayList;
import net.seniorsteps.senior.common.bean.AreaBean;
import net.seniorsteps.senior.common.bean.BranchBean;
import net.seniorsteps.senior.common.constant.SeniorConstant;
import net.seniorsteps.senior.spring.dal.entity.Area;
import net.seniorsteps.senior.spring.dal.entity.Branch;
import net.seniorsteps.senior.spring.dal.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Senior Steps
 */
@Component
public class AreaTransformer implements SeniorConstant, CommonTransformer<Area, AreaBean> {

    @Autowired
    private BranchTransformer branchTransformer;

    @Override
    public AreaBean fromEntityToBean(Area entity, String lang) {
        AreaBean areaBean = new AreaBean();
        areaBean.setId(entity.getId());
        areaBean.setNameAr(entity.getNameAr());
        areaBean.setNameEn(entity.getNameEn());
//		if (LANG_AR.equals(lang)) {
//			areaBean.setName(entity.getNameAr());
//		} else {
//			areaBean.setName(entity.getNameEn());
//		}
        return areaBean;
    }

    @Override
    public Area fromBeanToEntity(AreaBean areaBean) {
        Area area = new Area();
        area.setId(areaBean.getId());
        area.setNameAr(areaBean.getNameAr());
        area.setNameEn(areaBean.getNameEn());
        return area;
    }

    public AreaBean fromEntityToBeanWithBranches(Area areaEntity, String lang) {
        AreaBean areaBean = fromEntityToBean(areaEntity, lang);
        areaBean.setBranchsList(new ArrayList<>());
        for (Branch branchEntity : areaEntity.getBranches()) {
            BranchBean branchBean = branchTransformer.fromEntityToBean(branchEntity, lang);
            areaBean.getBranchsList().add(branchBean);
        }
        return areaBean;
    }

}
