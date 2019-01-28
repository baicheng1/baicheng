package com.duo.bai.cheng.web.admin.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.User;
import com.duo.bai.cheng.web.admin.dao.UserDao;
import com.duo.bai.cheng.web.admin.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User selectById(String id) {
        User user = userDao.selectById(id);
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public void changeType(User user) {
        userDao.changeType(user);
    }

    @Override
    public BaseResult save(User user) {
        //验证表单是否通过
        BaseResult baseResult = checkUser(user);
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            //表单验证通过
            if (user.getUid() == null) {
                //新增用户
                userDao.insert(user);
            } else {
                //编辑用户
                userDao.updateUser(user);
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
            userDao.deleteById(id);
            baseResult = BaseResult.success("删除成功");
        } else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }

    @Override
    public List<User> selectBySearch(String keyword) {
        List<User> users=userDao.selectBySearch(keyword);
        return users;
    }

    @Override
    public int count() {
        User user=new User();
        return userDao.count(user);
    }

    @Override
    public BaseResult deleteUsers(String ids) {
        BaseResult baseResult;
        //判空
        if(!StringUtils.isBlank(ids)){
            String[] id_arr = ids.split(",");
            userDao.deleteUsers(id_arr);
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
        int count=userDao.countBySearch(keyword);
        return count;
    }

    public BaseResult checkUser(User user) {
        BaseResult baseResult = BaseResult.success();
        if (StringUtils.isBlank(user.getUsername())) {
                baseResult = BaseResult.fail("用户名不能为空，请重新填写");
                return baseResult;
        }
        if (StringUtils.isBlank(user.getPassword())) {
            baseResult = BaseResult.fail("密码不能为空，请重新填写");
            return baseResult;
        }
        if (StringUtils.isBlank(user.getEmail())) {
            baseResult = BaseResult.fail("邮箱不能为空，请重新填写");
            return baseResult;
        }
        if (StringUtils.isBlank(user.getPhone())) {
            baseResult = BaseResult.fail("电话不能为空，请重新填写");
            return baseResult;
        }
        return baseResult;
    }


}
