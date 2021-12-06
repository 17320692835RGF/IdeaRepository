package com.ssm.po;

/**
 * @Description
 * @Author
 * @Date 2021/9/16 0016 14:39
 */
public class GradeEx extends Grade{
    private String sno;
    private String sname;
    private String cno;
    private String cname;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
