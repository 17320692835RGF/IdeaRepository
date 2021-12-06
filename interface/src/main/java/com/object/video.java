package com.object;

public class video {
    private Integer videoId;
    private String videoName;
    private String videoUrl;

    public video() {
    }

    public video(Integer videoId, String videoName, String videoUrl) {
        this.videoId = videoId;
        this.videoName = videoName;
        this.videoUrl = videoUrl;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "video{" +
                "videoId=" + videoId +
                ", videoName='" + videoName + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
