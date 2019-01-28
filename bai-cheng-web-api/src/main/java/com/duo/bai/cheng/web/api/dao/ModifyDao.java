package com.duo.bai.cheng.web.api.dao;

import com.duo.bai.cheng.domain.TbModify;
import org.springframework.stereotype.Repository;

@Repository
public interface ModifyDao {

    void update(TbModify tbModify);

    void updates(TbModify tbModify);

    void upnick(TbModify tbModify);

    void upnicks(TbModify tbModify);

    void upemail(TbModify tbModify);

    void upemails(TbModify tbModify);

    void upphone(TbModify tbModify);

    void upphones(TbModify tbModify);

    void upicard(TbModify tbModify);

    void upicards(TbModify tbModify);
}
