package com.gugee.ins.common.model.mysql.media;

import javax.persistence.*;

@Table(name = "ins_location")
public class InsLocation {
    @Id
    private Long id;

    /**
     * 地理位置id
     */
    @Column(name = "location_id")
    private Long locationId;

    /**
     * 地理位置名称
     */
    @Column(name = "location_name")
    private String locationName;

    /**
     * 映射字典地理位置id
     */
    @Column(name = "dic_location_id")
    private Long dicLocationId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取地理位置id
     *
     * @return location_id - 地理位置id
     */
    public Long getLocationId() {
        return locationId;
    }

    /**
     * 设置地理位置id
     *
     * @param locationId 地理位置id
     */
    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    /**
     * 获取地理位置名称
     *
     * @return location_name - 地理位置名称
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * 设置地理位置名称
     *
     * @param locationName 地理位置名称
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName == null ? null : locationName.trim();
    }

    /**
     * 获取映射字典地理位置id
     *
     * @return dic_location_id - 映射字典地理位置id
     */
    public Long getDicLocationId() {
        return dicLocationId;
    }

    /**
     * 设置映射字典地理位置id
     *
     * @param dicLocationId 映射字典地理位置id
     */
    public void setDicLocationId(Long dicLocationId) {
        this.dicLocationId = dicLocationId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}