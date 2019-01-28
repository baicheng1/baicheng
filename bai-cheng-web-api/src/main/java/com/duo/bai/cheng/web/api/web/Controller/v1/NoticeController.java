package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.domain.Notice;
import com.duo.bai.cheng.web.api.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("notice")
public class NoticeController {
    @Autowired
    NoticeService noticeService;
    @ResponseBody
    @RequestMapping(value = "showNotice" ,method = RequestMethod.GET)
    public List<Notice> showNotice(Model model){
        List<Notice> notices = noticeService.selectAllNotice();
        model.addAttribute("notices",notices);
        return notices;
    }
    @ResponseBody
    @RequestMapping(value = "showNoticeById",method = RequestMethod.GET)
    public Notice showNoticById(int id){
        Notice notice=noticeService.selectById(id);
        return notice;
    }
}
