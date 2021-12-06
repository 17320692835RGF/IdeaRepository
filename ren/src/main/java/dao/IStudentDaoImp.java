package dao;

import entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

public class IStudentDaoImp implements IStudentDao{
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());
    
    @Override
    public void add(User user) {
        String sql = "insert into user values(null,?,?,?)";
        int i = template.update(sql,user.getId(),user.getName(), user.getAge());
        System.out.println("受影响的行数"+i);
    }
}
