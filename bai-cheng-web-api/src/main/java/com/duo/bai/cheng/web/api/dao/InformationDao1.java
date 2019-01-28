package com.duo.bai.cheng.web.api.dao;

import com.duo.bai.cheng.domain.Information;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InformationDao1 {
    List<Information> selectAllInfo();

    Information selectById(int id);
}
