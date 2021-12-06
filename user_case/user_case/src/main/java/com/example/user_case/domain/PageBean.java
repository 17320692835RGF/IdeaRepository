package com.example.user_case.domain;

import java.util.List;

/**
 * @ Author     ：Eric Lee
 * @ Date       ：Created in 18:37 2021/8/22
 * @ Description：
 * @ Modified By：
 * @ Version    : 1.0
 */
public class PageBean<T> {
    // 总记录条数
    private int totalCount;
    // 总页数
    private int totalPage;
    // 每页几条
    private int rows;
    // 当前页
    private int currentPage;
    // 每页具体的数据
    private List<T> list;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", rows=" + rows +
                ", currentPage=" + currentPage +
                ", list=" + list +
                '}';
    }
}
