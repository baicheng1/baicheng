package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.commons.dto.PageInfo;
import com.duo.bai.cheng.commons.dto.SearchInfo;
import com.duo.bai.cheng.domain.JiJin;
import com.duo.bai.cheng.web.api.service.JiJinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("jijin")
public class JiJinController {
    @Autowired
    JiJinService jiJinService;

    @ModelAttribute
    public JiJin getJiJin(Integer id){
        JiJin jiJin=new JiJin();
        if (id!=null){
            jiJin=jiJinService.getJiJinById(id);
        }
        return jiJin;
    }
    /**
     * 根据order排序，获取基金信息
     * @return
     */
    @RequestMapping(value = "screen",method = RequestMethod.GET)
    public String screen(HttpServletRequest request, Model model){
        List<JiJin> jiJins = jiJinService.screen();
        model.addAttribute("jiJins",jiJins);
        return "list";
    }
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String search(HttpServletRequest request, Model model, SearchInfo searchInfo){
        System.out.println("searchInfo:========"+searchInfo.toString());
        List<JiJin> jiJins =jiJinService.search(searchInfo);
//        BaseResult baseResult=new BaseResult();
        model.addAttribute("jiJins",jiJins);
        return "list";
    }
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<JiJin> page(HttpServletRequest request, JiJin jiJin) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("Length");
        int draw = strDraw == null ? 1 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);
//        PageInfo<JiJin> pageInfo = jiJinService.selectByPage(draw, start, length, tbUser);
//        return pageInfo;
        return null;
    }
    @ResponseBody
    @RequestMapping(value = "showHot",method = RequestMethod.GET)
    public List<JiJin> showHot(Model model){
        List<JiJin> jiJins=jiJinService.selectHot();
        model.addAttribute("jiJins",jiJins);
        return jiJins;
    }
}
