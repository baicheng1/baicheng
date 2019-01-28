package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.JiJin;
import com.duo.bai.cheng.web.api.service.JiJinService;
import com.duo.bai.cheng.web.api.service.JiJinService1;
import com.duo.bai.cheng.web.api.web.Controller.dto.JiJinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("${api.path.v1}/JiJins")
public class JiJinController1 {
    @Autowired
    JiJinService1 jiJinService1;

    //    查询所有基金
    @RequestMapping(value="All",method = RequestMethod.GET)
    public BaseResult findAll(){
        List<JiJinDTO> jiJins =jiJinService1.findAll();
        BaseResult baseResult = BaseResult.success(200,"成功", jiJins);
        System.out.println("====="+jiJins);
        return baseResult;


    }
    // 查询单个基金
    @RequestMapping(value="{id}",method = RequestMethod.GET)
    public BaseResult findOne(@PathVariable("id")int id){
        JiJinDTO jiJinDTO = jiJinService1.findOne(id);
        BaseResult baseResult = BaseResult.success(200,"成功",jiJinDTO);
        return baseResult;
    }
    //添加基金
    @RequestMapping(value="save",method = RequestMethod.GET)
    public BaseResult sava(JiJin jiJin){
        BaseResult baseResult=jiJinService1.add(jiJin);

        return  baseResult;
    }
    // 修改基金
    @RequestMapping(value="alter",method = RequestMethod.GET)
    public BaseResult alter(JiJinDTO jiJinDTO){
        BaseResult baseResult = BaseResult.success(200,"成功",null);
        return  baseResult;
    }
    // 删除基金
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public BaseResult delete(@PathVariable("id")int id){
        BaseResult baseResult=jiJinService1.delete(id);
        return baseResult;
    }
}
