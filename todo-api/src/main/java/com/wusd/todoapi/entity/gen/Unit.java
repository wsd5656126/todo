package com.wusd.todoapi.entity.gen;

public class Unit {
    private String unitId;

    private String itemId;

    private String unitName;

    private String unitContent;

    private Long createTime;

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId == null ? null : unitId.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public String getUnitContent() {
        return unitContent;
    }

    public void setUnitContent(String unitContent) {
        this.unitContent = unitContent == null ? null : unitContent.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}