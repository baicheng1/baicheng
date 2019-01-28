package com.duo.bai.cheng.web.admin.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Notice;
import com.duo.bai.cheng.web.admin.dao.NoticeDao;
import com.duo.bai.cheng.web.admin.service.NoticeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeDao noticeDao;

    @Override
    public Notice selectById(Integer id) {
        Notice notice = noticeDao.selectById(id);
        return notice;
    }

    @Override
    public List<Notice> selectAllNotice() {
        List<Notice> notices = noticeDao.selectAllNotice();
        return notices;
    }

    @Override
    public BaseResult save(Notice notice) {
        //验证表单是否通过
        BaseResult baseResult = checkNotice(notice);
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            //表单验证通过
            if (notice.getId()==null) {
                //新增用户
                notice.setNoticeCreated(new Date());
                noticeDao.insert(notice);
            } else {
                //编辑用户
                noticeDao.updateNotice(notice);
            }
            baseResult.setMessage("用户保存成功");
        }
        //不通过 直接返回
        return baseResult;
    }

    @Override
    public BaseResult deleteById(String id) {
        BaseResult baseResult;
        //判断ids是否为空
        if (!StringUtils.isBlank(id)) {
            System.out.println("要删除的id：" + id);
            noticeDao.deleteById(id);
            baseResult = BaseResult.success("删除成功");
        } else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }

    @Override
    public List<Notice> selectBySearch(String keyword) {
        List<Notice> notices=noticeDao.selectBySearch(keyword);
        return notices;
    }

    @Override
    public int count() {
        Notice notice=new Notice();
        return noticeDao.count(notice);
    }

    @Override
    public BaseResult deleteNotices(String ids) {
        BaseResult baseResult;
        //判空
        if(!StringUtils.isBlank(ids)){
            String[] id_arr = ids.split(",");
            noticeDao.deleteNotices(id_arr);
            baseResult= BaseResult.success("删除成功");

        }else {
            baseResult= BaseResult.fail("删除失败");
        }
        return baseResult;
    }

//    @Override
//    public PageInfo<User> selectByPage(int draw, int start, int length, User user) {
//        PageInfo<User> pageInfo = new PageInfo<>();
//        pageInfo.setDraw(draw);
//        Map<String, Object> map = new HashMap<>();
//        pageInfo.setRecordsTotal(userDao.count(user));
//        pageInfo.setRecordsFiltered(userDao.count(user));
//        //将分页条件封装到map里面
//        map.put("start", start);
//        map.put("length", length);
//        map.put("user", user);
//        pageInfo.setData(userDao.selectByPage(map));
//        return pageInfo;
//    }

    @Override
    public int countBySearch(String keyword) {
        int count=noticeDao.countBySearch(keyword);
        return count;
    }

    @Override
    public  List<Object> selectAllJiJinId() {
        List<Object> jiJinId_ids=noticeDao.selectAllJiJinId();
        return jiJinId_ids;
    }

    public BaseResult checkNotice(Notice notice) {
        BaseResult baseResult = BaseResult.success();
        if (StringUtils.isBlank(notice.getNoticeName())) {
                baseResult = BaseResult.fail("公告名称不能为空，请重新填写");
                return baseResult;
        }
        if (StringUtils.isBlank(notice.getNoticeContent())) {
            baseResult = BaseResult.fail("公告内容不能为空，请重新填写");
            return baseResult;
        }
        if (StringUtils.isBlank(notice.getNoticeUrl())) {
            baseResult = BaseResult.fail("公告链接不能为空，请重新填写");
            return baseResult;
        }
        return baseResult;
    }


}
