package com.linewell.license.platform.security.facade.constants;

/**
 * @author wusy
 * Company: 南威软件股份有限公司
 * Createtime : 2019/7/25 15:10
 * Description : 区域和组织机构数据类型 1区域 2 组织机构
 */
public enum RegionTypeEnum {

    AREA(1 , "AREA"),
    ORG(2 , "ORG")
    ;

    private int index;

    private String code;

    RegionTypeEnum(int index, String code) {
        this.index = index;
        this.code = code;
    }

    public int getIndex() {
        return index;
    }

    public String getCode() {
        return code;
    }
}
