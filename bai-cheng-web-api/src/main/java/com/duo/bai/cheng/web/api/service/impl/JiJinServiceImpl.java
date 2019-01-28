package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.commons.dto.SearchInfo;
import com.duo.bai.cheng.domain.JiJin;
import com.duo.bai.cheng.web.api.dao.JiJinDao;
import com.duo.bai.cheng.web.api.service.JiJinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JiJinServiceImpl implements JiJinService {
    @Autowired
    JiJinDao jiJinDao;

    /**
     * 根据id获取基金对象
     * @param id
     * @return
     */
    @Override
    public JiJin getJiJinById(Integer id) {
        JiJin jijin = jiJinDao.getJiJinById(id);
        return jijin;
    }

    /**
     * 搜索所有基金
     * @return
     */
    @Override
    public List<JiJin> screen() {
        List<JiJin> jiJins=jiJinDao.selectAllJiJin();
        return jiJins;
    }

    /**
     * 根据搜索信息搜索
     * @param searchInfo
     * @return
     */

    @Override
    public List<JiJin> search(SearchInfo searchInfo) {
        List<JiJin> jiJins=jiJinDao.search(searchInfo);
        return jiJins;
    }

    /**
     * 搜索热销基金
     * @return
     */
    @Override
    public List<JiJin> selectHot() {
        List<JiJin> jiJins=jiJinDao.selectHot();
        return jiJins;
    }


}
