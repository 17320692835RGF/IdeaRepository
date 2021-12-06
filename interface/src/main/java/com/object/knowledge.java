package com.object;

public class knowledge {
    private Integer knowledgeId;
    private String knowledgeName;
    private String knowledgeUrl;

    public knowledge() {
    }

    public knowledge(Integer knowledgeId, String knowledgeName, String knowledgeUrl) {
        this.knowledgeId = knowledgeId;
        this.knowledgeName = knowledgeName;
        this.knowledgeUrl = knowledgeUrl;
    }

    public Integer getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(Integer knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public String getKnowledgeName() {
        return knowledgeName;
    }

    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName;
    }

    public String getKnowledgeUrl() {
        return knowledgeUrl;
    }

    public void setKnowledgeUrl(String knowledgeUrl) {
        this.knowledgeUrl = knowledgeUrl;
    }

    @Override
    public String toString() {
        return "knowledge{" +
                "knowledgeId=" + knowledgeId +
                ", knowledgeName='" + knowledgeName + '\'' +
                ", knowledgeUrl='" + knowledgeUrl + '\'' +
                '}';
    }
}
