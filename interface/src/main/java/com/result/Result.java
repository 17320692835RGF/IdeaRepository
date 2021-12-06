package com.result;

import java.util.List;

public class Result {
    private Integer status;
    private Object data;

    public Result() {
    }

    public Result(Integer status, Object data) {
        this.status = status;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setUpdate(Integer num,
                          String objectName,String objectId){
        if(num!=0){
            this.setStatus(200);
            this.setData(objectName+":"+objectId+"更新成功");
        }else{
            this.setStatus(400);
            this.setData(objectName+":"+objectId+"更新失败");
        }
    }

    public void setDelete(Integer num,
                          String objectName,String objectId){
        if(num!=0){
            this.setStatus(200);
            this.setData(objectName+":"+objectId+"删除成功");
        }else{
            this.setStatus(400);
            this.setData(objectName+":"+objectId+"删除失败");
        }
    }

    public void setSelects(List results,String objectName){
        if(results.size()!=0){
            this.setStatus(200);
            this.setData(results);
        }else{
            this.setStatus(400);
            this.setData(objectName+"查询结果为空");
        }
    }

    public void setInsert(Integer num,String objectName,Object object){
        if(num!=0){
            this.setStatus(200);
            this.setData(objectName+"添加成功:"+object.toString());
        }else{
            this.setStatus(400);
            this.setData(objectName+"添加失败:"+object.toString());
        }
    }

    public void setExcept(String funName){
        this.setStatus(500);
        this.setData(funName+"执行时出错");
    }



    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
