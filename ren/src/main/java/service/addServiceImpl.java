package service;

import dao.IStudentDao;
import dao.IStudentDaoImp;
import entity.User;

public class addServiceImpl implements addService {
    private IStudentDao DAO=new IStudentDaoImp();
    @Override
    public void add(User user) {
        DAO.add(user);
    }
}
