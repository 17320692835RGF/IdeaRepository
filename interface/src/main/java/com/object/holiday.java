package com.object;

public class holiday {
    private Integer holidayId;
    private String holidayName;
    private String holidayDate;
    private String holidayReason;

    public holiday() {
    }

    public holiday(Integer holidayId, String holidayName, String holidayDate, String holidayReason) {
        this.holidayId = holidayId;
        this.holidayName = holidayName;
        this.holidayDate = holidayDate;
        this.holidayReason = holidayReason;
    }

    public Integer getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(Integer holidayId) {
        this.holidayId = holidayId;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public String getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(String holidayDate) {
        this.holidayDate = holidayDate;
    }

    public String getHolidayReason() {
        return holidayReason;
    }

    public void setHolidayReason(String holidayReason) {
        this.holidayReason = holidayReason;
    }

    @Override
    public String toString() {
        return "holiday{" +
                "holidayId=" + holidayId +
                ", holidayName='" + holidayName + '\'' +
                ", holidayDate='" + holidayDate + '\'' +
                ", holidayReason='" + holidayReason + '\'' +
                '}';
    }
}
