package com.example.user_case.service.impl;

import com.example.user_case.dao.IUserDao;
import com.example.user_case.dao.impl.UserDaoImpl;
import com.example.user_case.domain.PageBean;
import com.example.user_case.domain.User;
import com.example.user_case.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：Eric Lee
 * @ Date       ：Created in 18:39 2021/8/22
 * @ Description：
 * @ Modified By：
 * @ Version    : 1.0
 */
public class UserServiceImpl implements UserService {

    private IUserDao dao = new UserDaoImpl();
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
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public User login(User user) {
        return dao.findUserByUserNameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        //
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage <= 0)
            currentPage = 1;

        PageBean<User> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);

        // 调用dao
        int start =  (currentPage - 1)*rows; // 这里需要乘以 rows才能跳转到那个显示页面
        List<User> list = dao.findByPage(start, rows, condition);
        pageBean.setList(list);
        //

        // totalCount
        int totalCount = dao.findTotalCount(condition);
        pageBean.setTotalCount(totalCount);

        // totalPage
        int totalPage = (totalCount%rows) == 0?totalCount/rows : (totalCount/rows+1);
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }


    public void deleteSelectedUser(String[] ids){
        if (ids !=null && ids.length >0){
            for (String id: ids){
                dao.delete(Integer.parseInt(id));
            }
        }
    }
}
