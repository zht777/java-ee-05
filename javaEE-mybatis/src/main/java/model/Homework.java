package model;

import java.util.Date;

public class Homework {

    private Long id;

    private String name;

    private String content;

    private String createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String homeworkTitle) {
        this.name = homeworkTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String homeworkTitle) {
        this.content = homeworkTitle;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
