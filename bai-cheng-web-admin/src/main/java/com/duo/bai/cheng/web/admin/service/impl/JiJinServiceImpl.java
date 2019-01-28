package com.duo.bai.cheng.web.admin.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.JiJin;
import com.duo.bai.cheng.web.admin.dao.JiJinDao;
import com.duo.bai.cheng.web.admin.service.JiJinService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JiJinServiceImpl implements JiJinService {
    @Autowired
    JiJinDao jiJinDao;
    @Override
    public JiJin selectById(String id) {
        return jiJinDao.findOne(Integer.parseInt(id));
    }

    @Override
    public List<JiJin> selectAllJiJin() {
        return jiJinDao.findAll();
    }

    @Override
    public int count() {
        return jiJinDao.count();
    }

    @Override
    public BaseResult deleteById(String id) {
        BaseResult baseResult;
        //判断ids是否为空
        if (!StringUtils.isBlank(id)) {

            jiJinDao.deleteById(Integer.parseInt(id));
            baseResult = BaseResult.success("删除成功");
        } else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }

    @Override
    public List<JiJin> selectBySearch(String keyword) {
        return null;
    }

    @Override
    public int countBySearch(String keyword) {
        return 0;
    }

    @Override
    public BaseResult deleteJiJins(String ids) {
        BaseResult baseResult;
        //判空
        if(!StringUtils.isBlank(ids)){
            String[] id_arr = ids.split(",");
            jiJinDao.deleteJiJins(id_arr);
            baseResult= BaseResult.success("删除成功");

        }else {
            baseResult= BaseResult.fail("删除失败");
        }
        return baseResult;
    }

    @Override
    public void save(JiJin jiJin) {
        if(jiJin.getId()==null){
            jiJinDao.insertJiJin(jiJin);
        }else{
            jiJinDao.updateJiJin(jiJin);
        }
    }
}
