package com.qst.entity;

import java.io.Serializable;
import java.util.List;

public class GoodsType implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String typename;
    private GoodsType parentType;
    //为前台页面显示用
    private List<GoodsType> subType;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTypename() {
        return typename;
    }
    public void setTypename(String typename) {
        this.typename = typename;
    }
    public GoodsType getParentType() {
        return parentType;
    }
    public void setParentType(GoodsType parentType) {
        this.parentType = parentType;
    }
    public List<GoodsType> getSubType() {
        return subType;
    }
    public void setSubType(List<GoodsType> subType) {
        this.subType = subType;
    }
    
}