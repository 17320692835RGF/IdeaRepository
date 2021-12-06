package com.object;

public class law {
    private Integer lawId;
    private String lawName;
    private String lawUrl;

    public law() {
    }

    public law(Integer lawId, String lawName, String lawUrl) {
        this.lawId = lawId;
        this.lawName = lawName;
        this.lawUrl = lawUrl;
    }

    public Integer getLawId() {
        return lawId;
    }

    public void setLawId(Integer lawId) {
        this.lawId = lawId;
    }

    public String getLawName() {
        return lawName;
    }

    public void setLawName(String lawName) {
        this.lawName = lawName;
    }

    public String getLawUrl() {
        return lawUrl;
    }

    public void setLawUrl(String lawUrl) {
        this.lawUrl = lawUrl;
    }

    @Override
    public String toString() {
        return "law{" +
                "lawId=" + lawId +
                ", lawName='" + lawName + '\'' +
                ", lawUrl='" + lawUrl + '\'' +
                '}';
    }
}
