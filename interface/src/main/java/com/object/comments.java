package com.object;

public class comments {
    private Integer commentId;
    private String commentTxt;
    private String commentDate;
    private String commentObject;
    private String userCount;

    public comments() {
    }

    public comments(Integer commentId, String commentTxt, String commentDate, String commentObject, String userCount) {
        this.commentId = commentId;
        this.commentTxt = commentTxt;
        this.commentDate = commentDate;
        this.commentObject = commentObject;
        this.userCount = userCount;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentTxt() {
        return commentTxt;
    }

    public void setCommentTxt(String commentTxt) {
        this.commentTxt = commentTxt;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentObject() {
        return commentObject;
    }

    public void setCommentObject(String commentObject) {
        this.commentObject = commentObject;
    }

    public String getUserCount() {
        return userCount;
    }

    public void setUserCount(String userCount) {
        this.userCount = userCount;
    }

    @Override
    public String toString() {
        return "comments{" +
                "commentId=" + commentId +
                ", commentTxt='" + commentTxt + '\'' +
                ", commentDate='" + commentDate + '\'' +
                ", commentObject='" + commentObject + '\'' +
                ", userCount='" + userCount + '\'' +
                '}';
    }
}
