package com.duo.bai.cheng.web.admin.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Information;
import com.duo.bai.cheng.web.admin.dao.InformationDao;
import com.duo.bai.cheng.web.admin.service.InformationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    InformationDao informationDao;

    @Override
    public Information selectById(String id) {
        Information information = informationDao.selectById(id);
        return information;
    }

    @Override
    public List<Information> selectAllInformation() {
        List<Information> informationList = informationDao.selectAllInformation();
        return informationList;
    }

    @Override
    public BaseResult save(Information information) {
        //验证表单是否通过
        BaseResult baseResult = checkInformation(information);
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            //表单验证通过
            if (information.getId()==null) {
                //新增用户
                information.setInfoCreated(new Date());
                informationDao.insert(information);
            } else {
                //编辑用户
                informationDao.updateInformation(information);
            }
            baseResult.setMessage("用户保存成功");
        }
        //不通过 直接返回
        return baseResult;
    }

    @Override
    public BaseResult deleteById(String id) {
        BaseResult baseResult;
        //判断ids是否为空
        if (!StringUtils.isBlank(id)) {
            System.out.println("要删除的id：" + id);
            informationDao.deleteById(id);
            baseResult = BaseResult.success("删除成功");
        } else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }

    @Override
    public List<Information> selectBySearch(String keyword) {
        List<Information> informationList=informationDao.selectBySearch(keyword);
        return informationList;
    }

    @Override
    public int count() {
        return informationDao.count();
    }

    @Override
    public BaseResult deleteInfos(String ids) {
        BaseResult baseResult;
        //判空
        if(!StringUtils.isBlank(ids)){
            String[] id_arr = ids.split(",");
            informationDao.deleteInfos(id_arr);
            baseResult= BaseResult.success("删除成功");

        }else {
            baseResult= BaseResult.fail("删除失败");
        }
        return baseResult;
    }


    @Override
    public int countBySearch(String keyword) {
        int count=informationDao.countBySearch(keyword);
        return count;
    }

//    @Override
//    public List<Object> selectAllInfoType() {
//        return informationDao.selectAllInfoType();
//
//    }


    public BaseResult checkInformation(Information information) {
        BaseResult baseResult = BaseResult.success();
        if (StringUtils.isBlank(information.getInfoName())) {
            baseResult = BaseResult.fail("资讯名称不能为空，请重新填写");
            return baseResult;
        }
        if (StringUtils.isBlank(information.getInfoContent())) {
            baseResult = BaseResult.fail("资讯内容不能为空，请重新填写");
            return baseResult;
        }
        if (StringUtils.isBlank(information.getInfoUrl())) {
            baseResult = BaseResult.fail("资讯链接不能为空，请重新填写");
            return baseResult;
        }
        return baseResult;
    }


}
