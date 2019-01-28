package com.duo.bai.cheng.web.api.dao;

import com.duo.bai.cheng.domain.TbOrder;
import com.duo.bai.cheng.domain.Tbcredit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditDao {
    List<Tbcredit> select(String name);

    List<TbOrder> selects(String name);
}
