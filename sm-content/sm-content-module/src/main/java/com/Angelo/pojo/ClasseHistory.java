package com.Angelo.pojo;

import java.io.Serializable;

public class ClasseHistory implements Serializable {
    private static final long serialVersionUID = 231604548074074262L;
     
    private Integer id;
     /**
     * 班级id
     */
    private Integer classeId;
     /**
     * 年级
     */
    private Integer year;
     /**
     * 班主任
     */
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClasseId() {
        return classeId;
    }

    public void setClasseId(Integer classeId) {
        this.classeId = classeId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}

