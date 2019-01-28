package com.duo.bai.cheng.web.admin.web.controller;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Notice;
import com.duo.bai.cheng.web.admin.service.NoticeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("notice")
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @ModelAttribute
    public Notice getNotice(Integer id) {
        Notice notice = new Notice();
        if (id != null) {
            notice = noticeService.selectById(id);
        }
        return notice;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    //    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Notice> notices = noticeService.selectAllNotice();
        int count = noticeService.count();
        model.addAttribute("notices", notices);
        model.addAttribute("count", count);
        return "notice_list";
    }
    /**
     * 查看用户详情
     *
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail() {
        return "notice_detail";
    }


    @RequestMapping(value = "save", method = RequestMethod.GET)
    public String save(Model model,String id, int jiJinId, String noticeName, String noticeUrl, String noticeContent, String noticeType) {
        Notice notice=new Notice();
        if (id!=null&&id!=""){
            notice.setId(Integer.parseInt(id));
        }
        notice.setJiJinId(jiJinId);
        notice.setNoticeName(noticeName);
        notice.setNoticeUrl(noticeUrl);
        notice.setNoticeContent(noticeContent);
        notice.setNoticeType(noticeType);

        if (notice != null) {
            BaseResult baseResult = noticeService.save(notice);
            model.addAttribute("baseResult", baseResult);
            System.out.println(baseResult.getMessage());
        }

        return "redirect:/notice/list";
    }

    //    @ResponseBody
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model) {
        List<Object> jiJinId_ids=noticeService.selectAllJiJinId();
        model.addAttribute("jiJinId_ids",jiJinId_ids);
        System.out.println("============================="+jiJinId_ids);
        return "notice_form";
    }

    @ResponseBody
    @RequestMapping(value = "deleteById", method = RequestMethod.POST)
    public BaseResult deleteById(String id) {
        BaseResult baseResult = noticeService.deleteById(id);
        return baseResult;
    }

    //    @ResponseBody
    @RequestMapping(value = "selectBySearch", method = RequestMethod.POST)
    public String selectBySearch(String keyword, Model model) {
        System.out.println("搜索关键字=============================="+keyword);
        List<Notice> notices;
        if (StringUtils.isBlank(keyword)) {
            notices = noticeService.selectAllNotice();
        } else {
            notices = noticeService.selectBySearch(keyword);
        }
        int count = noticeService.countBySearch(keyword);
        model.addAttribute("notices", notices);
        model.addAttribute("count", count);
        return "notice_list";
    }

    @ResponseBody
    @RequestMapping(value = "deletemulti", method = RequestMethod.POST)
    public BaseResult deletemulti(String ids, Model model) {
        BaseResult baseResult = noticeService.deleteNotices(ids);
        model.addAttribute("baseResult",baseResult);
        return baseResult;
    }




    /**
     * 分页（搜索后）
     *
     * @param request
     * @param user
     * @return
     */
//    @ResponseBody
//    @RequestMapping(value = "page", method = RequestMethod.GET)
//    public PageInfo<User> page(HttpServletRequest request, User user) {
//        String strDraw = request.getParameter("draw");
//        String strStart = request.getParameter("start");
//        String strLength = request.getParameter("Length");
//        int draw = strDraw == null ? 1 : Integer.parseInt(strDraw);
//        int start = strStart == null ? 0 : Integer.parseInt(strStart);
//        int length = strLength == null ? 10 : Integer.parseInt(strLength);
//        PageInfo<User> pageInfo = userService.selectByPage(draw, start, length, user);
//        return pageInfo;
//    }
}
