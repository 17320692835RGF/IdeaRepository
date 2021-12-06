package com.neuedu.hebeigc_usercase.service.impl;

import com.neuedu.hebeigc_usercase.dao.IUserDao;
import com.neuedu.hebeigc_usercase.dao.impl.UserDapImpl;
import com.neuedu.hebeigc_usercase.domain.PageBean;
import com.neuedu.hebeigc_usercase.domain.User;
import com.neuedu.hebeigc_usercase.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：Eric Lee
 * @ Date       ：Created in 15:02 2021/8/30
 * @ Description：
 * @ Modified By：
 * @ Version    : 1.0
 */
public class UserServiceImpl implements UserService {
    private IUserDao dao = new UserDapImpl();

    @Override
    public List<User> findAll() {

        return dao.findAll();
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.valueOf(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.valueOf(id));
    }

    @Override
    public User login(User user) {

        return dao.findUserByUserNameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage <= 0)
            currentPage = 1;
        int start  = (currentPage - 1)*rows; // 这里需要乘以 rows才能跳转到那个显示页面  比如 愿意 0, 5, 10...
        List<User> list = dao.findByPage(start, rows, condition);

        // 要返回PageBean  上面的list知识其中的一部分
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        pageBean.setList(list);

        // 配置.setTotalCount();
        int totalCount = dao.findTotalCount(condition);
        pageBean.setTotalCount(totalCount);

        // 配置.setTotalPage();
        int totalPage = (totalCount%rows) == 0 ? totalCount/rows : (totalCount/rows + 1);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }

    @Override
    public void deleteSelectedUser(String[] ids) {
        if (ids != null && ids.length > 0){
            for (String id : ids)
                dao.delete(Integer.parseInt(id));
        }
    }
}
