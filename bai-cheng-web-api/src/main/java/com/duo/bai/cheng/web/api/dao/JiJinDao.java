package com.duo.bai.cheng.web.api.dao;

import com.duo.bai.cheng.commons.dto.SearchInfo;
import com.duo.bai.cheng.domain.JiJin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JiJinDao {
    JiJin getJiJinById(Integer id);

    List<JiJin> selectAllJiJin();


    List<JiJin> search(SearchInfo searchInfo);

    List<JiJin> selectHot();


}
