package com.object;

public class news {
    private Integer newsId;
    private String newsName;
    private String newsFace;
    private String newsDate;
    private String newsFrom;
    private String newsUrl;
    private String newsAgencyUrl;

    public news() {
    }

    public news(Integer newsId, String newsName, String newsFace, String newsDate, String newsFrom, String newsUrl, String newsAgencyUrl) {
        this.newsId = newsId;
        this.newsName = newsName;
        this.newsFace = newsFace;
        this.newsDate = newsDate;
        this.newsFrom = newsFrom;
        this.newsUrl = newsUrl;
        this.newsAgencyUrl = newsAgencyUrl;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    public String getNewsFace() {
        return newsFace;
    }

    public void setNewsFace(String newsFace) {
        this.newsFace = newsFace;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsFrom() {
        return newsFrom;
    }

    public void setNewsFrom(String newsFrom) {
        this.newsFrom = newsFrom;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    public String getNewsAgencyUrl() {
        return newsAgencyUrl;
    }

    public void setNewsAgencyUrl(String newsAgencyUrl) {
        this.newsAgencyUrl = newsAgencyUrl;
    }

    @Override
    public String toString() {
        return "news{" +
                "newsId=" + newsId +
                ", newsName='" + newsName + '\'' +
                ", newsFace='" + newsFace + '\'' +
                ", newsDate='" + newsDate + '\'' +
                ", newsFrom='" + newsFrom + '\'' +
                ", newsUrl='" + newsUrl + '\'' +
                ", newsAgencyUrl='" + newsAgencyUrl + '\'' +
                '}';
    }
}
